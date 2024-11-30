package com.example.land.screens


import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.land.R
import com.example.land.navigation.Routes
/*
import com.example.healthcare.viewModel.AuthViewModel
*/

@Composable
fun Landslide(navController: NavHostController){

    Column(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(color = Color(android.graphics.Color.parseColor("#e0e0e0")))
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        //  horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .height(50.dp)
                .width(65.dp)
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
                        navController.navigate(Routes.BottomNav.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {

            MyApp()}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
                Column(
                    Modifier
                        .weight(0.5f)
                        .height(185.dp)
                        .padding(end = 12.dp)
                        .background(
                            color = androidx.compose.ui.graphics.Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(95.dp)
                            .width(105.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#ffffff")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.landslide),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(7.dp)
                                .clickable {
                                   navController.navigate(Routes.Eyedoc.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }

                                }
                        )
                    }
                    Button(onClick = {
                        navController.navigate(Routes.landhistory.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }


                    }, modifier = Modifier.fillMaxWidth().padding(top = 7.dp,start = 8.dp, end = 8.dp),
                        colors =  ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color(android.graphics.Color.parseColor("#6BB76E")))//
                        , shape = RoundedCornerShape(20.dp),


                        )

                    {
                        androidx.compose.material.Text(
                            text = "Landslide History", style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,

                                ), modifier = Modifier.padding(vertical = 6.dp),color = Color.White
                        )

                    }
                    /*Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
                            ), contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = "Eye Specialist",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#7869e5"))
                        )
                    }*/
                }
//---------------------------------------------------------------------------------------------------
                Column(
                    Modifier
                        .weight(0.5f)
                        .height(185.dp)
                        .padding(end = 12.dp)
                        .background(
                            color = androidx.compose.ui.graphics.Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(95.dp)
                            .width(105.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#ffffff")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.workshop),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(7.dp)
                                .clickable {
                                    /*navController.navigate(Routes.Childdoc.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }
*/
                                }
                        )
                    }
                    Button(onClick = {
                        navController.navigate(Routes.Articel.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }


                    }, modifier = Modifier.fillMaxWidth().padding(top = 7.dp,start = 10.dp, end = 10.dp),
                        colors =  ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color(android.graphics.Color.parseColor("#6BB76E")))//
                        , shape = RoundedCornerShape(20.dp),


                        )

                    {
                        androidx.compose.material.Text(
                            text = "Articels", style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,

                                ), modifier = Modifier.padding(vertical = 6.dp),color = Color.White
                        )

                    }
                }
            }
 //--------------------------------------------------------------------------------------
 //-------------------------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {

                Column(
                    Modifier
                        .weight(0.5f)
                        .height(185.dp)
                        .padding(end = 12.dp)
                        .background(
                            color = androidx.compose.ui.graphics.Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(95.dp)
                            .width(105.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#ffffff")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.emergency),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(7.dp)
                                .clickable {
                                    navController.navigate(Routes.Contact.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }

                                }
                        )
                    }
                    Button(onClick = {
                        navController.navigate(Routes.Contact.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }


                    }, modifier = Modifier.fillMaxWidth().padding(top = 7.dp,start = 10.dp, end = 10.dp),
                        colors =  ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color(android.graphics.Color.parseColor("#6BB76E")))//
                        , shape = RoundedCornerShape(20.dp),


                        )

                    {
                        androidx.compose.material.Text(
                            text = "Emergency Contact", style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,

                                ), modifier = Modifier.padding(vertical = 6.dp),color = Color.White
                        )

                    }
                }
//-----------------------------------------------------------------------------------------
                Column(
                    Modifier
                        .weight(0.5f)
                        .height(185.dp)
                        .padding(end = 12.dp)

                        .background(
                            color = androidx.compose.ui.graphics.Color.White,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .height(95.dp)
                            .width(105.dp)

                            .background(
                                color = Color(android.graphics.Color.parseColor("#ffffff")),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.analysis),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(7.dp)
                                .clickable {
                                    /*navController.navigate(Routes.Dentaldoc.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }*/

                                }
                        )
                    }
                    Button(onClick = {
                        navController.navigate(Routes.Analysis.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }


                    }, modifier = Modifier.fillMaxWidth().padding(top = 7.dp, start = 10.dp, end = 10.dp),
                    colors =  ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color(android.graphics.Color.parseColor("#6BB76E")))//
                    , shape = RoundedCornerShape(20.dp),


                    )

                    {
                        androidx.compose.material.Text(
                            text = "Analysis", style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,

                                ), modifier = Modifier.padding(vertical = 6.dp),color = Color.White
                        )

                    }
                }
            }

        }
    }
