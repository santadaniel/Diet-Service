package com.danielsanta.diet.model.entities

enum class Type {
    HEALTHY, TASTY, EXPENSIVE, CHEAP, UNKNOWN
}

data class Drink(
    val name: String = "",
    val price: Int = 0,
    val type: Type = Type.UNKNOWN,
    val volume: Int = 0
)