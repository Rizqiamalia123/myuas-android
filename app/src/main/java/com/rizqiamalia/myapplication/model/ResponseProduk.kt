package com.rizqiamalia.myapplication.model

import com.google.gson.annotations.SerializedName

data class ResponseProduk(
    @SerializedName("status") val status: Boolean,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: List<DataProduk>?
)