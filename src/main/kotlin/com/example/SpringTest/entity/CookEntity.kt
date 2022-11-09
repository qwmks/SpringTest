package com.example.SpringTest.entity

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name="Cooks")
data class CookEntity (

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    var cookId: Long = 0,

    var cookName: String = "",

    var surname: String = "",
    @OneToMany
    var dishes: MutableList<DishEntity> = mutableListOf(),

    var score: Int = 0
){
    constructor(id: Long,name: String,surname: String,score: Int) : this(id, name,
        surname, mutableListOf(), score,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CookEntity

        return cookId == other.cookId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(name = $cookName )"
    }
}