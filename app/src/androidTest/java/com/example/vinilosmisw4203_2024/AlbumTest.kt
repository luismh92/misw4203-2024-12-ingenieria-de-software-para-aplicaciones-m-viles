package com.example.vinilosmisw4203_2024
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vinilosmisw4203_2024.views.AlbumListScreen
import com.example.vinilosmisw4203_2024.viewsModels.AlbumViewModel
import org.junit.Rule
import org.junit.Test

class AlbumTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun setContent(){
        composeTestRule.setContent {
            val viewModelAlbum = viewModel<AlbumViewModel>()
            AlbumListScreen(viewModel = viewModelAlbum)
        }
        composeTestRule.onNodeWithText("albums")
    }
}