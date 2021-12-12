package com.project.aidoctor.ui.disease

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityDiseaseBinding
import com.project.aidoctor.databinding.ActivityHospitalBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.home.HomeViewModel
import com.project.aidoctor.ui.home.HospitalModel
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import org.koin.androidx.viewmodel.ext.android.viewModel


class DiseaseActivity : BaseActivity() {

    private lateinit var binding: ActivityDiseaseBinding
    private val viewModel: HomeViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_disease)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel



    }


}야