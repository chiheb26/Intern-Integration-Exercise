package com.minotore.salesapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("sale")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sale {
    @Id
    private String id;
    private String libraryName;
    private String bookName;
    private Double bookPrice;
    private Long unitsSold;
}
