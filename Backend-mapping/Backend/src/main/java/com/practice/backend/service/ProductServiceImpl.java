package com.practice.backend.service;

import com.practice.backend.dto.ProductDto;
import com.practice.backend.entity.Product;
import com.practice.backend.entity.User;
import com.practice.backend.exception.NotFoundException;
import com.practice.backend.mapper.ProductMapper;
import com.practice.backend.mapper.UserMapper;
import com.practice.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDto getProductByID(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        return ProductMapper.convertToDto(product);

    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = ProductMapper.convertToEntity(productDto);
        product = productRepository.save(product);
        return ProductMapper.convertToDto(product);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        existingProduct.setPrice(Long.parseLong(productDto.getPrice()));
        existingProduct.setProductName(productDto.getProductName());
        existingProduct.setStatus(productDto.getStatus());

        Product updateProduct = productRepository.save(existingProduct);
        return ProductMapper.convertToDto(updateProduct);
    }

    @Override
    public void deleteProductById(int id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        productRepository.deleteById(id);
    }
}
