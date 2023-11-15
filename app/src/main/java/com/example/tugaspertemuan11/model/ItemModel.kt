package com.example.tugaspertemuan11.model

import com.google.gson.annotations.SerializedName

data class ItemModel(
    @SerializedName("title") val title: String,
    @SerializedName("category") val category: String,
    @SerializedName("price") val price: String
)

