package com.zemoso.assesment.service;

import com.zemoso.assesment.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getProductById(int id);
    public ProductDTO createProduct(ProductDTO productDTO);
    public String deleteProductById(int id);
    public ProductDTO updateProduct(ProductDTO productDTO);

}
