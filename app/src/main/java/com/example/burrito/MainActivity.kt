package com.example.burrito

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.core.app.ActivityCompat
import com.example.burrito.ui.theme.App
import com.example.burrito.ui.theme.BurritoTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


class MainActivity : ComponentActivity() {
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var location: LatLng = LatLng(0.0, 0.0) // Default location value
    private var burritoLocation:LatLng =LatLng(0.0,0.0)

    private suspend fun getBurritoLocation(userLocation:LatLng) {
            val client = OkHttpClient()
            val url = "https://servidor-hlka.onrender.com/api/obtener-coordenada"  // Example URL
            val request = Request.Builder()
                .url(url)
                .build()

            try {
                val completableDeferred = CompletableDeferred<LatLng>()
                val response = client.newCall(request).enqueue(object:Callback{
                    override fun onFailure(call: Call, e: IOException) {
                        Log.e("MainActivity","Error en la conexion")
                        Log.e("Error",e.toString())
                        completableDeferred.completeExceptionally(e)
                    }

                    override fun onResponse(call: Call, response: Response) {

                        val responseBody = response.body()?.string()
                        responseBody?.let {
                            val json = JSONObject(it)
                            val latitude = json.getDouble("latitud")
                            val longitude = json.getDouble("longitud")

                            // Update burritoLocation with the new coordinates
                            burritoLocation = LatLng(latitude, longitude)
                            completableDeferred.complete(location)
                            println("Burrito location updated: $burritoLocation")
                        } ?: run {
                            println("Empty response body")
                        }
                    }
                })
                completableDeferred.await()
                setContent{
                    App(userLocation,burritoLocation)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

    }

    private fun getLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 100)
            return // Exit early, will retry after permissions are granted
        }

        val locationTask = fusedLocationProviderClient.lastLocation
        locationTask.addOnSuccessListener { locationResult ->
            if (locationResult != null) {
                Log.d("Location:", locationResult.toString())
                this.location = LatLng(locationResult.latitude, locationResult.longitude)
                // Recompose the UI with the new location
                CoroutineScope(Dispatchers.Main).launch {
                    getBurritoLocation(location)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            getLocation()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getLocation()
    }
    @Composable
    fun DefaultPreview() {
        BurritoTheme {
        }
    }
}
