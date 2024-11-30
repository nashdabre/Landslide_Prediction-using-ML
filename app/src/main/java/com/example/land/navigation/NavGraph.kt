package com.example.land.navigation

import android.app.Notification
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.land.screens.Analysis
import com.example.land.screens.BottomNav
import com.example.land.screens.ChatBot
import com.example.land.screens.Contact
import com.example.land.screens.LandHistory1
import com.example.land.screens.LandHistory2
import com.example.land.screens.LandHistory3
import com.example.land.screens.LandHistory4
import com.example.land.screens.Landslide
import com.example.land.screens.Output
import com.example.land.screens.Splash
import com.example.land.screens.articel
import com.example.land.screens.landhistory
import com.example.land.screens.youtube
import com.example.land.screens.youtube1
import com.example.land.screens.youtube2
import com.example.land.screens.youtube3

/*
import com.example.land.screens.ChatBot
import com.example.land.screens.Doctor
import com.example.land.data.Chat
import com.example.land.screens.Eyedoc
import com.example.land.screens.BottomNav
import com.example.land.screens.Home
import com.example.land.screens.Ineyedoc1
import com.example.land.screens.Languages
import com.example.land.screens.Login
import com.example.land.screens.Register
import com.example.land.screens.Splash
import com.example.land.screens.StartPage
*/


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.routes
    ) {


        composable(Routes.Splash.routes) {
            Splash(navController)
        }

        composable(Routes.Landslide.routes) {
            Landslide(navController)
        }

        composable(Routes.Articel.routes) {
            articel(navController)
        }

        composable(Routes.Chatbot.routes){
            ChatBot(navController)
        }
        composable(Routes.BottomNav.routes) {
            BottomNav(navController)}

        composable(Routes.landhistory.routes) {
            landhistory(navController)
        }
        composable(Routes.LandHistory1.routes) {
            LandHistory1(navController)
        }

        composable(Routes.LandHistory2.routes) {
            LandHistory2(navController)
        }
        composable(Routes.Contact.routes) {
            Contact(navController)
        }

        composable(Routes.LandHistory3.routes) {
            LandHistory3(navController)
        }

        composable(Routes.LandHistory4.routes) {
            LandHistory4(navController)
        }

        composable(Routes.Youtube.routes){
            youtube(navController,youtubeVideoId = "0NfI-8a6LH0", lifecycleOwner = LocalLifecycleOwner.current)//navController
        }
        composable(Routes.Youtube1.routes){
            youtube1(navController,youtubeVideoId = "0DYeyrYAh40", lifecycleOwner = LocalLifecycleOwner.current)
        }
        composable(Routes.Youtube2.routes){
            youtube2(navController,youtubeVideoId = "JlCy7ul7-pQ", lifecycleOwner = LocalLifecycleOwner.current)
        }
        composable(Routes.Youtube3.routes){
            youtube3(navController,youtubeVideoId = "IDvEqNPpcKA", lifecycleOwner = LocalLifecycleOwner.current)
        }
        composable(Routes.Analysis.routes){
            Analysis(navController)
        }

        composable(Routes.Output.routes){
                    Output(navController)
                }






    }
}

