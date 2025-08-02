package com.example.myzoo

abstract class Animal(
    val name: String,
    //enum of habitats
    val habitat: Habitats,
    val age: Int
) {
    //abstract
    abstract fun eat(): String
    //specific
    open fun move(): String {return "$name se esta moviendo"}
    //companion object
    companion object {
        fun createDefaultAnimal(): Animal {
            return Fish("Pez Anonimo", Habitats.AQUATIC, 1)
        }
    }
}