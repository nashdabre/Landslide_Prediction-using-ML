package com.example.land.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.land.R
import com.example.land.navigation.Routes


@Composable
fun LandHistory1(navController: NavHostController){

    Column(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(color = Color(android.graphics.Color.parseColor("#9e9e9e")))
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
    ) {

        Box(
            modifier = Modifier
                .height(45.dp)
                .width(60.dp)
                .background(
                    color = Color(android.graphics.Color.parseColor("#ffffff")),
                    shape = RoundedCornerShape(20.dp)
                )

        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(Routes.landhistory.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    }
            )
        }

        Box(modifier = Modifier.wrapContentSize()) {


                Card(
                    Modifier
                        .wrapContentSize()
                        .padding(22.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Image(
                        modifier = Modifier.clickable {

                        },
                        painter = painterResource(id = R.drawable.l1),
                        contentDescription = ""
                    )
                }
            }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 4.dp)
                .height(180.dp)

        ){
            Text(
                text = "On 30 July 2014, a landslide occurred in the village of Malin in the Ambegaon taluka of the Pune district in Maharashtra, India. The landslide, which hit early in the morning while residents were asleep, was believed to have been caused by a burst of heavy rainfall, and killed at least 151 people. ",
                fontSize = 16.sp,
                //  fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Justify
            )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=3.dp,start = 6.dp, end = 4.dp)
                .height(29.dp)

        ){
            Text(
                text = "Casualties:\n" ,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,


            )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=3.dp,start = 6.dp, end = 4.dp)
                .height(156.dp)

        ){
            Text(
                text = "Although initial reports stated that the landslide had killed 17 people, officials expected the death toll to exceed 150. The bodies so far recovered were of 50 men, 64 women and 20 children. Later estimates indicated more than 160 people, and possibly up to 200.",
               // fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Justify


                )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=3.dp,start = 6.dp, end = 4.dp)
                .height(29.dp)

        ){
            Text(
                text = "Reactions:\n" ,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,


                )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=3.dp,start = 6.dp, end = 4.dp)
                .height(168.dp)

        ){
            Text(
                text = "Prime Minister of India released a statement in response to the landslide, in which they condoled the loss of lives in the landslide and directed all possible efforts to help the affected people.",
                fontSize = 16.sp,
                // fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Justify


            )

        }



        }
}