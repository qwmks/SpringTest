package com.example.SpringTest.repository;


import com.example.SpringTest.entity.DishEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DishRepository : JpaRepository<DishEntity, Long> {
}