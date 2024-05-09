package com.practice.backend.mapper;

import com.practice.backend.dto.ProductDto;
import com.practice.backend.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductMapper {
    @Autowired
    private static ModelMapper modelMapper;

    static{
        modelMapper = new ModelMapper();
    }

    public static Product convertToEntity(ProductDto productDto)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(productDto, Product.class);
    }

    public static ProductDto convertToDto(Product product)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(product,ProductDto.class);
    }
}
