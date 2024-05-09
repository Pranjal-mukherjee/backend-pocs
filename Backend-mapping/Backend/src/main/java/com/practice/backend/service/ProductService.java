package com.practice.backend.service;

import com.practice.backend.dto.ProductDto;
import com.practice.backend.dto.UserDto;

public interface ProductService {
    ProductDto getProductByID(int id);
    ProductDto saveProduct(ProductDto productDto);
    ProductDto updateProduct(int id, ProductDto productDto);

    void deleteProductById(int id);
}
