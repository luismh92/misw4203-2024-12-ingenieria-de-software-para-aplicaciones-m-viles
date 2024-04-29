package com.example.vinilosmisw4203_2024
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.vinilosmisw4203_2024.views.LoginScreen
import org.junit.Rule
import org.junit.Test

class ArtistTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController
    @Test
    fun setContent(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
                LoginScreen(
                    navController
                )

        }
        composeTestRule.onNodeWithText("Login as User").assertIsDisplayed()
        composeTestRule.onNodeWithText("Login as Collectionist").assertIsDisplayed()
    }



}