package ru.vados.easybot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vados.easybot.Entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findBySerialNumber(Long number);
    Optional<ProductEntity> findBySerialNumberAndManafacturer(Long number, String manafacturer);
    List<ProductEntity> findAllByProductType(String type);
}
