package com.example.burrito.ui.theme

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        position = CameraPosition.fromLatLngZoom(burritoCords, 50f)
    }
    var locationBurrito = LatLng(-12.059535337281902, -77.07965054520353)
    var locationUsuario = userLocation
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ){
        Marker(icon = BitmapDescriptorFactory.fromResource(R.mipmap.burrito_marker),
            state = MarkerState(position = locationBurrito))
        Marker(icon = BitmapDescriptorFactory.fromResource(R.mipmap.usuario_marker),
        state = MarkerState(position = locationUsuario)
        )
        Polyline(
            points = listOf(locationUsuario, locationBurrito),
            color = androidx.compose.ui.graphics.Color.Blue, // Customize the color
            width = 5f // Customize the width
        )
    }
}