package com.example.SpringTest.repository;

import com.example.SpringTest.entity.IngredientEntity
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository : JpaRepository<IngredientEntity, Long> {
}