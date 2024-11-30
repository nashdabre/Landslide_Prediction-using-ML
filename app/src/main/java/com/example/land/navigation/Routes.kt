package com.example.land.navigation

 sealed class Routes(val routes:String) {
     object  Splash: Routes("splash")
     object  Home: Routes("home")
     object BottomNav: Routes("bottom_nav")
     object Chatbot: Routes("chatbot")
     object Eyedoc: Routes("eyedoc")

     object Login: Routes("login")
     object Landslide: Routes("landslide")
     object Articel: Routes("articel")
     object Youtube: Routes("youtube")
     object Youtube1: Routes("youtube1")
     object Youtube2: Routes("youtube2")
     object Youtube3: Routes("youtube3")
     object landhistory: Routes("landhistory")
     object LandHistory1: Routes("LandHistory1")
     object LandHistory2: Routes("LandHistory2")
     object LandHistory3: Routes("LandHistory3")
     object LandHistory4: Routes("LandHistory4")
     object Contact: Routes("contact")
     object Analysis: Routes("analysis")
     object Output: Routes("output")









}