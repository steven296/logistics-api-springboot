package com.stevendev.apirest.domain.package_products;

import com.stevendev.apirest.domain.packages.Package;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "package_products")
@SQLDelete(sql = "UPDATE package_products SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class PackageProduct {
    @Id
    private UUID uuid = UUID.randomUUID();

    @NotNull
    private String code;

    private Double weight;

    @NotNull
    private String sku;

    private Integer quantity;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;

    @ManyToOne(fetch = FetchType.LAZY)
    private Package myPackage;
}

