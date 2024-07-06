package com.example.jetpackcomposetuto.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var superheroName: String,
    var realName: String,
    val publisher: String,
    @DrawableRes var photo: Int
)
