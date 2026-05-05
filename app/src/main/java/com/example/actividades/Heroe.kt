package com.example.actividades

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Heroe(
    var nombre: String,
    var nivel: Int,
    var vida: Int
) : Parcelable