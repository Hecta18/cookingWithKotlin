package com.example.sastrexinventario

sealed class FitResult {
    object PerfectFit : FitResult()
    //sin estado => object
    data class TooLoose(val areas: List<String>) : FitResult()
    data class TooTight(val areas: List<String>) : FitResult()
    // areas con desperfectos
}