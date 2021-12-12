package com.project.aidoctor.ui.hospital

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityHospitalBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.home.HospitalModel
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import org.koin.androidx.viewmodel.ext.android.viewModel


class HospitalActivity : BaseActivity() {

    private lateinit var binding: ActivityHospitalBinding
    private val viewModel: HospitalViewModel by viewModel()

    lateinit var item:HospitalModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hospital)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        item = intent.getSerializableExtra("item") as HospitalModel

        setContent()

        binding.btnCall.setOnClickListener(this)
    }

    private fun setContent() {
        binding.tvName.text = item.name
        binding.tvCall.text = item.call
        binding.tvLocation.text = item.location
        if(item.url.isNullOrEmpty())
            binding.tvUrl.text = "정보없음"
        else
            binding.tvUrl.text = item.url

        val xpo = item.xPos
        val ypo = xpo!!.toDouble()
        val mapView = MapView(this)
        binding.mv.addView(mapView)
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(item.yPos!!.toDouble(),item.xPos!!.toDouble() ), true);

        val marker = MapPOIItem()
        marker.itemName = item.name
        marker.tag = 0
        marker.mapPoint = MapPoint.mapPointWithGeoCoord(item.yPos!!.toDouble(), item.xPos!!.toDouble())
        marker.markerType = MapPOIItem.MarkerType.BluePin // 기본으로 제공하는 BluePin 마커 모양.

        marker.selectedMarkerType =
            MapPOIItem.MarkerType.RedPin // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.


        mapView.addPOIItem(marker)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnCall -> call()
        }
    }

    private fun call() {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+item.call!!.replace("-","")))
        startActivity(intent)

    }


}