-- Sample data for Elysian DB - Ethereal Art Portfolio
-- Connect to the elysian-db database before running

\c "elysian-db"

-- Insert product types
INSERT INTO product_types (name) VALUES
    ('Digital Print'),
    ('Canvas Print'),
    ('Framed Print'),
    ('Metal Print'),
    ('Acrylic Print'),
    ('Fine Art Paper'),
    ('Photography Print');

-- Insert tags for color-focused ethereal art
INSERT INTO tags (name) VALUES
    ('Ethereal'),
    ('Dreamy'),
    ('Pastel'),
    ('Vibrant'),
    ('Monochrome'),
    ('Sunset'),
    ('Ocean'),
    ('Forest'),
    ('Abstract'),
    ('Landscape'),
    ('Portrait'),
    ('Macro'),
    ('Blue'),
    ('Pink'),
    ('Purple'),
    ('Gold'),
    ('Silver'),
    ('Turquoise'),
    ('Lavender'),
    ('Coral');

-- Insert products (ethereal art pieces)
INSERT INTO products (name, description, price, type_id, size) VALUES
    ('Celestial Dreams', 'An ethereal composition of soft purples and pinks that evoke the feeling of floating through cosmic clouds', '£45.00', 1, '30x40cm'),
    ('Ocean Whispers', 'Delicate turquoise and silver tones blend like morning mist over calm waters', '£65.00', 2, '50x70cm'),
    ('Golden Hour Reverie', 'Warm golden hues dance with coral pinks in this dreamlike sunset abstraction', '£85.00', 3, '40x60cm'),
    ('Lavender Fields Forever', 'Soft purple gradients reminiscent of endless lavender fields under twilight skies', '£55.00', 4, '35x50cm'),
    ('Moonlit Serenity', 'Monochromatic silver and blue tones create a peaceful nocturnal landscape', '£75.00', 5, '45x65cm'),
    ('Coral Reef Dreams', 'Vibrant coral, pink, and turquoise create an underwater fantasy world', '£50.00', 6, '30x45cm'),
    ('Forest Mist', 'Ethereal greens and soft whites capture the mysterious beauty of morning fog', '£60.00', 1, '40x55cm'),
    ('Sunset Mirage', 'Dreamy oranges, pinks, and purples blend in an otherworldly horizon', '£70.00', 2, '50x75cm'),
    ('Silver Cascade', 'Flowing silver and white tones create a waterfall of light and shadow', '£80.00', 3, '35x80cm'),
    ('Blush Botanicals', 'Soft pink and green hues form abstract floral shapes in dreamy composition', '£40.00', 7, '25x35cm'),
    ('Azure Infinity', 'Deep blues fade to ethereal whites in this calming abstract seascape', '£65.00', 4, '40x60cm'),
    ('Rose Gold Reverie', 'Warm rose gold tones create a luxurious, dreamy atmosphere', '£90.00', 5, '50x70cm');

-- Insert reviews
INSERT INTO reviews (rating, comment, reviewer_name, created_at) VALUES
    (5, 'Absolutely stunning! The colors are even more beautiful in person. Perfect for my bedroom.', 'Emma Thompson', '2024-11-15 14:30:00'),
    (4, 'Beautiful ethereal quality, though slightly smaller than expected. Still love it!', 'James Wilson', '2024-11-20 09:15:00'),
    (5, 'The color gradients are mesmerizing. Exactly what I was looking for my meditation space.', 'Sarah Chen', '2024-12-01 16:45:00'),
    (5, 'Outstanding quality and the most peaceful artwork I''ve ever owned. Highly recommend!', 'Michael Roberts', '2024-12-05 11:20:00'),
    (4, 'Lovely colors and good quality print. Shipping was fast too.', 'Lisa Anderson', '2024-12-10 13:55:00'),
    (5, 'This piece transformed my living room! The ethereal quality is exactly as described.', 'David Park', '2024-12-12 10:30:00'),
    (4, 'Beautiful artwork, though I wish there were more size options available.', 'Rachel Green', '2024-12-15 15:20:00'),
    (5, 'The color depth is incredible. It changes mood throughout the day with different lighting.', 'Tom Miller', '2024-12-18 08:45:00'),
    (5, 'Perfect addition to my art collection. The ethereal theme is so well executed.', 'Anna Williams', '2024-12-20 19:10:00'),
    (4, 'Great quality and fast delivery. The colors are soothing and beautiful.', 'Chris Johnson', '2024-12-22 14:25:00');

