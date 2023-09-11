package com.stevendev.apirest.domain.packages;

import com.stevendev.apirest.domain.package_products.PackageProduct;
import com.stevendev.apirest.domain.trucks.Truck;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "packages")
@SQLDelete(sql = "UPDATE packages SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class Package {
    @Id
    private UUID uuid = UUID.randomUUID();

    @NotNull
    private String code;

    private Double weight;

    private LocalDateTime schedule;

    @Enumerated(EnumType.STRING)
    private StatusType status = StatusType.LOADED;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;

    @OneToMany(mappedBy = "myPackage")
    private Set<PackageProduct> products;

    @ManyToOne(fetch = FetchType.LAZY)
    private Truck truck;
}
