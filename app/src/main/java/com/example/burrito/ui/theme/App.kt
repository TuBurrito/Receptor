package com.example.burrito.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng

@Composable
fun App(userLocation:LatLng,burritoLocation:LatLng){
    MaterialTheme(){
        Box(modifier = Modifier.fillMaxSize()) {
            Mapa(userLocation,burritoLocation)
            Menu(userLocation, burritoLocation)
        }
    }
}
