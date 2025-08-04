package com.kd.elysian.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductReviewId implements java.io.Serializable{

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "review_id", nullable = false)
    private Integer reviewId;

    public ProductReviewId() {
    }

    public ProductReviewId(Integer productId, Integer reviewId) {
        this.productId = productId;
        this.reviewId = reviewId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductReviewId)) return false;

        ProductReviewId that = (ProductReviewId) o;

        if (!productId.equals(that.productId)) return false;
        return reviewId.equals(that.reviewId);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + reviewId.hashCode();
        return result;
    }
}
