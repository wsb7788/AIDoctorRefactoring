package com.project.aidoctor.data.remote.home

import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.entities.Hospital


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

data class HospitalResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val results: ArrayList<Hospital>,
    val radius:Int,
    val cnt:Int
)