-- Insert orders
INSERT INTO orders (full_name, email, address) VALUES
    ('Emma Thompson', 'emma.thompson@email.com', '45 Meadow Lane, Bath, BA1 2QR'),
    ('James Wilson', 'j.wilson@email.co.uk', '12 Oak Street, Edinburgh, EH1 3BN'),
    ('Sarah Chen', 'sarah.chen@gmail.com', '78 Rose Gardens, Brighton, BN2 4LP'),
    ('Michael Roberts', 'mike.roberts@outlook.com', '23 Elm Avenue, Cambridge, CB2 1AB'),
    ('Lisa Anderson', 'lisa.anderson@email.com', '91 Willow Drive, Oxford, OX1 4DE'),
    ('David Park', 'david.park@gmail.com', '156 Cherry Close, York, YO1 7GH'),
    ('Rachel Green', 'rachel.green@email.co.uk', '34 Maple Road, Canterbury, CT1 2JK'),
    ('Tom Miller', 'tom.miller@outlook.com', '67 Birch Lane, Winchester, SO23 8MN');

-- Insert filters for browsing art
INSERT INTO filters (name) VALUES
    ('Color Palette'),
    ('Mood'),
    ('Style'),
    ('Size Category'),
    ('Price Range');

-- Insert product-tag relationships
INSERT INTO product_tags (product_id, tag_id) VALUES
    -- Celestial Dreams (product 1)
    (1, 1), (1, 2), (1, 3), (1, 15), (1, 16), (1, 9),
    -- Ocean Whispers (product 2)
    (2, 1), (2, 2), (2, 7), (2, 18), (2, 17), (2, 10),
    -- Golden Hour Reverie (product 3)
    (3, 1), (3, 6), (3, 16), (3, 20), (3, 9), (3, 4),
    -- Lavender Fields Forever (product 4)
    (4, 1), (4, 3), (4, 8), (4, 19), (4, 15), (4, 10),
    -- Moonlit Serenity (product 5)
    (5, 1), (5, 5), (5, 13), (5, 17), (5, 10), (5, 2),
    -- Coral Reef Dreams (product 6)
    (6, 1), (6, 7), (6, 4), (6, 14), (6, 18), (6, 20),
    -- Forest Mist (product 7)
    (7, 1), (7, 8), (7, 2), (7, 10), (7, 3),
    -- Sunset Mirage (product 8)
    (8, 1), (8, 6), (8, 2), (8, 4), (8, 9), (8, 10),
    -- Silver Cascade (product 9)
    (9, 1), (9, 17), (9, 5), (9, 9), (9, 10),
    -- Blush Botanicals (product 10)
    (10, 1), (10, 3), (10, 14), (10, 2), (10, 11),
    -- Azure Infinity (product 11)
    (11, 1), (11, 13), (11, 2), (11, 7), (11, 10),
    -- Rose Gold Reverie (product 12)
    (12, 1), (12, 16), (12, 14), (12, 4), (12, 9);

-- Insert product-review relationships
INSERT INTO product_reviews (product_id, review_id) VALUES
    (1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
    (6, 6), (7, 7), (8, 8), (9, 9), (10, 10),
    (1, 4), (3, 6), (5, 8), (12, 3), (11, 1);

-- Insert order-review relationships (customers reviewing after purchase)
INSERT INTO order_reviews (order_id, review_id) VALUES
    (1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
    (6, 6), (7, 7), (8, 8), (4, 9), (3, 10);

-- Insert filter data
INSERT INTO filter_data (filter_id, key, value) VALUES
    -- Color Palette filter
    (1, 'blues', 'Blue Tones'),
    (1, 'purples', 'Purple Tones'),
    (1, 'pinks', 'Pink Tones'),
    (1, 'golds', 'Gold Tones'),
    (1, 'silvers', 'Silver Tones'),
    (1, 'corals', 'Coral Tones'),
    (1, 'monochrome', 'Black & White'),
    -- Mood filter
    (2, 'serene', 'Serene & Peaceful'),
    (2, 'dreamy', 'Dreamy & Ethereal'),
    (2, 'vibrant', 'Vibrant & Energetic'),
    (2, 'calming', 'Calming & Meditative'),
    -- Style filter
    (3, 'abstract', 'Abstract'),
    (3, 'landscape', 'Landscape'),
    (3, 'macro', 'Macro/Close-up'),
    (3, 'portrait', 'Portrait'),
    -- Size Category filter
    (4, 'small', 'Small (up to 35cm)'),
    (4, 'medium', 'Medium (35-55cm)'),
    (4, 'large', 'Large (55cm+)'),
    -- Price Range filter
    (5, 'budget', 'Under £50'),
    (5, 'mid', '£50-£70'),
    (5, 'premium', '£70+');

-- Insert filter-tag relationships
INSERT INTO filter_tags (filter_id, tag_id) VALUES
    -- Color Palette filter tags
    (1, 13), (1, 14), (1, 15), (1, 16), (1, 17), (1, 18), (1, 19), (1, 20), (1, 5),
    -- Mood filter tags
    (2, 1), (2, 2), (2, 4), (2, 3),
    -- Style filter tags
    (3, 9), (3, 10), (3, 12), (3, 11),
    -- Themed tags for various filters
    (2, 6), (2, 7), (2, 8);

-- Insert site data (styling configuration)
-- INSERT INTO site_data (id, card_w, card_ar, p_colour, s_color) VALUES
--     (1, '320px', '4:5', '#8B7BA7', '#E8D5E0');