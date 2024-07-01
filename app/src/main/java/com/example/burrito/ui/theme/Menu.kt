package com.example.burrito.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.burrito.R

@Composable

fun Menu(){
    Row(modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Bottom) {

        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Card(

                colors = CardDefaults.cardColors(
                    containerColor = colorResource(R.color.rectangle_color),
                ),
                modifier = Modifier
                    .size(width = 400.dp, height = 320.dp)
            ) {
                Text(
                    text = "Filled",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.tiempo_contenedor),
                    ),
                    modifier = Modifier
                        .size(width = 10.dp, height = 20.dp)
                ){
                    Text(
                        text = "Filled",
                        modifier = Modifier
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        )
                }
            }
        }
    }
}
