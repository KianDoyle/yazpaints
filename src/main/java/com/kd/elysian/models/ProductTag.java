package com.kd.elysian.models;

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
@Table(name = "product_tags", schema = "public")
public class ProductTag implements java.io.Serializable {
    
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)),
            @AttributeOverride(name = "tagId", column = @Column(name = "tag_id", nullable = false)) })
    private ProductTagId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable = false, updatable = false, nullable = false)
    private Product productId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tag_id", insertable = false, updatable = false, nullable = false)
    private Tag tagId;

    public ProductTag() {

    }

    public ProductTag(ProductTagId id, Product productId, Tag tagId) {
        this.id = id;
        this.productId = productId;
        this.tagId = tagId;
    }
}
