package com.example.vinilosmisw4203_2024

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.vinilosmisw4203_2024.views.ArtistListScreen
import com.example.vinilosmisw4203_2024.views.UserScreen
import com.example.vinilosmisw4203_2024.viewsModels.ArtistViewModel
import org.junit.Rule
import org.junit.Test

class UserScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testUserScreen() {

        composeTestRule.setContent {Thread.sleep(5000)
            UserScreen()
        }
        composeTestRule.onNodeWithText("Artistas").performClick()
        Thread.sleep(10000)
        composeTestRule.onNodeWithText("Coleccionistas").performClick()
        Thread.sleep(10000)
        composeTestRule.onNodeWithText("Álbumes").performClick()
        Thread.sleep(10000)
    }


}