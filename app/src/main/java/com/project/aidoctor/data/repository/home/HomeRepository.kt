package com.project.aidoctor.data.repository.home

import com.project.aidoctor.data.entities.User
import com.project.aidoctor.data.remote.home.CovidResponse
import com.project.aidoctor.data.remote.home.DiseaseResponse
import com.project.aidoctor.data.remote.home.HomeService
import com.project.aidoctor.data.remote.home.HospitalResponse

import com.project.aidoctor.data.remote.login.LoginResponse
import com.project.aidoctor.data.remote.login.LoginService
import com.project.aidoctor.data.repository.BaseRepository

class HomeRepository(private val homeService: HomeService) : BaseRepository() {
    suspend fun disease(): DiseaseResponse {
        return apiRequest { homeService.disease() }
    }
    suspend fun covid(): CovidResponse {
        return apiRequest { homeService.covid() }
    }
    suspend fun hospital(xPos:Float,yPos:Float,subCode:Int): HospitalResponse {
        return apiRequest { homeService.hospital(xPos,yPos,subCode) }
    }
}
