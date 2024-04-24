package com.example.learntogether


import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.learntogether.ui.theme.LearnTogetherTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipTimeUITest {

    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()
    val tipTime: TipTime = TipTime()

    @Test
    fun calculate_20percent_tip(){
        composeTestRule.setContent {
            LearnTogetherTheme {
                tipTime.TipTimeLayout()
            }
        }
        val tipAmount = NumberFormat
            .getCurrencyInstance()
            .format(3.00)

        composeTestRule
            .onNodeWithText("Bill Amount")
            .assertExists()
            .performTextInput("20")

        composeTestRule
            .onNodeWithText("Tip Amount: $tipAmount")
            .assertExists(
                "No node with this text was found."
            )
    }
}