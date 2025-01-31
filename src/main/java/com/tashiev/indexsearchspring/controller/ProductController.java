package com.tashiev.indexsearchspring.controller;

import com.tashiev.indexsearchspring.entity.Product;
import com.tashiev.indexsearchspring.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "API для управления продуктами")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "Получить продукты в диапазоне цен", description = "Возвращает список продуктов, цена которых находится в указанном диапазоне.")
    @GetMapping("/range")
    public List<Product> getProductsInPriceRange(
            @Parameter(description = "Минимальная цена", example = "10.0") @RequestParam double minPrice,
            @Parameter(description = "Максимальная цена", example = "50.0") @RequestParam double maxPrice) {
        return productService.getProductsInPriceRange(minPrice, maxPrice);
    }

    @Operation(summary = "Получить продукты, отсортированные по цене (по возрастанию)", description = "Возвращает список продуктов, отсортированных по цене в порядке возрастания.")
    @GetMapping("/sorted/asc")
    public List<Product> getProductsSortedByPriceAsc() {
        return productService.getProductsSortedByPriceAsc();
    }

    @Operation(summary = "Получить продукты, отсортированные по цене (по убыванию)", description = "Возвращает список продуктов, отсортированных по цене в порядке убывания.")
    @GetMapping("/sorted/desc")
    public List<Product> getProductsSortedByPriceDesc() {
        return productService.getProductsSortedByPriceDesc();
    }

    @Operation(summary = "Получить продукты в диапазоне цен с сортировкой по возрастанию", description = "Возвращает список продуктов, цена которых находится в указанном диапазоне, отсортированных по цене в порядке возрастания.")
    @GetMapping("/range-sorted")
    public List<Product> getProductsInPriceRangeSorted(
            @Parameter(description = "Минимальная цена", example = "10.0") @RequestParam double minPrice,
            @Parameter(description = "Максимальная цена", example = "50.0") @RequestParam double maxPrice) {
        return productService.getProductsInPriceRangeSorted(minPrice, maxPrice);
    }
}