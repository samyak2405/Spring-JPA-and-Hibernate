/**
 *
 */
package com.samyak.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samyak.entity.Product;
import com.samyak.repository.ProductRepository;

/**
 *
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Save Product
     * @param product
     * @return product
     */
    public Product saveProduct(Product product) {
        // TODO Auto-generated method stub
        return productRepository.save(product);
    }

    /**
     * Get all products
     * @return List of products
     */
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

    /**
     * Get product by id
     * @param id
     * @return product if present
     */
    public Optional<Product> getProductById(Long id) {
        // TODO Auto-generated method stub
        return productRepository.findById(id);
    }

    /**
     * Update product with Id
     * @param id
     * @param productUpdate
     * @return updatedProduct
     */
    public Product updateProduct(Long id,Product productUpdate) {
        // TODO Auto-generated method stub
        Product product = productRepository.findById(id).get();
        product.setSku(productUpdate.getSku());
        product.setName(productUpdate.getName());
        product.setDescription(productUpdate.getDescription());
        product.setPrice(productUpdate.getPrice());
        product.setImageUrl(productUpdate.getImageUrl());
        product.setActive(productUpdate.isActive());
        return productRepository.save(product);
    }

    /**
     * Delete product by Id
     * @param id
     */
    public void deleteProductById(Long id) {
        // TODO Auto-generated method stub
        productRepository.deleteById(id);
    }

    /**
     * Save All products
     * @param products
     * @return List of products
     */
    public List<Product> saveAllProducts(List<Product> products) {
        // TODO Auto-generated method stub
        return productRepository.saveAll(products);
    }

    /**
     * Delete product
     * @param product
     */
    public void deleteProduct(Product product) {
        // TODO Auto-generated method stub
        productRepository.delete(product);
    }

    /**
     * Delete all products
     */
    public void deleteAllProducts() {
        // TODO Auto-generated method stub
        productRepository.deleteAll();
    }

    /**
     * Get product count
     * @return product count
     */
    public Long getProductCount() {
        // TODO Auto-generated method stub
        return productRepository.count();
    }

    /**
     * Find Product by Name
     * @param name
     * @return product
     */
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    /**
     * Find Products that is Active and Price equals
     * @param active
     * @param price
     * @return List of products
     */
    public List<Product> getActiveAndPricedProduct(boolean active, BigDecimal price) {
        return productRepository.findByActiveAndPrice(active,price);
    }

    /**
     * Find Products that is Active or Price equals
     * @param active
     * @param price
     * @return list of products
     */
    public List<Product> getActiveOrPricedProduct(boolean active, BigDecimal price) {
        return productRepository.findByActiveOrPrice(active,price);
    }

    /**
     * Find product with distinct prices
     * @param price
     * @return list of products
     */
    public List<Product> getProductByDistinctPrice(BigDecimal price) {
        return productRepository.findDistinctByPrice(price);
    }

    /**
     * Find product with price greater than
     * @param price
     * @return list of product
     */
    public List<Product> getProductByPriceGreaterThan(BigDecimal price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    /**
     * Find products with price less than
     * @param price
     * @return list of products
     */
    public List<Product> getProductByPriceLessThan(BigDecimal price) {
        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> getProductByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }

    public List<Product> getProductByNameLike(String name) {
        return productRepository.findByNameLike(name);
    }

    public List<Product> getProductBetweenPrice(BigDecimal startPrice, BigDecimal endPrice) {
        return productRepository.findByPriceBetween(startPrice,endPrice);
    }

    public List<Product> getProductByNameIn(List<String> names) {
        return productRepository.findByNameIn(names);
    }
}
