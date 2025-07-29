package com.example.sastrexinventario

class Suit(
    val style: String,
    val fabric: String,
    val measurements: CustomerMeasurements,
    private val id: Int
): Garment(fabric), CustomFittable {
    override fun checkFit(customer: CustomerMeasurements): FitResult {
        val tolerance = 1.0
        val looseAreas = mutableListOf<String>()
        val tightAreas = mutableListOf<String>()
        //shoulder
        if (this.measurements.shoulderWidth > customer.shoulderWidth + tolerance)
            looseAreas.add("hombros")
        if (this.measurements.shoulderWidth < customer.shoulderWidth - tolerance)
            tightAreas.add("hombros")
        //chest
        if (this.measurements.chestSize > customer.chestSize + tolerance)
            looseAreas.add("pecho")
        if (this.measurements.chestSize < customer.chestSize - tolerance)
            tightAreas.add("pecho")
        //cintura
        if (this.measurements.waistSize > customer.waistSize + tolerance)
            looseAreas.add("cintura")
        if (this.measurements.waistSize < customer.waistSize - tolerance)
            tightAreas.add("cintura")
        //manga
        if (this.measurements.sleeveLength > customer.sleeveLength + tolerance)
            looseAreas.add("manga")
        if (this.measurements.sleeveLength < customer.sleeveLength - tolerance)
            tightAreas.add("manga")

        if (looseAreas.isEmpty() && tightAreas.isEmpty()) return FitResult.PerfectFit
        if (looseAreas.isNotEmpty()) return FitResult.TooLoose(looseAreas)
        return FitResult.TooTight(tightAreas)
    }
    companion object Factory {
        private var id: Int = 0
        fun create(
             style: String, fabric: String,
            measurements: CustomerMeasurements
        ): Suit{
            id++
            return Suit(fabric, style, measurements, id)
        }
    }
}