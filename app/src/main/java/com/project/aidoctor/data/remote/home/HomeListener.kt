package com.project.aidoctor.data.remote.home

import android.text.SpannableStringBuilder
import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.entities.Hospital

interface HomeListener {

    fun onFailure(message: String)
    fun onDiseaseLoad(results: ArrayList<Disease>)
    fun onCovidLoad(result: Int)
    fun onHospitalLoad(results: ArrayList<Hospital>)

}