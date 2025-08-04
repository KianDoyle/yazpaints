package com.kd.elysian.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductImageId implements java.io.Serializable{

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "file_id", nullable = false)
    private Integer fileId;

    public ProductImageId() {
    }

    public ProductImageId(Integer productId, Integer fileId) {
        this.productId = productId;
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductImageId)) return false;

        ProductImageId that = (ProductImageId) o;

        if (!productId.equals(that.productId)) return false;
        return fileId.equals(that.fileId);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + fileId.hashCode();
        return result;
    }
}
