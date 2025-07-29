package com.example.sastrexinventario

class Suit(
    fabric: String, style: String,
   measurements: CustomerMeasurements, id: Int
): Garment(fabric), CustomFittable {
    override fun checkFit(customer: CustomerMeasurements) {
        TODO("Not yet implemented")
        //placeholder
    }
    companion object Factory {
        private var id: Int = 0
        private fun create(
            fabric: String, style: String,
            measurements: CustomerMeasurements
        ): Suit{
            id++
            return Suit(fabric, style, measurements, id)
        }
    }
}