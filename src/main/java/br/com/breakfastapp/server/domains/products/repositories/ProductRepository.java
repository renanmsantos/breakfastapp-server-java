package br.com.breakfastapp.server.domains.products.repositories;

import br.com.breakfastapp.server.domains.products.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.active = true ")
    List<Product> findAll();

    @Query("select p from Product p where p.id = :id and p.active = true ")
    Product findOneById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Product p set p.active = false where p.id = :id")
    void deleteById(@Param("id") Integer id);

}
