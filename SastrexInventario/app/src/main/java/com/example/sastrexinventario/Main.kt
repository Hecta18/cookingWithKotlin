package com.example.sastrexinventario

fun main() {
    val customer = CustomerMeasurements(46.0, 98.0, 82.0, 63.0)
    val inventory: Sequence<Suit> = listOf(
        Suit.create("Clásico", "Lana", CustomerMeasurements(48.0, 100.0, 85.0,
            62.0)),
        Suit.create("Moderno", "Lino", CustomerMeasurements(50.0, 102.0, 88.0,
            64.0)),
        Suit.create("Slim Fit", "Lana", CustomerMeasurements(46.0, 98.0, 82.0,
            63.0))
    ).asSequence()
    fun CustomerMeasurements.summary() {
        "%.2f".format(this.chestSize, this.waistSize, this.sleeveLength, this.shoulderWidth)
        println(this.chestSize + this.waistSize + this.sleeveLength + this.shoulderWidth)
    }
    //consultas
    val (search1, countIteration) = inventory.filterWithCount  { it.fabric == "Lana" }
    val search2: Sequence<String> = inventory.map { suit: Suit -> suit.fabric }
    val search3: Map<String, List<Suit>> = inventory.groupBy { it.fabric }
    val search4 = inventory.find { it.checkFit(customer) == FitResult.PerfectFit }

    println(search1)
    println(search2)
    println(search3)
    customer.summary()
    println(customer - search4 as Suit)
}