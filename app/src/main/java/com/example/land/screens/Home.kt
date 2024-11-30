package com.example.land.screens



import android.os.Build
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.land.R
import com.example.land.navigation.Routes

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Home(navController: NavHostController) {


    val context = LocalContext.current
     val day = LocalDate.now().dayOfWeek
    val date = LocalDate.now()


    /*Calendar rightnow = Calendar.getInstance()
    val dateFormat = DateFormat.getDateInstance(DateFormat.DAY_OF_WEEK_FIELD).format(rightnow)*/
   Image(painter = painterResource(id = R.drawable.homepage), contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize())
    Column(
        Modifier

            //.background(color = Color(android.graphics.Color.parseColor("#ede7f8")))
            .padding(top = 32.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //val(text,logo,username) = createRefs()
        Row(modifier = Modifier.fillMaxWidth()) {



            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                //  val timeFormat = DateFormat.getTimeInstance(DateFormat.SHORT).format(calendar)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(
                        text = "$day, ",
                        color = androidx.compose.ui.graphics.Color.Gray,
                        fontSize = 20.sp,
                        //   fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = "$date",
                        color = androidx.compose.ui.graphics.Color.Gray,
                        fontSize = 20.sp,
                        // fontWeight = FontWeight.Bold,
                        // modifier = Modifier.padding(start = 10.dp)
                    )

                }

            }


        }

        var text by rememberSaveable { mutableStateOf("") }



        Row (
            modifier =  Modifier.padding(top = 80.dp),
            horizontalArrangement = Arrangement.Start
        ) {

            //----------------------------------------------------------------------------
            Column (modifier = Modifier.padding(start = 20.dp).height(300.dp),
                horizontalAlignment = Alignment.Start){
                Image(
                    painter = painterResource(id = R.drawable.weather),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        //.padding(end = 6.dp)
                        .clickable {


                        }
                )
            }

            // ----------------------------------------------------------------------------


        }

        Box(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.navigate(Routes.Landslide.routes) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }


        }, modifier = Modifier.fillMaxWidth(),
            colors =  ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color(android.graphics.Color.parseColor("#6C9E81")))//
            , shape = RoundedCornerShape(20.dp),


            )

        {
            androidx.compose.material.Text(
                text = "LandSlide Information", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,

                    ), modifier = Modifier.padding(vertical = 6.dp),color = Color.White
            )

        }

        Column (modifier = Modifier.padding(start = 20.dp),
            horizontalAlignment = Alignment.Start){


            Box(
                modifier = Modifier
                    .height(65.dp)
                    .width(65.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#ffffff")),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.chatbot),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(7.dp)
                        .clickable {
                            navController.navigate(Routes.Chatbot.routes) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }

                        }
                )

            }
            Text(
                text = "ChatBot",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color(android.graphics.Color.parseColor("#000000")),
                modifier = Modifier.padding(top = 8.dp)
            )
        }


    }



    }







