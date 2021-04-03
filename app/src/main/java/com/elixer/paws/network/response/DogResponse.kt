package com.elixer.paws.network.response

import com.google.gson.annotations.SerializedName

data class DogResponse(

    @SerializedName("message")
        var message: List<String>,

    @SerializedName("status")
        var status: String,
)