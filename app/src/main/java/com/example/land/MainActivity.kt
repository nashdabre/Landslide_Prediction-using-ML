package com.example.land

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.land.navigation.NavGraph

import com.example.land.ui.theme.LandTheme
/*import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority*/

class MainActivity : ComponentActivity() {
   /* private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
   */ private var locationRequired: Boolean = false

   /* override fun onResume() {
        super.onResume()
        if (locationRequired) startLocaitonUpdate();

    }*/

   /* @SuppressLint("MissingPermission")
    private fun startLocaitonUpdate() {
       locationCallback?.let{
           val locationRequest = LocationRequest.Builder(
               Priority.PRIORITY_HIGH_ACCURACY, 100
           )
               .setWaitForAccurateLocation(false)
               .setMinUpdateIntervalMillis(3000)
               .setMaxUpdateDelayMillis(100)
               .build()

           fusedLocationProviderClient?.requestLocationUpdates(
               locationRequest,
               it,
               Looper.getMainLooper()
           )
       }
    }

    override fun onPause(){
        super.onPause()
        locationCallback?.let{
            fusedLocationProviderClient?.removeLocationUpdates(it)
        }
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initLocationClient()
        setContent {


            //location callback
        /*    locationCallback = object: LocationCallback(){
                override fun onLocationResult(p0: LocationResult) {
                    super.onLocationResult(p0)
                    for (location in p0.locations){
                        currentLocation = MyLatLng(location.latitude,location.longitude)
                    }

                }
            }*/
            LandTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }



   /* private fun initLocationClient() {
        fusedLocationProviderClient = LocationServices
            .getFusedLocationProviderClient(this)
    }*/
}

