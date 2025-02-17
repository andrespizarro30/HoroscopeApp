package com.afsoftwaresolutions.horoscopeapp.data.network.response

import com.afsoftwaresolutions.horoscopeapp.motherobject.HoroscopeMotherObject.anyResponse
import com.google.gson.Gson
import io.kotlintest.shouldBe
import org.junit.Test
import org.junit.jupiter.api.Assertions.*


class PredictionResponseTest{

    @Test
    fun `to Domain Should Return A Correct Prediction Model`(){

        //Given
        val horoscopeResponse = anyResponse

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe  horoscopeResponse.horoscope


    }

    @Test
    fun `to Domain should map PredictionResponse to PredictionModel correctly`() {
        // Arrange
        val response = anyResponse

        // Act
        val domainModel = response.toDomain()

        // Assert
        assertEquals("You will have a great day!", domainModel.horoscope)
        assertEquals("Libra", domainModel.sign)
    }

    @Test
    fun `Gson should correctly deserialize JSON into PredictionResponse`() {
        // Arrange
        val json = """
            {
                "date": "2025-02-17",
                "horoscope": "You will have a great day!",
                "icon": "icon_url",
                "id": 1234,
                "sign": "Aquarius"
            }
        """.trimIndent()

        val gson = Gson()

        // Act
        val response = gson.fromJson(json, PredictionResponse::class.java)

        // Assert
        assertNotNull(response)
        assertEquals("2025-02-17", response.date)
        assertEquals("You will have a great day!", response.horoscope)
        assertEquals("icon_url", response.icon)
        assertEquals(1234L, response.id)
        assertEquals("Aquarius", response.sign)
    }

}