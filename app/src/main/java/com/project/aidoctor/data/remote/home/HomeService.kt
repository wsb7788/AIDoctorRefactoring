package com.project.aidoctor.data.remote.home

import com.project.aidoctor.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface HomeService {
    @GET("/disease/")
    suspend fun disease(
    ): Response<DiseaseResponse>

    @GET("/api/covid")
    suspend fun covid(
    ): Response<CovidResponse>

    @FormUrlEncoded
    @POST("/api/hospital")
    suspend fun hospital(
        @Field("xPos") xPos:Float,
        @Field("yPos") yPos:Float,
        @Field("sbjCode") sbjCode:Int
    ): Response<HospitalResponse>
}