package com.example.learntogether

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme
import java.text.NumberFormat
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class TipTime {

    @Composable
    fun TipTimeLayout() {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.calculate_tip),
                modifier = Modifier.padding(bottom = 16.dp, top = 40.dp),
                fontSize = 12.sp,
                textAlign = TextAlign.Start
            )
            EditNumberField(
                modifier = Modifier
                    .padding(bottom = 36.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.tip_time_amount, "$0.00"),
                style = MaterialTheme.typography.displaySmall
            )
        }
    }


    private fun calculateTip(amount: Double, tipPercentage: Double = 15.0): String {
        val tip = tipPercentage / 100 * amount
        return NumberFormat.getCurrencyInstance().format(tip)
    }

    @Composable
    fun EditNumberField(modifier: Modifier){
        var state: String by remember {
            mutableStateOf("")
        }

        TextField(
            value = state,
            onValueChange = {input ->
                state = input
             }  ,
            modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun TipTimePreview(){
        LearnTogetherTheme {
            TipTimeLayout()
        }
    }
}