package com.wesleysfernandes.benefithub.product.dto;

import java.math.BigDecimal;

public record CreateProductRequest(
        String code,
        String name,
        String description,
        BigDecimal minimumIncome
) {
}
