package ru.vados.easybot.Service;

import org.springframework.http.ResponseEntity;
import ru.vados.easybot.Dto.ProductDto;
import ru.vados.easybot.Dto.ProductItem;
import ru.vados.easybot.Entity.ProductEntity;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDto.ProductCreateUpdate product);
    void updateProduct(ProductDto.ProductCreateUpdate product);
    ResponseEntity<List<ProductItem>> getAllByType(String type);
    ResponseEntity<ProductItem> getById(Long id);
}
