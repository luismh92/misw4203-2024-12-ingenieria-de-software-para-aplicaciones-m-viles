package com.example.vinilosmisw4203_2024

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.vinilosmisw4203_2024.repositories.ArtistRepository
import org.junit.Rule
import org.junit.Test

class ArtistTest {
    @get:Rule
    val composeRule = createComposeRule()
    var respository = ArtistRepository()


    @Test
    fun setContent(){
        composeRule.setContent {

        }
    }

}