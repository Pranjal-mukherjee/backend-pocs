package com.zemoso.assesment.mapper;

import com.zemoso.assesment.dto.ProductDTO;
import com.zemoso.assesment.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;
 @Autowired
    public ProductMapper(ModelMapper modelMapper){
     this.modelMapper=modelMapper;
 }
 public ProductDTO convertToDTO(Product product){
     return modelMapper.map(product, ProductDTO.class);
 }
    public Product convertToEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }

}
