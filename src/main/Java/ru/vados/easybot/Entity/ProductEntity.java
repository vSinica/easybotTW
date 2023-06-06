package ru.vados.easybot.Entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private Long serialNumber;

    private String manafacturer;

    private BigDecimal price;

    private Long inStock;

    private String productType;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<CustomProperties> customProperties;

    @Value
    public static class CustomProperties{
        String name;
        String value;
    }
}
