package com.springboot.models.mapper;


import com.springboot.models.dto.ProductDto;
import com.springboot.models.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
    public interface ProductMapper {

    ProductMapper instance = Mappers.getMapper(ProductMapper.class);
    ProductDto productEntityToProductDto(Product product);
    Product productDtoToProductEntity(ProductDto productDto);

    List<ProductDto> customersToCustomerDTOs(List<Product> customerList);
}

