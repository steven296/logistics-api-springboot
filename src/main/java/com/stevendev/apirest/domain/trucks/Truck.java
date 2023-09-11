package com.stevendev.apirest.domain.trucks;

import com.stevendev.apirest.domain.drivers.Driver;
import com.stevendev.apirest.domain.packages.Package;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "trucks")
@SQLDelete(sql = "UPDATE trucks SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class Truck {
    @Id
    private UUID uuid = UUID.randomUUID();

    @NotNull
    private String code;

    private Boolean enabled;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;


    @OneToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @OneToMany(mappedBy = "truck")
    private Set<Package> packages;
}
