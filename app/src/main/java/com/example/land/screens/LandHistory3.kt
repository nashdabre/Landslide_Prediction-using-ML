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
fun LandHistory3(navController: NavHostController){

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
                        painter = painterResource(id = R.drawable.l3),
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
                text = "A large landslide occurred in Noney district of the Indian state of Manipur near the Tupul railway construction site on the night of 30 June 2022.The landslide occurred near the Ijei river where it created a dam. Rescuers believed it could lead to major flooding if the dam gave way, causing a larger disaster.",
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
                .height(157.dp)

        ){
            Text(
                text = " It killed 58 people and three people were missing. Eighteen people were injured. Twenty-nine Indian Army personnel and 29 civilians were among the deceased. Of the missing three people, two were civilians and one was an Indian Army personnel." ,
                fontSize = 16.sp,
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
                text = "The Chief Ministers of Manipur, N. Biren Singh, said that ₹500 thousand would be given to the families of those killed as an ex gratia, while ₹50 thousand would be given to the injured. ",
                fontSize = 16.sp,
                // fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Justify


            )

        }



        }
}