package br.com.breakfastapp.server.domains.products.repositories;

import br.com.breakfastapp.server.domains.products.domains.Category;
import br.com.breakfastapp.server.domains.products.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("select c from Category c where c.active = true ")
    List<Category> findAll();

    @Query("select c from Category c where c.id = :id and c.active = true ")
    Category findOneById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Category c set c.active = false where c.id = :id")
    void deleteById(@Param("id") Integer id);

}
