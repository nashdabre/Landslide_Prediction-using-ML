
package com.example.land.screens


import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.land.R
import com.example.land.navigation.Routes



@Composable
fun Contact(navController: NavHostController){
    val ctx = LocalContext.current
    val intent =  Intent(Intent.ACTION_DIAL)
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
                        navController.navigate(Routes.Landslide.routes) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    }
            )
        }

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
                    Box(
                        modifier = Modifier
                            .height(85.dp)
                            .width(85.dp)
                            .padding(bottom = 10.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#eeeeee")),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ambulance),
                            contentDescription = null,
                            modifier = Modifier

                                .fillMaxSize()
                                .height(30.dp)
                                // .padding(7.dp)
                                .clip(CircleShape)
                            ,
                            contentScale = ContentScale.Crop

                        )
                    }
                    Column(
                        Modifier.width(190.dp),

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
                                text = "Ambulance",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            // .background(
                            //  color = Color(android.graphics.Color.parseColor("#Dad9ff")),
                            // shape = RoundedCornerShape(20.dp))
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "102",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray
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
                                    intent.data= Uri.parse("tel:102");
                                    ctx.startActivity(intent);

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
                    Box(
                        modifier = Modifier
                            .height(85.dp)
                            .width(85.dp)
                            .padding(bottom = 10.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#eeeeee")),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.fire),
                            contentDescription = null,
                            modifier = Modifier

                                .fillMaxSize()
                                .height(30.dp)
                                // .padding(7.dp)
                                .clip(CircleShape)
                            ,
                            contentScale = ContentScale.Crop

                        )
                    }
                    Column(
                        Modifier.width(190.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(25.dp)
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "Fire Fighter",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "101",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray
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
                                    intent.data= Uri.parse("tel:101")
                                    ctx.startActivity(intent);
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
                    Box(
                        modifier = Modifier
                            .height(85.dp)
                            .width(85.dp)
                            .padding(bottom = 10.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#eeeeee")),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.police),
                            contentDescription = null,
                            modifier = Modifier

                                .fillMaxSize()
                                .height(30.dp)
                                // .padding(7.dp)
                                .clip(CircleShape)
                            ,
                            contentScale = ContentScale.Crop

                        )
                    }
                    Column(
                        Modifier.width(190.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(25.dp)
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "Police",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "100",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray
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
                                    intent.data= Uri.parse("tel:100");
                                    ctx.startActivity(intent);}
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
                    Box(
                        modifier = Modifier
                            .height(85.dp)
                            .width(85.dp)
                            .padding(bottom = 10.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#eeeeee")),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.emergency),
                            contentDescription = null,
                            modifier = Modifier

                                .fillMaxSize()
                                .height(30.dp)
                                // .padding(7.dp)
                                .clip(CircleShape)
                            ,
                            contentScale = ContentScale.Crop

                        )
                    }
                    Column(
                        Modifier.width(190.dp),

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(25.dp), contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "National Emergency Number",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(android.graphics.Color.parseColor("#000000"))
                            )

                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 6.dp, end = 4.dp)
                                .height(43.dp)
                            , contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = "112",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray
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
                                    intent.data= Uri.parse("tel:112");
                                    ctx.startActivity(intent);
                                             }
                        )
                    }

                }


            }

        }
    }
}
