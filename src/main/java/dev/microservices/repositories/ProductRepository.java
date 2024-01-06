package dev.microservices.repositories;

import dev.microservices.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);
}
