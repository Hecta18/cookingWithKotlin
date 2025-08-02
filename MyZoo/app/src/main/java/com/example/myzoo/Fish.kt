package com.example.myzoo

data class Fish(
    //specific variables
    val fishName: String,
    val fishHabitat: Habitats,
    val fishAge: Int,
    //inheritance
): Animal(fishName, fishHabitat, fishAge) {
    //inherited fun
    override fun eat(): String {
        return "El pez $name está comiendo plancton."
    }
    override fun move(): String {
        return "El pez $name está nadando."
    }
}
