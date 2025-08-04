package com.kd.elysian.entities;

import lombok.Getter;
import java.util.List;

import com.kd.elysian.models.File;
import com.kd.elysian.models.Product;
import com.kd.elysian.models.Review;
import com.kd.elysian.models.Tag;

@Getter
public class CompleteProduct {

    private Product product;
    private List<File> images;
    private List<Review> reviews;
    private List<Tag> tags;

    public CompleteProduct(Product product,
                           List<File> images, 
                           List<Review> reviews, 
                           List<Tag> tags) {
        this.product = product;
        this.images = images;
        this.reviews = reviews;
        this.tags = tags;
    }

    public String toJsonString() {
        return String.format("{\"id\": %d, \"productType\": \"%s\", \"name\": \"%s\", \"description\": \"%s\", \"price\": \"%s\", \"size\": \"%s\", \"images\": %s, \"reviews\": %s, \"tags\": %s}",
                product.getId(), product.getProductType(), product.getName(), product.getDescription(), product.getPrice(), product.getSize(), images.toString(), reviews.toString(), tags.toString());
    }
}
