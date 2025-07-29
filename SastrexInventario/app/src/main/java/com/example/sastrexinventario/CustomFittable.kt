package com.example.sastrexinventario

interface CustomFittable {
    fun checkFit(customer: CustomerMeasurements): FitResult
}