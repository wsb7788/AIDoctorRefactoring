package com.project.aidoctor.data.remote.home

import com.project.aidoctor.data.entities.Disease


data class DiseaseResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val results: ArrayList<Disease>
)
data class CovidResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val results: Int
)


