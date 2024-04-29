package com.example.vinilosmisw4203_2024

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.vinilosmisw4203_2024.views.UserScreen
import org.junit.Rule
import org.junit.Test

class UserScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testUserScreen() {
        composeTestRule.setContent {
            UserScreen()
        }
        composeTestRule.onNodeWithText("Artistas").performClick()
        composeTestRule.onNodeWithText("Coleccionistas").performClick()
        composeTestRule.onNodeWithText("Álbumes").performClick()
    }
}