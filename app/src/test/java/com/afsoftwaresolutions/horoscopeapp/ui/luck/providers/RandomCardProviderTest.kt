package com.afsoftwaresolutions.horoscopeapp.ui.luck.providers

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

import com.afsoftwaresolutions.horoscopeapp.R
import io.mockk.mockk

class RandomCardProviderTest{

    private lateinit var random: Random
    private lateinit var randomCardProvider: RandomCardProvider

    @Before
    fun setup() {
        random = mockk() // Mock Random
        randomCardProvider = RandomCardProvider() // Inject mock
    }

    @Test
    fun `get Random Card should return a random card`(){

        val card = randomCardProvider.getLucky()

        assertNotNull(card)
    }

    @Test
    fun `getLucky() returns expected card for given random number`() {
        // Arrange: Mock random to always return 0
        every { random.nextInt(0, 32) } returns 0

        // Act
        val result = randomCardProvider.getLucky()

        // Assert
        assertNotNull(result)
        assertEquals(R.drawable.card_fool, result?.image)
        assertEquals(R.string.luck_0, result?.text)
    }

    @Test
    fun `getLucky() returns null for an out-of-range value`() {
        // Arrange: Mock random to return an invalid index
        every { random.nextInt(0, 32) } returns 32

        // Act
        val result = randomCardProvider.getLucky()

        // Assert
        assertNull(result)
    }

}