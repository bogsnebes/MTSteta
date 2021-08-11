package com.bogsnebes.mts.data.dto

import java.io.Serializable
import kotlin.String

data class MovieDto(
    val title: String,
    val description: String,
    val rateScore: Int,
    val ageRestriction: Int,
    val imageUrl: String
) : Serializable