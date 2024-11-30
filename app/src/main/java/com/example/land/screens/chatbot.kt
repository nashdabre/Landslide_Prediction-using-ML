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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddPhotoAlternate
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.land.R
import com.example.land.navigation.Routes
import com.example.land.viewModel.ChatViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

val uriState = MutableStateFlow("")


@Composable
fun ChatBot(navController: NavHostController) {



                        Scaffold(
                            topBar = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color(android.graphics.Color.parseColor("#336600")))
                                        .height(35.dp)
                                        .padding(horizontal = 16.dp)
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .align(Alignment.TopStart),
                                        text = stringResource(id = R.string.app_name),
                                        fontSize = 19.sp,
                                        color = Color.White
                                    )
                                }



                                    Box(
                                        modifier = Modifier.padding(top = 50.dp)
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
                                    }}

                        ) {
                            ChatScreen(paddingValues = it)
                        }
                    }





        @Composable
        fun ChatScreen(paddingValues: PaddingValues) {
            val chaViewModel = viewModel<ChatViewModel>()
            val chatState = chaViewModel.chatState.collectAsState().value

            val bitmap = getBitmap()


            val pickerMediaLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()){
                    uri ->
                uri?.let {
                    uriState.update { uri.toString() }

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(android.graphics.Color.parseColor("#F8FFFC")))
                    .padding(top = paddingValues.calculateTopPadding()),
                verticalArrangement = Arrangement.Bottom
            ) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    reverseLayout = true
                ) {
                    itemsIndexed(chatState.chatList) { index, chat ->
                        if (chat.isFromUser) {
                            UserChatItem(
                                prompt = chat.prompt, bitmap = chat.bitmap
                            )
                        } else {
                            ModelChatItem(response = chat.prompt)
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, start = 4.dp, end = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {
                        bitmap?.let {
                            Image(
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(bottom = 2.dp)
                                    .clip(RoundedCornerShape(6.dp)),
                                contentDescription = "picked image",
                                contentScale = ContentScale.Crop,
                                bitmap = it.asImageBitmap()
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.gallery),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                                //.padding(end = 6.dp)
                                .clickable {

                                    pickerMediaLauncher
                                        .launch(PickVisualMediaRequest(
                                            ActivityResultContracts
                                                .PickVisualMedia
                                                .ImageOnly))
                                }
                        )

                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    TextField(
                        modifier = Modifier
                            .weight(1f),
                        value = chatState.prompt,
                        onValueChange = {
                            chaViewModel.onEvent(ChatUiEvent.UpdatePrompt(it))
                        },
                        placeholder = {
                            Text(text = "Type a prompt")
                        }
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Image(
                        painter = painterResource(id = R.drawable.send),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            //.padding(end = 6.dp)
                            .clickable {
                                chaViewModel.onEvent(
                                    ChatUiEvent.SendPrompt(
                                        chatState.prompt,
                                        bitmap
                                    )
                                )
                                uriState.update { "" }
                            }
                    )


                }

            }

        }

        @Composable
        fun UserChatItem(prompt: String, bitmap: Bitmap?) {
            Column(
                modifier = Modifier.padding(start = 100.dp, bottom = 16.dp)
            ) {

                bitmap?.let {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp)
                            .padding(bottom = 2.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        bitmap = it.asImageBitmap()
                    )
                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(android.graphics.Color.parseColor("#004d40")))
                        .padding(16.dp),
                    text = prompt,
                    fontSize = 17.sp,
                    color = Color.White
                )

            }
        }

        @Composable
        fun ModelChatItem(response: String) {
            Column(
                modifier = Modifier.padding(end = 100.dp, bottom = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(android.graphics.Color.parseColor("#6C9E81")))
                        .padding(16.dp),
                    text = response,
                    fontSize = 17.sp,
                    color = Color.White
                )

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



