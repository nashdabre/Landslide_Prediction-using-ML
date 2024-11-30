
package com.example.land.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.land.R
import com.example.land.navigation.Routes



@Composable
fun landhistory(navController: NavHostController){
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(color = Color(android.graphics.Color.parseColor("#e0e0e0")))
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
                        navController.navigate(Routes.Landslide.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    }
            )
        }


        //---------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

            Column(
                Modifier
                    .weight(0.5f)
                    .padding(top = 4.dp, end = 3.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(top = 8.dp, start = 8.dp),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(top = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        Modifier.width(300.dp).height(90.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(25.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "Landslide in Andra Pradesh",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=10.dp,start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "50 dead in landslide",
                                fontSize = 16.sp,
                                //  fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )

                        }
                    }

                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#A2D9CE")),
                                shape = CircleShape
                            )

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rightarrow),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                   navController.navigate(Routes.LandHistory2.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }

                                }
                        )
                    }

                }


            }

        }
        //---------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

            Column(
                Modifier
                    .weight(0.5f)
                    .padding(top = 4.dp, end = 3.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(top = 8.dp, start = 8.dp),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(top = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        Modifier.width(300.dp).height(90.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(25.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "landslide in Himachal Pradesh",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=10.dp,start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "15 dead",
                                fontSize = 16.sp,
                                //  fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )

                        }
                    }

                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#A2D9CE")),
                                shape = CircleShape
                            )

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rightarrow),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate(Routes.LandHistory3.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }

                                }
                        )
                    }

                }


            }

        }
        //---------------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

            Column(
                Modifier
                    .weight(0.5f)
                    .padding(top = 4.dp, end = 3.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(top = 8.dp, start = 8.dp),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(top = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        Modifier.width(300.dp).height(90.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(25.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "Landslide in Manipur",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=10.dp,start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "14 Dead",
                                fontSize = 16.sp,
                                //  fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )

                        }
                    }

                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#A2D9CE")),
                                shape = CircleShape
                            )

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rightarrow),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate(Routes.LandHistory4.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }

                                }
                        )
                    }

                }


            }

        }
        //-------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {

            Column(
                Modifier
                    .weight(0.5f)
                    .padding(top = 4.dp, end = 3.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(top = 8.dp, start = 8.dp),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(top = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        Modifier.width(300.dp).height(90.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(25.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "Landslide in pune",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top=10.dp,start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "44 houses down",
                                fontSize = 16.sp,
                                //  fontWeight = FontWeight.Bold,
                                color = Color.Gray
                            )

                        }
                    }

                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(40.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#A2D9CE")),
                                shape = CircleShape
                            )

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.rightarrow),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                                .clickable {

                                    navController.navigate(Routes.LandHistory1.routes) {
                                        popUpTo(navController.graph.startDestinationId)
                                        launchSingleTop = true
                                    }


                                }
                        )
                    }

                }


            }

        }
    }
}
