package ru.vados.easybot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;

@Value
public class ProductDto {

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class ProductCreateUpdate {
        Long serialNumber;
        String manafacturer;
        BigDecimal price;
        Long inStock;
        String type;
        List<CustomProperties> customProperties;
    }


    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class CustomProperties{
        String name;
        String value;
    }
}
