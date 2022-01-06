package com.rizqiamalia.myapplication.model

import com.google.gson.annotations.SerializedName

data class DataUser(
    @SerializedName("id") val id: Long?,
    @SerializedName("nama") val nama: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("gambar") val gambar: String?
)