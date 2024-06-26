package com.danielsanta.diet.model.entities

data class Food(
    val name: String = "",
    val price: Int = 0,
    val type: Type = Type.UNKNOWN
)
