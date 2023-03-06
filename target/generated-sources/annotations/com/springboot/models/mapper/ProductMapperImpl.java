package com.springboot.models.mapper;

import com.springboot.models.dto.ProductDto;
import com.springboot.models.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-06T22:47:51+0530",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productEntityToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        return productDto;
    }

    @Override
    public Product productDtoToProductEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );

        return product;
    }

    @Override
    public List<ProductDto> customersToCustomerDTOs(List<Product> customerList) {
        if ( customerList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( customerList.size() );
        for ( Product product : customerList ) {
            list.add( productEntityToProductDto( product ) );
        }

        return list;
    }
}
