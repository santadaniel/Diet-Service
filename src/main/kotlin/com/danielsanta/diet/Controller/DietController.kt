package com.danielsanta.diet.Controller

import com.danielsanta.diet.model.entities.Drink
import com.danielsanta.diet.model.entities.Food
import com.danielsanta.diet.model.entities.Type
import com.danielsanta.diet.service.DietService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/diet")
@CrossOrigin(origins = arrayOf("http://localhost:3000"))
class DietController(private val dietService: DietService) {
    @GetMapping
    fun getDiet(): List<String> {
        val drinks = dietService.getDrinks().map { it.name }
        val foods = dietService.getFoods().map { it.name }
        return (drinks + foods)
    }

    @GetMapping("/cheap")
    fun getCheapDiet(): List<String> {
        return dietService.getDiet(Type.CHEAP)
    }

    @GetMapping("/healthy")
    fun getHealthyDiet(): List<String> {
        return dietService.getDiet(Type.HEALTHY)
    }

    @GetMapping("/tasty")
    fun getTastyDiet(): List<String> {
        return dietService.getDiet(Type.TASTY)
    }

    @GetMapping("/expensive")
    fun getExpensiveDiet(): List<String> {
        return dietService.getDiet(Type.EXPENSIVE)
    }

    @GetMapping("/foods/{food}")
    fun getFoodDiet(@PathVariable("food") food: String): Food {
        return dietService.getFoodByName(food)
    }

    @GetMapping("/drinks/{drink}")
    fun getDrinkDiet(@PathVariable("drink") drink: String): Drink {
        return dietService.getDrinkByName(drink)
    }
}