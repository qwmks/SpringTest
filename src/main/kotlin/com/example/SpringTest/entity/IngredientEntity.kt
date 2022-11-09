package com.example.SpringTest.entity

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name="Ingredients")
data class IngredientEntity (

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    var ingredientId: Long = 0,
    var ingredientName: String = "",
    var ingredientSource: String ="Khabarovsk",
    @ManyToMany
    var dishes: MutableList<DishEntity> = mutableListOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as IngredientEntity

        return ingredientId == other.ingredientId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(ingredientId = $ingredientName )"
    }
}