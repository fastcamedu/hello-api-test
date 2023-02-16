package com.fastcampus.helloapitest.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data(staticConstructor = "of")
public class ProductDTO {
    private final Long id;
    private final String name;
    private final BigDecimal price;
}
