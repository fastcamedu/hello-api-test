package com.fastcampus.helloapitest.controller;

import com.fastcampus.helloapitest.domain.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@RestController
public class ProductController {
    public Map<Long, ProductDTO> productMap = Map.of(
            1_000L, ProductDTO.of(1_000L, "멋진 상품", BigDecimal.valueOf(15_000)),
            2_000L, ProductDTO.of(2_000L, "끝내주는 상품", BigDecimal.valueOf(25_000))
    );

    @GetMapping(value = "/products/{productId}")
    public ProductDTO findById(@PathVariable(name = "productId") Long productId) {
        return productMap.get(productId);
    }

    @PostMapping(value = "/products")
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        productMap.put(productDTO.getId(), productDTO);
        return productDTO;
    }
}
