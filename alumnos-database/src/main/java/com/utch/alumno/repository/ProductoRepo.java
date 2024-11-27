package com.utch.alumno.repository;

import com.utch.alumno.Entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<ProductoEntity, Integer> {
}
