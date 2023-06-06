package ru.vados.easybot.Service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vados.easybot.Dto.ProductDto;
import ru.vados.easybot.Dto.ProductItem;
import ru.vados.easybot.Entity.ProductEntity;
import ru.vados.easybot.Repository.ProductRepository;
import ru.vados.easybot.Service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void addProduct(ProductDto.ProductCreateUpdate product){
        ProductEntity entity = new ProductEntity();
        entity.setManafacturer(product.getManafacturer());
        entity.setPrice(product.getPrice());
        entity.setSerialNumber(product.getSerialNumber());
        entity.setInStock(product.getInStock());
        entity.setCustomProperties(
                product.getCustomProperties().stream()
                        .map(a -> new ProductEntity.CustomProperties(a.getName(),a.getValue()))
                        .collect(Collectors.toList())
        );
        entity.setProductType(product.getType());
        productRepository.save(entity);
    }

    @Transactional
    public void updateProduct(ProductDto.ProductCreateUpdate product){
        ProductEntity entity = productRepository.findBySerialNumberAndManafacturer(product.getSerialNumber(),
                product.getManafacturer()).orElseThrow();
        entity.setManafacturer(product.getManafacturer());
        entity.setPrice(product.getPrice());
        entity.setSerialNumber(product.getSerialNumber());
        entity.setInStock(product.getInStock());
        entity.setCustomProperties(
                product.getCustomProperties().stream()
                        .map(a -> new ProductEntity.CustomProperties(a.getName(),a.getValue()))
                        .collect(Collectors.toList())
        );
        productRepository.save(entity);
    }

    @Transactional
    public ResponseEntity<List<ProductItem>> getAllByType(String type){
        return ResponseEntity.ok(productRepository.findAllByProductType(type).stream()
                .map(a -> convert(a))
                .collect(Collectors.toList())
        );

    }

    @Transactional
    public ResponseEntity<ProductItem> getById(Long id){
        return ResponseEntity.ok(
                convert(productRepository.findById(id).orElseThrow())
        );
    }

    ProductItem convert(ProductEntity entity){
        return new ProductItem(
                entity.getSerialNumber(),
                entity.getManafacturer(),
                entity.getPrice(),
                entity.getInStock(),
                entity.getProductType(),
                entity.getCustomProperties().stream()
                        .map(a -> new ProductItem.CustomProperties("afeg","aerg"))
                        .collect(Collectors.toList())
        );
    }
}
