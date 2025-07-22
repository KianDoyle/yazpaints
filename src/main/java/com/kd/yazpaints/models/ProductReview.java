package com.kd.yazpaints.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_reviews", schema = "public")
public class ProductReview implements java.io.Serializable {
    
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
            @AttributeOverride(name = "reviewId", column = @Column(name = "review_id", nullable = false)) })
    private ProductReviewId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false, nullable = false)
    private Product productId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", insertable = false, updatable = false, nullable = false)
    private Review reviewId;

    public ProductReview() {

    }

    public ProductReview(ProductReviewId id, Product productId, Review reviewId) {
        this.id = id;
        this.productId = productId;
        this.reviewId = reviewId;
    }
}
