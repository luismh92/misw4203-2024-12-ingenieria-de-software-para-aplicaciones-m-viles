package com.example.vinilosmisw4203_2024
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vinilosmisw4203_2024.views.CollectorListScreen
import com.example.vinilosmisw4203_2024.viewsModels.CollectorViewModel
import org.junit.Rule
import org.junit.Test

class CollectorTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    @Test
    fun setContent(){
        composeTestRule.setContent {
            val viewModelCollector = viewModel<CollectorViewModel>()
            CollectorListScreen(viewModel = viewModelCollector)
        }
        composeTestRule.onNodeWithText("collectors")
        composeTestRule.onNodeWithText("Manolo Bellon")
    }
}