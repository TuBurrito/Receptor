package com.example.burrito.ui.theme

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.burrito.R
import com.google.android.gms.maps.model.LatLng
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector

/**
 * This composable was generated from the UI Package 'interfaz_burrito'.
 * Generated code; do not edit directly
 */
import kotlinx.coroutines.*
import okhttp3.*
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sqrt

var showHorarios = false

fun getDistance(it: Map.Entry<String, LatLng>?, burritoLocation: LatLng): Double {
    return it?.value?.latitude!!.minus(burritoLocation.latitude).pow(2.0) +it.value.longitude.minus(burritoLocation.longitude).pow(2.0)
}

fun getParadero(burritoLocation: LatLng, paraderos:Map<String,LatLng>):String{
     return paraderos.entries.stream().reduce{acc,it ->
         return@reduce if (getDistance(it,burritoLocation) <= getDistance(acc,burritoLocation)) it else acc
     }.orElse(null).key
}

fun getTiempo(userLocation: LatLng, burritoLocation: LatLng): String {
    val burritoSpeed = 30
    val latitudeDistance =(userLocation.latitude - burritoLocation.latitude)*111000.32
    val longitudeDistance = 40075000*cos(latitudeDistance)/360
    val distance = sqrt(
        (latitudeDistance).pow(2.0) + (longitudeDistance).pow(
        2.0
    )
    )
    val tiempoSegundos:Int = distance.toInt()/burritoSpeed
    return "${tiempoSegundos/60}:${tiempoSegundos%60}"
}

@Composable
fun Menu(userLocation: LatLng,burritoLocation: LatLng, modifier: Modifier = Modifier) {
    Log.d("burrito:",burritoLocation.toString())
    Log.d("user:",userLocation.toString())
    var locationParaderos = hashMapOf(
        Pair("Paradero Puerta 2",LatLng(-12.05959341333829, -77.07960137731172)),
        Pair("Paradero Puerta 3",LatLng(-12.057172024474827, -77.08026173038515)),
        Pair("Paradero Clinica Universitaria", LatLng(-12.055547892654287, -77.08208900877857)),
        Pair("Paradero Puerta 7",LatLng(-12.053996601875435, -77.08470504070014)),
        Pair("Paradero FISI", LatLng(-12.053670915389079, -77.08569974621102)),
        Pair("Paradero Odontologia", LatLng(-12.054883667022704, -77.08598457383381)),
        Pair("Paradero Rectorado", LatLng(-12.056892263863233, -77.08559688387052)),
        Pair("Paradero Huaca San Marcos", LatLng(-12.060358132901312, -77.08556691009252)),
        Pair("Paradero Comedor", LatLng(-12.060792420456595, -77.08332604156331)),
        Pair("Paradero Industrial", LatLng(-12.060452905428926, -77.08137251616793)))
    var tiempo = getTiempo(userLocation, burritoLocation)
    val paradero = getParadero(burritoLocation,locationParaderos)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Box (
                modifier = Modifier
                    .height(350.dp)
                    .width(400.dp),
            ){
                TopLevel(modifier = modifier) {
                    Contenedor_Principal(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 0.0.dp,
                                y = 0.0.dp
                            )
                        )
                    )
                    PasaEn(
                        modifier = Modifier.padding(
                            horizontal = 240.dp,
                            vertical = 40.dp,
                        ),


                    )
                    Paradero(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 252.0.dp,
                                y = 142.0.dp
                            )
                        ),
                        content = paradero
                    )
                    Lugar(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 188.0.dp,
                                y = 142.0.dp
                            )
                        )
                    )
                    MinSeg(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 167.0.dp,
                                y = 120.0.dp
                            )
                        )
                    )
                    Contenedor_Tiempo(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 188.0.dp,
                                y = 72.0.dp
                            )
                        )
                    )
                    Tiempo(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 188.0.dp,
                                y = 85.0.dp
                            )
                        ),
                        content = tiempo
                    )
                    Imagen_Referencial(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 30.0.dp,
                                y = 42.0.dp//
                            )
                        )
                    )
                    Contenedor_Horarios(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 57.0.dp,
                                y = 214.0.dp
                            )
                        )
                    )
                    HorariosDeAtencion(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 131.0.dp,
                                y = 226.0.dp//603
                            )
                        )
                    )
                    Contendor_GPS(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 59.0.dp,
                                y = 174.0.dp
                            )
                        )
                    )
                    CONGPS(
                        modifier = Modifier.boxAlign(
                            alignment = Alignment.TopStart,
                            offset = DpOffset(
                                x = 45.0.dp,
                                y = 175.0.dp
                            )
                        )
                    )
                }
            }
        }
    }

}


@Composable
fun Contenedor_Principal(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_5),
        modifier = modifier
            .requiredWidth(375.0.dp)
            .requiredHeight(322.0.dp)
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
        modifier = modifier
            .requiredWidth(139.0.dp)
            .requiredHeight(19.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Paradero(modifier: Modifier = Modifier, content: String) {
    RelayText(
        content = content,
        fontSize = 12.0.sp,
        fontFamily = inter,
        color = Color(
            alpha = 255,
            red = 255,
            green = 246,
            blue = 224
        ),
        height = 1.2102272033691406.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier
            .requiredWidth(98.0.dp)
            .requiredHeight(28.0.dp)
            .wrapContentHeight(
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
        modifier = modifier
            .requiredWidth(64.0.dp)
            .requiredHeight(19.0.dp)
            .wrapContentHeight(
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
        modifier = modifier
            .requiredWidth(139.0.dp)
            .requiredHeight(19.0.dp)
            .wrapContentHeight(
                align = Alignment.CenterVertically,
                unbounded = true
            )
    )
}

@Composable
fun Contenedor_Tiempo(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_6),
        modifier = modifier
            .requiredWidth(97.0.dp)
            .requiredHeight(48.0.dp)
    )
}

@Composable
fun Tiempo(modifier: Modifier = Modifier, content: String) {
    RelayText(
        content = content,
        fontSize = 25.0.sp,
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
        modifier = modifier
            .requiredWidth(97.0.dp)
            .requiredHeight(22.0.dp)
            .wrapContentHeight(
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
        modifier = modifier
            .requiredWidth(139.0.dp)
            .requiredHeight(134.0.dp)
    )
}

@Composable
fun Contenedor_Horarios(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_7),
        modifier = modifier
            .requiredWidth(262.0.dp)
            .requiredHeight(102.0.dp)
    )
}

@Composable
fun HorariosDeAtencion(modifier: Modifier = Modifier) {
        RelayText(
            content = "Horario de atencion\n Lunes a Viernes de 7:30am a 9:30pm",
            fontSize = 12.0.sp,
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
            modifier = modifier
                .requiredWidth(114.0.dp)
                .requiredHeight(34.0.dp)
        )
}

@Composable
fun Contendor_GPS(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.interfaz_burrito_rectangle_9),
        modifier = modifier
            .requiredWidth(84.0.dp)
            .requiredHeight(19.0.dp)
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
        modifier = modifier
            .requiredWidth(114.0.dp)
            .requiredHeight(17.0.dp)
            .wrapContentHeight(
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
        modifier = modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
    )
}
