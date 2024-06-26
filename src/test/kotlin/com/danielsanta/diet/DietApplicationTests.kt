package com.danielsanta.diet

import com.danielsanta.diet.Controller.DietController
import com.danielsanta.diet.model.entities.Drink
import com.danielsanta.diet.model.entities.Type
import com.danielsanta.diet.service.DietService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class DietApplicationTests {
	final val dietService = DietService()
	final val dietController = DietController(dietService)

	@Test
	fun `Should return Cheap Diet`() {
		// Given
		val expected = listOf(
			"Espresso",
			"Mineral Water",
			"Energy Drink",
			"Fries",
			"Hot Dog"
		)

		// When
		val result = dietController.getCheapDiet()

		// Then
		assertThat(result).isEqualTo(expected)
	}

	@Test
	fun `Test if getDrinkDiet function works as expected`() {
		// Given
		val expected1 = Drink("Cola", 400, Type.TASTY, 500)
		val expected2 = Drink()

		// When
		val result1 = dietController.getDrinkDiet("Cola")
		val result2 = dietController.getDrinkDiet("Invalid name")

		// Then
		assertThat(result1).isEqualTo(expected1)
		assertThat(result2).isEqualTo(expected2)
	}
}
