package com.danielsanta.diet.model.entities

enum class Type {
    HEALTHY, TASTY, EXPENSIVE, CHEAP
}

data class Drink(
    val name: String,
    val price: Int,
    val type: Type,
    val volume: Int
)