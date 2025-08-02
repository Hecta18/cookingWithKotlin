package com.example.myzoo

abstract class Animal(
    val name: String,
    val habitat: Habitats,
    val age: Int

) {
    abstract fun eat(): String
    fun move(): String {return "$name se esta moviendo"}
}