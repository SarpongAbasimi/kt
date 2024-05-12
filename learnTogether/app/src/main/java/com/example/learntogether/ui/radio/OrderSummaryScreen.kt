package com.example.learntogether.ui.radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.R
import com.example.learntogether.model.CupCakeState
import com.example.learntogether.ui.theme.LearnTogetherTheme


@Composable
fun OrderSummary(
    state: CupCakeState,
    handleOnCancel: ()-> Unit
){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(R.string.order_summary), Modifier.padding(10.dp))
        TextWithDivider(stringResource(R.string.quantity), state.quantity.toString(), Modifier)
        TextWithDivider(stringResource(R.string.flavour), state.flavour, Modifier)
        TextWithDivider(stringResource(R.string.pickup_date), state.orderDate, Modifier)
        Text(
            text = stringResource(
                R.string.subtotal,
                state.price
            ),
            Modifier
                .align(Alignment.End)
                .padding(end = 10.dp, bottom = 15.dp, top = 15.dp)
        )

        Column(
            Modifier.fillMaxWidth().fillMaxSize().padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(onClick = { /*TODO*/ },  Modifier.widthIn(300.dp)) {
                Text(text = "Send Order To Another App")
            }

            OutlinedButton(onClick = handleOnCancel, Modifier.widthIn(300.dp)) {
                Text(text = "Cancel")
            }
        }
    }
}

@Composable
fun TextWithDivider(
    title: String ,
    value: String,
    modifier: Modifier
){
    Column(
        modifier.padding(start = 10.dp)
    ) {
        Text(text = title, modifier.padding(bottom = 5.dp))
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp
        )
        Divider(thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun OrderSummaryPreview(){
    LearnTogetherTheme {
        OrderSummary(CupCakeState(), handleOnCancel = {})
    }
}

