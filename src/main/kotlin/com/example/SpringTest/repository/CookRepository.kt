package com.example.SpringTest.repository


import com.example.SpringTest.entity.CookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CookRepository: JpaRepository<CookEntity, Long>
