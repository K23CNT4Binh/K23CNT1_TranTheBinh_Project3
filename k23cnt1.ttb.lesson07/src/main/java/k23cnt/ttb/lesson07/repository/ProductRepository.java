package k23cnt.ttb.lesson07.repository;

import k23cnt.ttb.lesson07.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
