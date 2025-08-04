package com.kd.elysian.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductTagId implements java.io.Serializable{

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "tag_id", nullable = false)
    private Integer tagId;

    public ProductTagId() {
    }

    public ProductTagId(Integer productId, Integer tagId) {
        this.productId = productId;
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductTagId)) return false;

        ProductTagId that = (ProductTagId) o;

        if (!productId.equals(that.productId)) return false;
        return tagId.equals(that.tagId);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + tagId.hashCode();
        return result;
    }
}
