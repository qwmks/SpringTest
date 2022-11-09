package com.example.SpringTest.service

import com.example.SpringTest.entity.CookEntity
import com.example.SpringTest.entity.DishEntity
import com.example.SpringTest.entity.IngredientEntity
import com.example.SpringTest.repository.CookRepository

interface CookService {
    fun getAllCooks(): MutableList<CookEntity>
    fun getAllIngredients(): MutableList<IngredientEntity>
    fun getAllDishes(): MutableList<DishEntity>
    fun getCookById(id:Int): CookEntity
    fun getIngredientById(id:Int): IngredientEntity
    fun getDishById(id:Int): DishEntity
    fun getCookByDish(dishEntity: DishEntity): CookEntity
//    fun getDishesByCook(cookEntity: CookEntity): List<DishEntity>
//    fun getDishesByIngredient(ingredientEntity: IngredientEntity): List<DishEntity>
//    fun getIngredientsByDish(dishEntity: DishEntity): List<IngredientEntity>
}

interface DishService {
    fun getAllDishes(): MutableList<DishEntity>
}

interface IngredientService {
    fun getAllIngredients(): MutableList<IngredientEntity>
}