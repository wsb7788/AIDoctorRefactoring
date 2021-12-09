package com.project.aidoctor.data.remote.home

import android.text.SpannableStringBuilder
import com.project.aidoctor.data.entities.Disease

interface HomeListener {

    fun onFailure(message: String)
    fun onDiseaseLoad(results: ArrayList<Disease>)
    fun onCovidLoad(result: Int)

}