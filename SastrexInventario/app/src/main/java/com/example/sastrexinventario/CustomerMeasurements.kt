package com.example.sastrexinventario

data class CustomerMeasurements(
    val shoulderWidth: Double,
    val chestSize: Double,
    val waistSize: Double,
    val sleeveLength: Double
) {
    operator fun minus(suit: Suit): String {
        val differences = """
            Diferencia manga: ${this.sleeveLength - suit.measurements.sleeveLength}
            Diferencia pecho: ${this.chestSize - suit.measurements.chestSize}
            Diferencia cintura: ${this.waistSize - suit.measurements.waistSize}
            Diferencia hombro: ${this.shoulderWidth - suit.measurements.shoulderWidth}
        """
        return differences
    }
}