package com.rizqiamalia.myapplication.model

import com.google.gson.annotations.SerializedName

data class DataProduk(
    @SerializedName("id") val id: Long?,
    @SerializedName("nama") val nama: String?,
    @SerializedName("ukuran") val ukuran: String?,
    @SerializedName("stok") val stok: String?,
    @SerializedName("harga") val harga: String?,
    @SerializedName("gambar") val gambar: String?
)