package com.example.myzoo

data class Parrot(
    val parrotName: String,
    val parrotAge: Int,
    val parrotHabitat: Habitats
) : Animal(parrotName, parrotHabitat, parrotAge), Flyable {
    override fun fly(): String {
        return "El loro $name está volando alto!"
    }
    override fun eat(): String {
        return "El loro $name está comiendo semillas."
    }
}
