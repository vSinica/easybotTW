package ru.vados.easybot.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vados.easybot.Dto.ProductDto;
import ru.vados.easybot.Dto.ProductItem;
import ru.vados.easybot.Service.ProductService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PutMapping("addProduct")
    public void addProduct(@RequestBody ProductDto.ProductCreateUpdate product){
        productService.addProduct(product);
    }

    @PostMapping("updateProduct")
    public void updateProduct(@RequestBody ProductDto.ProductCreateUpdate product){
        productService.updateProduct(product);
    }

    @GetMapping("getAllProductByType/{type}")
    public ResponseEntity<List<ProductItem>> updateProduct(@PathVariable String type){
        return productService.getAllByType(type);
    }

    @GetMapping("getProductById/{id}")
    public ResponseEntity<ProductItem> updateProduct(@PathVariable Long id){
        return productService.getById(id);
    }
}
