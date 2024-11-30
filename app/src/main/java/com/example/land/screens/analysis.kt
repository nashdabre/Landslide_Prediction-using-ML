package com.example.land.screens



import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.land.R
import com.example.land.navigation.Routes
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlinx.coroutines.flow.update


@Composable
fun Analysis(navController: NavController) {
    val pickerMediaLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            uri?.let {
                uriState.update { uri.toString() }

            }
        }
    val bitmap = getBitmap()

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
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
            
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#ffffff")),
                        shape = RoundedCornerShape(20.dp)
                    )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.gallery),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        //.padding(end = 6.dp)
                        .clickable {

                            pickerMediaLauncher
                                .launch(
                                    PickVisualMediaRequest(
                                        ActivityResultContracts
                                            .PickVisualMedia
                                            .ImageOnly
                                    )
                                )
                        }
                )
                bitmap?.let {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .padding(bottom = 2.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        contentDescription = "picked image",
                        contentScale = ContentScale.Crop,
                        bitmap = it.asImageBitmap()
                    )
                }
            }

        }
        Text(text = "Select Image",
            modifier = Modifier.fillMaxWidth().padding(start = 130.dp, top = 10.dp),
            fontWeight = FontWeight(800))

        Box(modifier = Modifier.height(30.dp))

        Button(onClick = {
            navController.navigate(Routes.Output.routes) {
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
                text = "Predict Landslide", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,

                    ), modifier = Modifier.padding(vertical = 6.dp),color = Color.White
            )

        }

    }
}

@Composable
private fun getBitmap(): Bitmap? {
    val uri = uriState.collectAsState().value

    val imageState: AsyncImagePainter.State = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(uri)
            .size(Size.ORIGINAL)
            .build()
    ).state

    if (imageState is AsyncImagePainter.State.Success) {
        return imageState.result.drawable.toBitmap()
    }

    return null
}
