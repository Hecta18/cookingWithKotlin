package com.example.sastrexinventario

//funcion de extension del metodo filter,agrega un contador, solo para secuencias
//producido con ayuda de IA

fun <T> Sequence<T>.filterWithCount(predicate: (T) -> Boolean): Pair<Sequence<T>, Int> {
    var count = 0
    val filteredSequence = this.filter {
        count++
        //la comprobacion del predicado ocurre despues del conteo
        predicate(it)
    }
    return Pair(filteredSequence, count)
}

//e-grafia
//Duck.ai. (s/f). Recuperado el 28 de julio de 2025, de https://duckduckgo.com/?q=how+does+reverse+substract+in+arm&t=newext&atb=v439-1&ia=chat