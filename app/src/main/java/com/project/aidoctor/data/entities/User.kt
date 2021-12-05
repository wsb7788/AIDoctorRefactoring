package com.project.aidoctor.data.entities

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "userName") val userName: String = "",
    @SerializedName(value = "password") val password: String = ""

)