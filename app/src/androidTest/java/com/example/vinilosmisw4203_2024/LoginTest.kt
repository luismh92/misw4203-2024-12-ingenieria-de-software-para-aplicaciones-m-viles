package com.example.vinilosmisw4203_2024

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.vinilosmisw4203_2024.views.LoginScreen
import com.example.vinilosmisw4203_2024.views.UserScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setContent(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            LoginScreen(navController)
        }
    }

    @Test
    fun userTrackerNavHost_verifyStartDestination() {
        composeTestRule.onNodeWithText("Login as User")
    }

    @Test
    fun collecionistTrackerNavHost_verifyStartDestination() {
        composeTestRule.onNodeWithText("Login as Collectionist")
    }
}