package com.bogsnebes.mts.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import kotlin.String

@Entity(tableName = "films")
data class MovieDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null,

    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("vote_average")
    val rateScore: Float,
    @SerializedName("adult")
    val ageRestriction: Boolean,
    @SerializedName("poster_path")
    val imageUrl: String
) : Serializable