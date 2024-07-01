package com.example.burrito.ui.theme

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.burrito.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun Mapa(userLocation:LatLng){

    val burritoCords = LatLng(-12.057533696473644,-77.08309463610522)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(burritoCords, 20f)
    }
    var locationBurrito = LatLng(-12.059535337281902, -77.07965054520353)
    var locationUsuario = userLocation
    val pointsParaderos = listOf(
        LatLng(-12.0596243, -77.0796382),  // Punto 5
        LatLng(-12.0571921, -77.0802648),  // Punto 6
        LatLng(-12.0566594, -77.0804086),  // Punto 7
        LatLng(-12.0564023, -77.0806286),  // Punto 8
        LatLng(-12.056075, -77.0810044),   // Punto 9
        LatLng(-12.0561348, -77.0811164),  // Punto 10
        LatLng(-12.0558489, -77.0816073),  // Punto 11
        LatLng(-12.0556496, -77.0817601),  // Punto 12
        LatLng(-12.0553636, -77.0821705),  // Punto 13
        LatLng(-12.0553295, -77.0822966),  // Punto 14
        LatLng(-12.0552876, -77.0824227),  // Punto 15
        LatLng(-12.0553059, -77.0825246),  // Punto 16
        LatLng(-12.0554455, -77.0827269),  // Punto 17
        LatLng(-12.0555058, -77.0829307),  // Punto 18
        LatLng(-12.0554875, -77.0831641),  // Punto 19
        LatLng(-12.0554651, -77.083254),   // Punto 20
        LatLng(-12.0548199, -77.0835679),  // Punto 21
        LatLng(-12.0546494, -77.0837583),  // Punto 22
        LatLng(-12.0545564, -77.083935),   // Punto 23
        LatLng(-12.0540528, -77.0847209),  // Punto 24
        LatLng(-12.0537876, -77.0851131),  // Punto 25
        LatLng(-12.0536753, -77.0860252),  // Punto 26
        LatLng(-12.0534864, -77.086272),   // Punto 27
        LatLng(-12.0534549, -77.0864329),  // Punto 28
        LatLng(-12.054625, -77.0865419),   // Punto 29
        LatLng(-12.054761, -77.0866161),   // Punto 30
        LatLng(-12.0547872, -77.0866644),  // Punto 31
        LatLng(-12.0548686, -77.0859456),  // Punto 32
        LatLng(-12.0558236, -77.0860268),  // Punto 33
        LatLng(-12.0562998, -77.0853211),  // Punto 34
        LatLng(-12.0568559, -77.0856725),  // Punto 35
        LatLng(-12.0568959, -77.0855866),  // Punto 36
        LatLng(-12.0572147, -77.0857122),  // Punto 37
        LatLng(-12.0574586, -77.0856183),  // Punto 38
        LatLng(-12.0578508, -77.0857512),  // Punto 39
        LatLng(-12.0580318, -77.085727),   // Punto 40
        LatLng(-12.0581558, -77.0855949),  // Punto 41
        LatLng(-12.0585047, -77.0850075),  // Punto 42
        LatLng(-12.0586096, -77.0849244),  // Punto 44
        LatLng(-12.0587407, -77.0848627),  // Punto 45
        LatLng(-12.0587984, -77.0847876),  // Punto 46
        LatLng(-12.0588314, -77.0847117),  // Punto 47
        LatLng(-12.0611322, -77.0859615),  // Punto 48
        LatLng(-12.0611584, -77.0859159),  // Punto 49
        LatLng(-12.0608882, -77.0857416),  // Punto 50
        LatLng(-12.0610666, -77.0853849),  // Punto 51
        LatLng(-12.0610758, -77.0852414),  // Punto 52
        LatLng(-12.0609, -77.0842044),     // Punto 53
        LatLng(-12.0609082, -77.0839239),  // Punto 54
        LatLng(-12.0607928, -77.0829583),  // Punto 55
        LatLng(-12.0605751, -77.0816138),  // Punto 56
        LatLng(-12.0602403, -77.0803661),  // Punto 57
        LatLng(-12.060041, -77.0797959),   // Punto 58
        LatLng(-12.0599245, -77.079665),   // Punto 59
        LatLng(-12.0598219, -77.0796142),  // Punto 60
        LatLng(-12.0597697, -77.0796152),  // Punto 61
        LatLng(-12.0596251, -77.079636)    // Punto 62
    )

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
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ){
        Marker(icon = BitmapDescriptorFactory.fromResource(R.mipmap.burrito_marker),
            state = MarkerState(position = locationBurrito))
        Marker(icon = BitmapDescriptorFactory.fromResource(R.mipmap.usuario_marker),
        state = MarkerState(position = locationUsuario)
        )
        locationParaderos.forEach {
            Marker(contentDescription = it.key,state=MarkerState(position=it.value))
        }
        Polyline(points = pointsParaderos, color = Color.Cyan, width = 5f)
        Polyline(
            points = listOf(locationUsuario, locationBurrito),
            color = androidx.compose.ui.graphics.Color.Blue, // Customize the color
            width = 5f // Customize the width
        )
    }
}