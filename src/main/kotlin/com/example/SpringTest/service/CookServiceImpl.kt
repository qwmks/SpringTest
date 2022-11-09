package com.example.SpringTest.service

import com.example.SpringTest.entity.CookEntity
import com.example.SpringTest.entity.DishEntity
import com.example.SpringTest.entity.IngredientEntity
import com.example.SpringTest.repository.CookRepository
import com.example.SpringTest.repository.DishRepository
import com.example.SpringTest.repository.IngredientRepository
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class CookServiceImpl(private val cookRepository: CookRepository,private val dishRepository: DishRepository,
                      private val ingredientRepository: IngredientRepository):CookService {

    init{
        if (!cookRepository.exists(Example.of(CookEntity(1,"Yulia","Leushina",4)))){
            var cook1=CookEntity(1,"Yulia","Leushina",4)
            var cook2=CookEntity(2,"Egor","Mokshin",5)
            var cook3=CookEntity(3,"Ivan","Dema",3)
            var cook4=CookEntity(4,"Yulia","Ivanova",4)

            var tomato = IngredientEntity(1,"Tomato")
            var mushroom = IngredientEntity(2,"Mushroom","Vladivostok")
            var cucumber = IngredientEntity(3,"Cucumber")
            var pasta = IngredientEntity(4,"Pasta","Milan")
            var chicken = IngredientEntity(5,"Сhicken fillet")

            var pizza=DishEntity(1,"Pizza",400)
            var salad=DishEntity(2,"Salad",150)
            var pastaTomato=DishEntity(3,"Pasta with tomatoes",400)
            var pastaChicken=DishEntity(4,"Pasta with chicken and cucumbers",500)
            var chickenChop=DishEntity(5,"Chicken chop",600)

            cookRepository.saveAll(
                listOf(
                    cook1,cook2,cook3,cook4
                )
            )

            dishRepository.saveAll(
                listOf(
                    pizza,
                    salad,
                    pastaTomato,
                    pastaChicken,
                    chickenChop
                )
            )

            ingredientRepository.saveAll(
                listOf(
                    tomato,
                    mushroom,
                    cucumber,
                    pasta,
                    chicken
                )
            )

            pizza.ingredients.addAll((listOf(tomato,mushroom,cucumber)))
            salad.ingredients.addAll((listOf(tomato,cucumber)))
            pastaTomato.ingredients.addAll(listOf(pasta,tomato))
            pastaChicken.ingredients.addAll(listOf(pasta,chicken,cucumber))
            chickenChop.ingredients.addAll(listOf(chicken,mushroom))
            dishRepository.saveAll(listOf(pizza,salad,pastaTomato,pastaChicken,chickenChop))

            tomato.dishes.addAll((listOf(pizza,salad)))
            mushroom.dishes.addAll((listOf(pizza,chickenChop)))
            cucumber.dishes.addAll((listOf(pizza,salad,pastaChicken)))
            pasta.dishes.addAll((listOf(pastaChicken,pastaTomato)))
            chicken.dishes.addAll((listOf(pastaChicken,chickenChop)))
            ingredientRepository.saveAll(listOf(tomato,mushroom,cucumber,pasta,chicken))

            cook1.dishes.addAll(listOf(salad))
            cook2.dishes.addAll(listOf(pastaChicken))
            cook3.dishes.addAll(listOf(pizza))
            cook4.dishes.addAll(listOf(pastaTomato,chickenChop))
            cookRepository.saveAll(listOf(cook1,cook2,cook3,cook4))
        }

    }

    override fun getAllCooks(): MutableList<CookEntity> {
        return cookRepository.findAll()
    }

    override fun getAllDishes(): MutableList<DishEntity> {
        return dishRepository.findAll()
    }

    override fun getAllIngredients(): MutableList<IngredientEntity> {
        return ingredientRepository.findAll()
    }
//    override fun getDishesByCook(cookEntity: CookEntity): List<DishEntity> {
//        return dishRepository.findAll(Example.of())
//    }

//    override fun getDishesByIngredient(ingredientEntity: IngredientEntity): List<DishEntity> {
//        TODO("Not yet implemented")
//    }

//    override fun getIngredientsByDish(dishEntity: DishEntity): List<IngredientEntity> {
//        TODO("Not yet implemented")
//    }

    override fun getCookById(id: Int): CookEntity {
        val defaultCook=CookEntity(404,"John","Doe", mutableListOf(),0)
        return  cookRepository.findById(id.toLong()).orElse(defaultCook)
    }

    override fun getCookByDish(dishEntity: DishEntity): CookEntity {
        return cookRepository.findAll().find {
            it.dishes.contains(dishEntity)
        }!!
    }

    override fun getIngredientById(id: Int): IngredientEntity {
        val defaultCook=IngredientEntity(404,"None","None", mutableListOf())
        return  ingredientRepository.findById(id.toLong()).orElse(defaultCook)
    }

    override fun getDishById(id: Int): DishEntity {
        val defaultCook=DishEntity(404,"None",0, mutableListOf())
        return  dishRepository.findById(id.toLong()).orElse(defaultCook)
    }


}

@Service
class DishServiceImpl(private val dishRepository: DishRepository):DishService {

    init{

        dishRepository.saveAll(
            listOf(

            )
        )
    }

    override fun getAllDishes(): MutableList<DishEntity> {
        return dishRepository.findAll()
    }

}

@Service
class IngredientServiceImpl(private val ingredientRepository: IngredientRepository):IngredientService {

    init{
        ingredientRepository.saveAll(
            listOf(

            )
        )
    }

    override fun getAllIngredients(): MutableList<IngredientEntity> {
        return ingredientRepository.findAll()
    }

}