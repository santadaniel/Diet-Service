package com.danielsanta.diet.service

import com.danielsanta.diet.model.entities.Drink
import com.danielsanta.diet.model.entities.Food
import com.danielsanta.diet.model.entities.Type
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class DietService {
    val restTemplate = RestTemplate()

    fun getDrinks(): List<Drink> {
        val response = restTemplate.getForObject("http://localhost:8083/drinks", Array<Drink>::class.java)
        return response?.toList() ?: emptyList()
    }

    fun getFoods(): List<Food> {
        val response = restTemplate.getForObject("http://localhost:8080/foods", Array<Food>::class.java)
        return response?.toList() ?: emptyList()
    }

    fun getDiet(type: Type): List<String> {
        val drinks = getDrinks().filter { it.type == type }.map { it.name }
        val foods = getFoods().filter { it.type == type }.map { it.name }
        return drinks + foods
    }

    fun getFoodByName(name: String): Food {
        val response = restTemplate.getForObject("http://localhost:8080/foods", Array<Food>::class.java)
        response?.toList() ?: emptyList()
        for (res in response!!)
            if (res.name == name)
                return res
        return Food()
    }

    fun getDrinkByName(name: String): Drink {
        val response = restTemplate.getForObject("http://localhost:8083/drinks", Array<Drink>::class.java)
        response?.toList() ?: emptyList()
        for (res in response!!)
            if (res.name == name)
                return res
        return Drink()
    }
}