package com.tashiev.indexsearchspring.service;
import com.tashiev.indexsearchspring.entity.Product;
import com.tashiev.indexsearchspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsInPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> getProductsSortedByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    public List<Product> getProductsSortedByPriceDesc() {
        return productRepository.findAllByOrderByPriceDesc();
    }

    public List<Product> getProductsInPriceRangeSorted(double minPrice, double maxPrice) {
        return productRepository.findProductsInPriceRangeSorted(minPrice, maxPrice);
    }
}