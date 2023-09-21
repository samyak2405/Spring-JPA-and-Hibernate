package com.samyak.controller;
/**
 *
 */

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samyak.entity.Product;
import com.samyak.service.ProductService;

/**
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id){
        Optional<Product> product = productService.getProductById(id);
        if(product.isEmpty())
            return new ResponseEntity<String>("Product with Id: "+id+" not present",HttpStatus.NOT_FOUND);
        return new ResponseEntity<Product>(product.get(),HttpStatus.OK);
    }

    @GetMapping("/get-product-count")
    public ResponseEntity<String> getProductCount(){
        Long count = productService.getProductCount();
        return new ResponseEntity<String>("Total number of Products enteries: "+count,HttpStatus.OK);
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name){
        Product savedProduct = productService.getProductByName(name);
        return new ResponseEntity<Product>(savedProduct,HttpStatus.OK);
    }

    @GetMapping("/get-active-and-price/{active}/{price}")
    public ResponseEntity<List<Product>> getActiveAndPricedProduct(@PathVariable boolean active, @PathVariable BigDecimal price){
        List<Product> products = productService.getActiveAndPricedProduct(active,price);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-active-or-price/{active}/{price}")
    public ResponseEntity<List<Product>> getActiveOrPricedProduct(@PathVariable boolean active, @PathVariable BigDecimal price){
        List<Product> products = productService.getActiveOrPricedProduct(active,price);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-by-distinct-price/{price}")
    public ResponseEntity<List<Product>> getProductByDistinctPrice(@PathVariable("price") BigDecimal price){
        List<Product> products = productService.getProductByDistinctPrice(price);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-price-greater-than/{price}")
    public ResponseEntity<List<Product>> getProductByPriceGreaterThan(@PathVariable("price")BigDecimal price){
        List<Product> products = productService.getProductByPriceGreaterThan(price);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-price-less-than/{price}")
    public ResponseEntity<List<Product>> getProductByPriceLessThan(@PathVariable("price")BigDecimal price){
        List<Product> products = productService.getProductByPriceLessThan(price);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-product-by-name-containing/{name}")
    public ResponseEntity<List<Product>> getProductByNameContaining(@PathVariable("name")String name){
        List<Product> products = productService.getProductByNameContaining(name);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-product-by-name-like/{name}")
    public ResponseEntity<List<Product>> getProductByNameLike(@PathVariable("name")String name){
        List<Product> products = productService.getProductByNameLike(name);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-price-between/{start}/{end}")
    public ResponseEntity<List<Product>> getProductBetweenPrice(@PathVariable("start") BigDecimal startPrice,@PathVariable("end")BigDecimal endPrice){
        List<Product> products = productService.getProductBetweenPrice(startPrice,endPrice);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @GetMapping("/get-name-by-in")
    public ResponseEntity<List<Product>> getProductByNameIn(@RequestBody List<String> names){
        List<Product> products = productService.getProductByNameIn(names);
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Product>> saveAllProduct(@RequestBody List<Product> products){
        List<Product> savedProducts = productService.saveAllProducts(products);
        return new ResponseEntity<List<Product>>(savedProducts,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable("id")Long id,@RequestBody Product product){
        if(productService.getProductById(id).isEmpty())
            return new ResponseEntity<String>("Product with Id: "+id+" not present",HttpStatus.NOT_FOUND);
        Product updatedProduct = productService.updateProduct(id,product);
        return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id")Long id){
        if(productService.getProductById(id).isEmpty())
            return new ResponseEntity<String>("Product with Id: "+id+" not present",HttpStatus.NOT_FOUND);
        productService.deleteProductById(id);
        return new ResponseEntity<String>("Product with Id: "+id+" is deleted",HttpStatus.OK);
    }

    //Error
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody Product product){
        if(productService.getProductById(product.getId()).isEmpty())
            return new ResponseEntity<String>("Product with Id: "+product.getId()+" not present",HttpStatus.NOT_FOUND);
        productService.deleteProduct(product);
        return new ResponseEntity<String>("Product deleted successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteProduct(){
        productService.deleteAllProducts();
        return new ResponseEntity<String>("All products deleted",HttpStatus.OK);
    }

}

