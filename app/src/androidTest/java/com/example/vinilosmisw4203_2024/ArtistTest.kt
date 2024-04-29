package com.example.vinilosmisw4203_2024
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.vinilosmisw4203_2024.views.ArtistListScreen
import com.example.vinilosmisw4203_2024.views.LoginScreen
import com.example.vinilosmisw4203_2024.viewsModels.ArtistViewModel
import org.junit.Rule
import org.junit.Test

class ArtistTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun setContent(){
        composeTestRule.setContent {
            val viewModelArtist = viewModel<ArtistViewModel>()
            ArtistListScreen(viewModel = viewModelArtist)
        }
        composeTestRule.onNodeWithText("artists")
    }
}