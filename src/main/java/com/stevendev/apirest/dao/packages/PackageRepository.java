package com.stevendev.apirest.dao.packages;
import com.stevendev.apirest.domain.packages.Package;
import com.stevendev.apirest.domain.packages.StatusType;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PackageRepository extends CrudRepository<Package, UUID> {
    List<Package> findAll();

    List<Package> findAllByCode(String code);

    List<Package> findAllByStatus(StatusType status);

    Optional<Package> findByCode(String code);

    Optional<Package> findByStatus(StatusType status);
}
