package com.zemoso.assesment.service;

import com.zemoso.assesment.dao.ProductRepo;
import com.zemoso.assesment.dto.ProductDTO;
import com.zemoso.assesment.entity.Product;
import com.zemoso.assesment.exception.ProductNotFound;
import com.zemoso.assesment.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductRepo productRepo) {
        this.productMapper = productMapper;
        this.productRepo = productRepo;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productsList = productRepo.findAll();
        return productsList.stream()
                .map(productMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductById(int id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFound("Not Found : "+id));
        return productMapper.convertToDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.convertToEntity(productDTO);
        Product savedProduct = productRepo.save(product);
        return productMapper.convertToDTO(savedProduct);
    }

    @Override
    public String deleteProductById(int id) {
        productRepo.deleteById(id);
        return "Product deleted with id: " + id;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product existingProduct = productRepo.findById(productDTO.getId())
                .orElseThrow(() -> new ProductNotFound("Product not found"));
        existingProduct.setManufacturer(productDTO.getManufacturer());
        existingProduct.setTitle(productDTO.getTitle());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());
        Product updatedProduct = productRepo.save(existingProduct);
        return productMapper.convertToDTO(updatedProduct);

    }
}
