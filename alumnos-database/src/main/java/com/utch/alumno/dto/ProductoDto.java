package com.utch.alumno.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor

public class ProductoDto {
    private Integer id;
    private String title;
    private double price;
    private String description;
}
