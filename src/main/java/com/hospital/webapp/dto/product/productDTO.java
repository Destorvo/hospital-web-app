package com.hospital.webapp.dto.product;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class productDTO implements Serializable {
        final String name;
        final String description;
        final BigDecimal price;

    public productDTO(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
