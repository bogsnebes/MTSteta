package com.bogsnebes.mts.data.dto

import com.google.gson.annotations.SerializedName

data class ActorDto(
    val name: String,
    @SerializedName("profile_path")
    val imageUrl: String)

