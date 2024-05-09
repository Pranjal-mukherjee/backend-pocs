package com.zemoso.assesment.controller;

import com.zemoso.assesment.dto.ProductDTO;
import com.zemoso.assesment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @PostMapping("/")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }
    @PutMapping("/")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id){
        return  productService.deleteProductById(id);
    }
}
