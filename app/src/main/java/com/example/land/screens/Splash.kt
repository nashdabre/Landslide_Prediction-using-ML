package com.example.land.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.land.R
import com.example.land.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController){



    ConstraintLayout (modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        val (image)= createRefs()
        Image(painter = painterResource(id = R.drawable.startlogo), contentDescription = "Landslide",
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(180.dp))
    }
    LaunchedEffect(key1 = true){
        delay(1000)


            navController.navigate(Routes.BottomNav.routes){
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }



    }



}