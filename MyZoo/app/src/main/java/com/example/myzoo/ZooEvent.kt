package com.example.myzoo

sealed class ZooEvent {
    data class AnimalFed(val animalName: String) : ZooEvent()
    data class VisitorArrived(val visitorName: String) : ZooEvent()
    object ZooClosing : ZooEvent()
}