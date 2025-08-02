package com.example.myzoo

data class Lion(
    val lionName: String,
    val lionHabitat: Habitats,
    val lionAge: Int,
    val manesize: Int
) : Animal(lionName, lionHabitat, lionAge) {
    override fun eat(): String {
        return "El león $name está comiendo carne."
    }
}
