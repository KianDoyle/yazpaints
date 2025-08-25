-- Essential database structure for elysian-db
-- Verified complete schema with all tables and relationships

-- Create database
CREATE DATABASE "elysian-db" WITH ENCODING = 'UTF8';

-- Connect to database
\c "elysian-db"

-- Core tables
CREATE TABLE files (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    type TEXT NOT NULL,
    location TEXT NOT NULL
);

CREATE TABLE reviews (
    id SERIAL PRIMARY KEY,
    rating INTEGER NOT NULL CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    reviewer_name TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product_types (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL
);

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    price TEXT NOT NULL,
    type_id INTEGER NOT NULL REFERENCES product_types(id),
    size TEXT
);

CREATE TABLE tags (
    id SERIAL PRIMARY KEY,
    name TEXT UNIQUE NOT NULL
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    full_name TEXT NOT NULL,
    email TEXT NOT NULL,
    address TEXT NOT NULL
);

CREATE TABLE filters (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE site_data (
    id SERIAL PRIMARY KEY CHECK (id = 1),
    card_w TEXT,
    card_ar TEXT,
    p_colour TEXT,
    s_color TEXT
);

-- Junction tables
CREATE TABLE product_images (
    product_id INTEGER REFERENCES products(id) ON DELETE CASCADE,
    file_id INTEGER REFERENCES files(id) ON DELETE CASCADE,
    PRIMARY KEY (product_id, file_id)
);

CREATE TABLE product_reviews (
    product_id INTEGER REFERENCES products(id) ON DELETE CASCADE,
    review_id INTEGER REFERENCES reviews(id) ON DELETE CASCADE,
    PRIMARY KEY (product_id, review_id)
);

CREATE TABLE product_tags (
    product_id INTEGER REFERENCES products(id) ON DELETE CASCADE,
    tag_id INTEGER REFERENCES tags(id) ON DELETE CASCADE,
    PRIMARY KEY (product_id, tag_id)
);

CREATE TABLE order_reviews (
    order_id INTEGER REFERENCES orders(id) ON DELETE CASCADE,
    review_id INTEGER REFERENCES reviews(id) ON DELETE CASCADE,
    PRIMARY KEY (order_id, review_id)
);

CREATE TABLE order_forms (
    order_id INTEGER REFERENCES orders(id) ON DELETE CASCADE,
    file_id INTEGER REFERENCES files(id) ON DELETE CASCADE,
    PRIMARY KEY (order_id, file_id)
);

CREATE TABLE order_invoices (
    order_id INTEGER REFERENCES orders(id) ON DELETE CASCADE,
    file_id INTEGER REFERENCES files(id) ON DELETE CASCADE,
    PRIMARY KEY (order_id, file_id)
);

CREATE TABLE filter_data (
    filter_id INTEGER REFERENCES filters(id) ON DELETE CASCADE,
    key TEXT NOT NULL,
    value TEXT NOT NULL,
    PRIMARY KEY (filter_id, key)
);

CREATE TABLE filter_tags (
    filter_id INTEGER REFERENCES filters(id) ON DELETE CASCADE,
    tag_id INTEGER REFERENCES tags(id) ON DELETE CASCADE,
    PRIMARY KEY (filter_id, tag_id)
);