package com.project.aidoctor.data.entities

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "user_email") val user_email: String = "",
    @SerializedName(value = "user_pw") val user_pw: String = "",
    @SerializedName(value = "user_name") val user_name: String = "",
    @SerializedName(value = "user_bdate") val user_bdate: String = "",

)