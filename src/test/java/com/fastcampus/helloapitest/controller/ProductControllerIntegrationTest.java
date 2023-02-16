package com.fastcampus.helloapitest.controller;

import com.fastcampus.helloapitest.domain.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ProductControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String host = "http://localhost";
    @LocalServerPort
    private int port;

    @Test
    void findProductTest() {
        // given
        Long testProductId = 1_000L;
        URI testUrl = URI.create(host + ":" + port + "/products/" + testProductId);

        // when
        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(testUrl, ProductDTO.class);

        // then
        ProductDTO productDTO = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(productDTO);
        assertEquals("멋진 상품", productDTO.getName());
        assertEquals(BigDecimal.valueOf(15_000), productDTO.getPrice());
    }
}