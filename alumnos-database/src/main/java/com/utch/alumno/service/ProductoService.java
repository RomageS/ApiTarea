package com.utch.alumno.service;

import com.utch.alumno.Entity.ProductoEntity;
import com.utch.alumno.dto.ProductoDto;
import com.utch.alumno.repository.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepo productoRepo;

    public ProductoService(ProductoRepo productoRepo){
        this.productoRepo = productoRepo;
    }

    public Integer save(ProductoDto productoDto) {
        return productoRepo.save(fromDtoToEntity(productoDto)).getId();
    }

    public List<ProductoDto> findAll() {
        return productoRepo.findAll().stream().map(this::fromEntityToDto).toList();
    }

    private ProductoEntity fromDtoToEntity(ProductoDto productoDto) {
        return ProductoEntity.builder()
                .withTitle(productoDto.getTitle())
                .withDescription(productoDto.getDescription())
                .withPrice(productoDto.getPrice())
                .build();
    }

    private ProductoDto fromEntityToDto(ProductoEntity productoEntity) {
        return ProductoDto.builder()
                .withId(productoEntity.getId())
                .withTitle(productoEntity.getTitle())
                .withDescription(productoEntity.getDescription())
                .withPrice(productoEntity.getPrice())
                .build();
    }

    public ProductoDto findById(Integer id) {
        Optional<ProductoEntity> optionalUser = productoRepo.findById(id);
        return optionalUser.map(this::fromEntityToDto).orElse(null); // Devuelve DTO o null si no se encuentra
    }

    public boolean deleteById(Integer id) {
        Optional<ProductoEntity> optionalproducto = productoRepo.findById(id);

        if (optionalproducto.isPresent()) {
            productoRepo.deleteById(id);
            return true; // Indica que el usuario fue eliminado exitosamente
        }

        return false; // Indica que no se encontró el usuario con el ID especificado
    }

    public ProductoDto updateProducto(int id, ProductoDto productoDto) {
        // Buscar el vehículo por ID
        Optional<ProductoEntity> optionalProducto = productoRepo.findById(id);

        if (optionalProducto.isPresent()) {
            // Actualizar los campos de la entidad existente con los valores del DTO
            ProductoEntity existingProducto = optionalProducto.get();

                    existingProducto.setTitle(productoDto.getTitle());
                    existingProducto.setDescription(productoDto.getDescription());
                    existingProducto.setPrice(productoDto.getPrice());

            // Guardar los cambios en la base de datos
            ProductoEntity updatedproduto = productoRepo.save(existingProducto);

            // Convertir la entidad actualizada a DTO y devolverla
            return fromEntityToDto(updatedproduto);
        }

        // Si no se encuentra el vehículo, retornar null o lanzar una excepción
        return null;
    }
}
