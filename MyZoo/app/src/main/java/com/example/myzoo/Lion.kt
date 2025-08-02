package com.example.myzoo

data class Lion(
    //specific variables
    val lionName: String,
    val lionHabitat: Habitats,
    val lionAge: Int,
    val manesize: Int
    //inheritance
) : Animal(lionName, lionHabitat, lionAge) {
    //inherited fun
    override fun eat(): String {
        return "El león $name está comiendo carne."
    }
}
