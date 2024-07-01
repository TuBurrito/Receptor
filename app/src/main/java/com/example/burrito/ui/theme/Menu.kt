/*package com.example.burrito.ui.theme


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

    /*Row(modifier = Modifier.fillMaxSize(),
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
    }*/

}
*/
package com.example.burrito.ui.theme


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.burrito.R
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector

/**
 * This composable was generated from the UI Package 'interfaz_burrito'.
 * Generated code; do not edit directly
 */
@Composable
fun Menu(modifier: Modifier = Modifier) {

    TopLevel(modifier = modifier) {
        Contenedor_Principal(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 0.0.dp,
                    y = 387.0.dp
                )
            )
        )
        PasaEn(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 188.0.dp,
                    y = 419.0.dp
                )
            )
        )
        Paradero(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 252.0.dp,
                    y = 532.0.dp
                )
            )
        )
        Lugar(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 188.0.dp,
                    y = 527.0.dp
                )
            )
        )
        MinSeg(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 167.0.dp,
                    y = 497.0.dp
                )
            )
        )
        Contenedor_Tiempo(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 188.0.dp,
                    y = 449.0.dp
                )
            )
        )
        Tiempo(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 188.0.dp,
                    y = 462.0.dp
                )
            )
        )
        Imagen_Referencial(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 30.0.dp,
                    y = 419.0.dp
                )
            )
        )
        Contenedor_Horarios(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 57.0.dp,
                    y = 591.0.dp
                )
            )
        )
        HorariosDeAtencion(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 131.0.dp,
                    y = 603.0.dp
                )
            )
        )
        Contendor_GPS(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 59.0.dp,
                    y = 546.0.dp
                )
            )
        )
        CONGPS(
            modifier = Modifier.boxAlign(
                alignment = Alignment.TopStart,
                offset = DpOffset(
                    x = 45.0.dp,
                    y = 547.0.dp
                )
            )
        )
    }
}

@Preview(widthDp = 375, heightDp = 667)
@Composable
private fun InterfazBurritoPreview() {
    MaterialTheme {
        RelayContainer {
            Menu(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
        }
    }
}

@Composable
fun Contenedor_Principal(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_5),
        modifier = modifier.requiredWidth(375.0.dp).requiredHeight(322.0.dp)
    )
}

@Composable
fun PasaEn(modifier: Modifier = Modifier) {
    RelayText(
        content = "Pasa en: ",
        fontSize = 18.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272245619032.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(139.0.dp).requiredHeight(19.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Paradero(modifier: Modifier = Modifier) {
    RelayText(
        content = "Paradero Letras",
        fontSize = 20.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 246,
            blue = 224
        ),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(800.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(98.0.dp).requiredHeight(28.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Lugar(modifier: Modifier = Modifier) {
    RelayText(
        content = "Lugar:",
        fontSize = 18.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272245619032.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(64.0.dp).requiredHeight(19.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun MinSeg(modifier: Modifier = Modifier) {
    RelayText(
        content = "min seg",
        fontSize = 16.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272510528564.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(139.0.dp).requiredHeight(19.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Contenedor_Tiempo(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_6),
        modifier = modifier.requiredWidth(97.0.dp).requiredHeight(48.0.dp)
    )
}

@Composable
fun Tiempo(modifier: Modifier = Modifier) {
    RelayText(
        content = "04:10",
        fontSize = 30.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 39,
            green = 40,
            blue = 41
        ),
        height = 1.2102272033691406.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(97.0.dp).requiredHeight(22.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Imagen_Referencial(modifier: Modifier = Modifier) {
    RelayImage(
        image = painterResource(R.drawable.interfaz_burrito_burrito_1),
        radius = 35.0,
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(139.0.dp).requiredHeight(134.0.dp)
    )
}

@Composable
fun Contenedor_Horarios(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_7),
        modifier = modifier.requiredWidth(262.0.dp).requiredHeight(41.0.dp)
    )
}

@Composable
fun HorariosDeAtencion(modifier: Modifier = Modifier) {
    RelayText(
        content = "Horarios de atencion",
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.2102272851126534.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(114.0.dp).requiredHeight(17.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun Contendor_GPS(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_9),
        modifier = modifier.requiredWidth(84.0.dp).requiredHeight(19.0.dp)
    )
}

@Composable
fun CONGPS(modifier: Modifier = Modifier) {
    RelayText(
        content = "CON GPS",
        fontSize = 12.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 39,
            green = 40,
            blue = 41
        ),
        height = 1.2102272510528564.em,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.requiredWidth(114.0.dp).requiredHeight(17.0.dp).wrapContentHeight(
            align = Alignment.CenterVertically,
            unbounded = true
        )
    )
}

@Composable
fun TopLevel(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}
