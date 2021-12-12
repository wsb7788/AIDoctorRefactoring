package com.project.aidoctor.ui.disease

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityDiseaseBinding
import com.project.aidoctor.databinding.ActivityHospitalBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.home.FileModel
import com.project.aidoctor.ui.home.HomeViewModel
import com.project.aidoctor.ui.home.HospitalModel
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import org.koin.android.compat.SharedViewModelCompat
import org.koin.androidx.viewmodel.ext.android.viewModel


class DiseaseActivity : BaseActivity() {

    private lateinit var binding: ActivityDiseaseBinding
    private val viewModel: HomeViewModel by viewModel()

    lateinit var item:FileModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_disease)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        item = intent.getSerializableExtra("item") as FileModel
        setContent()
    }

    private fun setContent() {

        binding.tvName.text = item.name
        binding.tvIncub.text = item.incub
        binding.tvRoute.text = item.route
        binding.tvSolution.text = item.solution
        binding.tvSummary.text = item.summary
        binding.tvSymptom.text = item.symptom
    }


}