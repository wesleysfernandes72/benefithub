package com.wesleysfernandes.benefithub.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(
        UUID id,
        String code,
        String name,
        String description,
        BigDecimal minimumIncome,
        Boolean active
) {
}
