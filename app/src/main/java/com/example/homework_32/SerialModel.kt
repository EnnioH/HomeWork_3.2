package com.example.homework_32

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SerialModel(
    val image: String,
    val name: String,
    val episode: String,
    val date: String
) : Parcelable