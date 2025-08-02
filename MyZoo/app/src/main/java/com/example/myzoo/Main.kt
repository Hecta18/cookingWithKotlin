package com.example.myzoo

fun main(){
    //animals
    val leo: Animal = Lion("Leo", Habitats.JUNGLE, 12, 20)
    val nemo: Animal = Fish("Nemo", Habitats.AQUATIC, 10)
    val dory: Animal = Parrot("Dory", 2, Habitats.JUNGLE)
    val pat: Animal = Lion("Pat", Habitats.SAVANNAH, 45, 90)
    val gold: Animal = Fish("Gold", Habitats.AQUATIC, 10)
    //list of animals
    val animals: List<Animal> = listOf(leo, nemo, dory, pat, gold)
    //jungle animals
    val jungleAnimals: List<Animal> = animals.filter {it.habitat == Habitats.JUNGLE }
    //names of animals
    val animalNames: List<String> = animals.map {it.name}
    //group by habitats
    val animalHabitats: Map<Habitats, List<Animal>> = animals.groupBy { it.habitat }
    //showing results
    println(jungleAnimals)
    println(animalNames)
    println(animalHabitats)
    //higher order function
    fun processAnimals(animals: List<Animal>, action: (Animal) -> Unit) {
        //apply action to each animal
        for (animal in animals) {
            action(animal)
        }
    }
    //calling processAnimals
    processAnimals(animals) { animal -> println("${animal.name} tiene ${animal.age} años.") }
    //exhaustive when
    fun handleEvent(event: ZooEvent) {
        when (event) {
            is ZooEvent.AnimalFed -> println("${event.animalName} ya comio.")
            is ZooEvent.VisitorArrived -> println("¡Bienvenido, ${event.visitorName}!")
            is ZooEvent.ZooClosing -> println("El zoológico está cerrado.")
        }
    }
    //calling handleEvent
    handleEvent(ZooEvent.AnimalFed("Pat"))
    handleEvent(ZooEvent.VisitorArrived("Juancho"))
    handleEvent(ZooEvent.ZooClosing)
    //extension function
    fun Animal.getAnimalInfo(): String {
        return "nombre: $name, habitat: $habitat, edad: $age"
    }
    //calling extension function
    println(leo.getAnimalInfo())
    //using companion object
    val default = Animal.createDefaultAnimal()
    //showing result
    println(default)
}