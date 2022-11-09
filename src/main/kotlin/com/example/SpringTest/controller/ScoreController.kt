package com.example.SpringTest.controller

import com.example.SpringTest.service.CookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ScoreController(private val cookService: CookService) {

    //GET-запрос к корневой странице
    @GetMapping("/")
    fun getGreeting(model: Model):String{
        //модель хранит данные для страниц
        model.addAttribute("cooks"
            ,cookService.getAllCooks())
        //название страницы, которую нужно показать пользователю
        return "index"
    }

    @GetMapping("/dishes")
    fun getAllDishes(model: Model):String{
        //модель хранит данные для страниц
        model.addAttribute("dishes"
            ,cookService.getAllDishes())
        //название страницы, которую нужно показать пользователю
        return "dishes"
    }

    @GetMapping("/ingredients")
    fun getAllIngredients(model: Model):String{
        //модель хранит данные для страниц
        model.addAttribute("ingredients"
            ,cookService.getAllIngredients())
        //название страницы, которую нужно показать пользователю
        return "ingredients"
    }
    @GetMapping("/ingredients/{ingredientId}")
    fun getIngredient(@PathVariable ingredientId: String, model: Model): String {
        model["ingredient"] = cookService.getIngredientById(ingredientId.toInt())
        return "ingredientPage"
    }

    @GetMapping("/dishes/{dishId}")
    fun getDish(@PathVariable dishId: String, model: Model): String {
        model["dish"] = cookService.getDishById(dishId.toInt())
        model["selectedCook"]=cookService.getCookByDish(cookService.getDishById(dishId.toInt()))
        return "dishPage"
    }

    @GetMapping("/cooks/{cookId}")
    fun getCook(@PathVariable cookId: String, model: Model): String {
        model["cook"] = cookService.getCookById(cookId.toInt())
        return "cookPage"
    }
}