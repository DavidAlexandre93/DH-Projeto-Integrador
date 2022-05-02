package br.com.meli.dhprojetointegrador.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.meli.dhprojetointegrador.entity.Product;
import br.com.meli.dhprojetointegrador.enums.CategoryEnum;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory_Name(CategoryEnum category);

    @Query("SELECT DISTINCT p FROM Product p JOIN p.batchStockList b")
    List<Product> orderProductByPrice(Sort sort);
}
