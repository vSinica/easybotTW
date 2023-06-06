package ru.vados.EasyBotTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import ru.vados.easybot.Dto.ProductDto;
import ru.vados.easybot.Repository.ProductRepository;
import ru.vados.easybot.Service.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
                "/sql/ddl-before-test.sql",
               // "/sql/prepare-test-set1.sql"
        })
})
public class ProductServiceTest extends AbstractTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;


    private static final Long NEW_SERIAL_NUMBER = 356436436543L;
    private static final String NEW_MANAFACTURER = "samsung";
    private static final String NEW_CUSTOM_PROP_NAME = "diagonal";
    private static final String NEW_CUSTOM_PROP_VALUE = "12";
    private static final Long IN_STOCK_COUNT = 111L;
    private static final String TYPE = "pc";


    @Test
    public void test__add_product() {
        List<ProductDto.CustomProperties> customs = new ArrayList<>();
        customs.add(new ProductDto.CustomProperties(NEW_CUSTOM_PROP_NAME,"12"));

        productService.addProduct (new ProductDto.ProductCreateUpdate(
                NEW_SERIAL_NUMBER,
                NEW_MANAFACTURER,
                new BigDecimal(345),
                IN_STOCK_COUNT,
                TYPE,
                customs
        ));

        productRepository.findBySerialNumber(NEW_SERIAL_NUMBER)
                .ifPresentOrElse((a) -> {
                            Assertions.assertEquals(NEW_MANAFACTURER, a.getManafacturer());
                            Assertions.assertEquals(IN_STOCK_COUNT, a.getInStock());
                            Assertions.assertEquals(NEW_CUSTOM_PROP_VALUE,a.getCustomProperties().get(0).getValue());
                        }, () -> {
                            Assertions.fail("not exist new product");
                        }
                );
    }



}
