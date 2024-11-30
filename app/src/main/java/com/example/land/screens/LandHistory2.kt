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
fun LandHistory2(navController: NavHostController){

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
                        painter = painterResource(id = R.drawable.l2),
                        contentDescription = ""
                    )
                }
            }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 4.dp)
                .height(195.dp)

        ){
            Text(
                text = "SHIMLA: The death toll in the landslide in Himachal Pradesh's Kinnaur district has climbed to 15 with the recovery of one more body on Friday, a senior disaster management official said.Rescue operations resumed this morning to trace the 15 others still missing in the landslide that occurred near Chaura village in the district on Wednesday.",
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
                text = "At least 15 people have died and dozens more are trapped under debris after a landslide in a Himalayan district in northern India.10 bodies were recovered on Wednesday, four were found on Thursday from the landslide site.Besides 13 people were rescued on Wednesday itself.",
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
                text = "The CM said the state government will provide Rs 4 lakh each to the next of kin of the dead and Rs 50,000 to those seriously injured.",
                fontSize = 16.sp,
                // fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Justify


            )

        }



        }
}