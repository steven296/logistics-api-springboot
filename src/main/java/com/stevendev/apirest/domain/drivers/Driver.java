package com.stevendev.apirest.domain.drivers;

import com.stevendev.apirest.domain.trucks.Truck;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "drivers")
@SQLDelete(sql = "UPDATE drivers SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class Driver {
    @Id
    private UUID uuid = UUID.randomUUID();

    @NotNull
    private String code;

    private String name;

    private String cellphone;

    private String email;

    private Boolean enabled;

    private Boolean is_deleted = Boolean.FALSE;

    private LocalDateTime deleted_at;

    @OneToOne(mappedBy = "driver", fetch = FetchType.LAZY)
    private Truck truck;
}
