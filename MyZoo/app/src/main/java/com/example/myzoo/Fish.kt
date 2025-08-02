package com.example.myzoo

data class Fish(
    val fishName: String,
    val fishHabitat: Habitats,
    val fishAge: Int,
): Animal(fishName, fishHabitat, fishAge) {
    override fun eat(): String {
        return "El loro $name está comiendo semillas."
    }
    fun fly(): String {
        return "El loro $name está volando alto!"
    }
}
