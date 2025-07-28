package com.example.pokebattle

import java.util.Locale

enum class PokemonType {
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    ROCK
}

enum class Status {
    NORMAL,
    BURNED,
    PARALYZED
}


data class Pokemon(
    val name: String,
    val type: PokemonType,
    val maxHP: Int,
    var currentHP: Double,
//  initial value set at construction, the same as
//  maxHP but double
    val attackStat: Int,
    val defenseStat: Int,
//  defense is what percentage of the other pokemon attack is damage, the lower the better
    var status: Status
//  always initialize NORMAL
) {

    //FUNCTIONS
    fun attack(attacker: Pokemon, target: Pokemon): String {
        var message: String
        //emulation of 20% chance to fail
        if ((1..5).random() != 1) {
            message = "${attacker.name} attacked ${target.name} for ${damage(attacker, target)} damage!"
            when (attacker.type) {
                PokemonType.FIRE -> {
                    target.status = Status.BURNED
                    message += "\n${target.name} burned!"
                    return message
                }

                PokemonType.ELECTRIC -> {
                    target.status = Status.PARALYZED
                    message += "\n${target.name} paralyzed!"
                    return message
                }

                else -> {
                    return message
                }
            }
        } else {
            message = "${attacker.name} missed the attack!"
            return message
        }
    }

    fun damage(attacker: Pokemon, target: Pokemon): String {
        val defense: Double = target.defenseStat.toDouble() / 100
        val damage = attacker.attackStat * defense * getTypeMultiplier(attacker, target)
        val formattedDamage = String.format(Locale.getDefault(), "%.2f", damage)
        target.currentHP -= damage
        return formattedDamage
    }

    fun getTypeMultiplier(attacker: Pokemon, target: Pokemon): Double {
        return when (attacker.type) {
            PokemonType.GRASS -> when (target.type) {
                PokemonType.ROCK -> 2.0
                PokemonType.FIRE -> 0.5
                else -> 1.0
            }

            PokemonType.FIRE -> when (target.type) {
                PokemonType.WATER -> 0.5
                PokemonType.GRASS -> 2.0
                PokemonType.ROCK -> 0.5
                else -> 1.0
            }

            PokemonType.WATER -> when (target.type) {
                PokemonType.FIRE -> 2.0
                else -> 1.0
            }

            PokemonType.ELECTRIC -> when (target.type) {
                PokemonType.WATER -> 2.0
                else -> 1.0
            }

            else -> 1.0
        }
    }
}


// Battle functions
fun applyPostTurnEffects(target: Pokemon): String {
    val damage = target.currentHP * 0.05 //5% of max HP
    val formattedDamage = String.format(Locale.getDefault(), "%.2f", damage)
    when (target.status) {
        Status.BURNED -> {
            target.currentHP -= damage
            return "Burn dealt $formattedDamage damage!"
        }
        Status.PARALYZED -> {
            return "${target.name} is paralyzed! It can't move"
        }
        else -> {return "${target.name} has no status effect"}
    }
}

fun checkParalysis(attacker: Pokemon, index: Int): Int {
    if (attacker.status == Status.PARALYZED) {
        attacker.status = Status.NORMAL// return to normal
        when (index) {
            0 -> return 1
            1 -> return 0
        }
    }
    return index
}

fun main() {
    // pokemon examples
    val charizard = Pokemon(
        name = "Charizard", type = PokemonType.FIRE, maxHP = 150, attackStat = 84,
        defenseStat = 78, currentHP = 150.0, status = Status.NORMAL
    )
    val blastoise = Pokemon(
        name = "Blastoise", type = PokemonType.WATER, maxHP = 158, attackStat = 83,
        defenseStat = 100, currentHP = 158.0, status = Status.NORMAL
    )
    val pokemons = listOf<Pokemon> (charizard, blastoise)

    // process
    println("💥 ¡BATTLE STARTS! 💥 ")
    println("${charizard.name} (HP: ${charizard.currentHP}) " +
            "vs.${blastoise.name} (HP: ${blastoise.currentHP})")
    var index = 0
    while (pokemons.all { it.currentHP > 0 }) {
        index = checkParalysis(pokemons[index], index)
        when (index) {
            0 -> {
                println(pokemons[index].attack(pokemons[index], pokemons[1]))
                println(applyPostTurnEffects(pokemons[1]))
                index ++
            }
            1 -> {
                println(pokemons[index].attack(pokemons[index], pokemons[0]))
                println(applyPostTurnEffects(pokemons[0]))
                index --
            }
        }
    }
    pokemons.forEach {
        if (it.currentHP > 0) {
            return println("${it.name} wins!" +
                    "\n💥 ¡BATTLE ENDS! 💥 ")
        }
    }
}