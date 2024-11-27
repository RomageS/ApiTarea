package com.utch.alumno.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(setterPrefix = "with") //facilita los set y get
@Entity //Esta clase se trata como entidad de la DB
@AllArgsConstructor //Constructor con parametros
@NoArgsConstructor //Constructor vacio
@Table (name = "productosRMJ") //crea una tabla para el incremento

public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private double price;
    private String description;
}
