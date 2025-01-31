package com.tashiev.indexsearchspring.repository;

import com.tashiev.indexsearchspring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Поиск продуктов в диапазоне цен
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Сортировка продуктов по цене (по возрастанию)
    List<Product> findAllByOrderByPriceAsc();

    // Сортировка продуктов по цене (по убыванию)
    List<Product> findAllByOrderByPriceDesc();

    // Пример запроса с использованием @Query
    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice AND p.price <= :maxPrice ORDER BY p.price ASC")
    List<Product> findProductsInPriceRangeSorted(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);
}