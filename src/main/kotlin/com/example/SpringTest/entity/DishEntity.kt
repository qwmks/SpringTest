package com.example.SpringTest.entity

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.*

@Entity
@Table(name="Dishes")
data class DishEntity (

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    var dishId: Long = 0,
    var dishName: String = "",
    var price: Int=0,
    @ManyToMany
    @JoinTable(
        name = "Dish_to_Ingredient",
        joinColumns = [ JoinColumn(name = "dishId") ],
        inverseJoinColumns = [ JoinColumn(name = "ingredientId") ]
    )
    var ingredients: MutableList<IngredientEntity> = mutableListOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as DishEntity

        return dishId != null && dishId == other.dishId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(dishName = $dishName )"
    }
}

