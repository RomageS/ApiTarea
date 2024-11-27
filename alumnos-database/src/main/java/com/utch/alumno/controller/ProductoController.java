package com.utch.alumno.controller;

import com.utch.alumno.dto.ProductoDto;
import com.utch.alumno.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Productormj")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Object> postProducto(@RequestBody ProductoDto productoDto) {
        Integer id = productoService.save(productoDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ProductoDto getById(@PathVariable int id) {
        return productoService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProducto(@PathVariable int id, @RequestBody ProductoDto productoDto) {
        ProductoDto updatedProducto = productoService.updateProducto(id, productoDto);

        if (updatedProducto != null) {
            return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProducto(@PathVariable int id) {
        boolean isDeleted = productoService.deleteById(id);

        if (isDeleted) {
            return new ResponseEntity<>("producto borrado exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
