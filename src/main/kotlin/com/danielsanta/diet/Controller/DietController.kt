package com.danielsanta.diet.Controller

import com.danielsanta.diet.service.DietService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder

@RestController
@RequestMapping("/diet")
class DietController(private val dietService: DietService) {
    @GetMapping
    fun getDiet(): List<String> {
        val drinks = dietService.getDrinks().map { it.name }
        val foods = dietService.getFoods().map { it.name }
        return (drinks + foods)
    }

    @GetMapping("/cheap")
    fun getCheapDiet(): List<String> {
        return dietService.getDiet("CHEAP")
    }

    @GetMapping("/healthy")
    fun getHealthyDiet(): List<String> {
        return dietService.getDiet("HEALTHY")
    }

    @GetMapping("/tasty")
    fun getTastyDiet(): List<String> {
        return dietService.getDiet("TASTY")
    }

    @GetMapping("/expensive")
    fun getExpensiveDiet(): List<String> {
        return dietService.getDiet("EXPENSIVE")
    }
}