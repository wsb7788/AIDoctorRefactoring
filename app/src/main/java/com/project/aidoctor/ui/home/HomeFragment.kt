package com.project.aidoctor.ui.home


import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aidoctor.ApplicationClass
import com.project.aidoctor.data.entities.Disease
import com.project.aidoctor.data.entities.Hospital
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.databinding.DialogLogoutBinding
import com.project.aidoctor.databinding.DialogRefreshHospitalBinding
import com.project.aidoctor.databinding.FragmentHomeBinding
import com.project.aidoctor.ui.BaseFragment
import com.project.aidoctor.ui.disease.DiseaseActivity
import com.project.aidoctor.ui.hospital.HospitalActivity
import com.project.aidoctor.ui.main.MainActivity
import com.project.aidoctor.ui.notification.NotificationActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment(), HomeListener,HospitalRecyclerAdapter.OnItemClickListener,FileRecyclerAdapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()


    lateinit var hospitalRecyclerAdapter: HospitalRecyclerAdapter
    lateinit var fileRecyclerAdapter: FileRecyclerAdapter

    var locationManager: LocationManager? = null
    var locationListener: LocationListener? = null

    private lateinit var view: DialogRefreshHospitalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.homeListener = this



        recyclerInit()
        viewModel.loadDisease()
        viewModel.loadCovid()
        getLocation()
        binding.btnRefresh.setOnClickListener(this)

        hospitalRecyclerAdapter.setItemClickListener(this)
        fileRecyclerAdapter.setItemClickListener(this)
        binding.btnNotification.setOnClickListener(this)
        binding.btnRefreshHospital.setOnClickListener(this)

        return binding.root
    }



    private fun getLocation() {
        var lat = 0.0
        var lng = 0.0
        if(checkLocationPermission()){
            locationManager= activity?.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
            val userLocation:Location? = locationManager!!.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

            if (userLocation != null) {
                lat = userLocation.latitude
            }
            if (userLocation != null) {
                lng = userLocation.longitude
            }
        //    viewModel.loadHospital(lat.toFloat(),lng.toFloat())
            viewModel.loadHospital(127.1270.toFloat(),37.4476.toFloat())

        }
    }

    private fun checkLocationPermission():Boolean {
        if(ContextCompat.checkSelfPermission(ApplicationClass.instance,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(ApplicationClass.instance,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                return true
        else
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),0)
        return false
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnRefresh -> viewModel.loadCovid()
            binding.btnNotification -> startNoti()
            binding.btnRefreshHospital -> refreshDialog()
        }
    }

    private fun refreshDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        view = DialogLogoutBinding.inflate(layoutInflater)
        dialogBuilder.setView(view.root)
        val alertDialog = dialogBuilder.create()
        alertDialog.show()

        view.btnNo.setOnClickListener {
            alertDialog.dismiss()
        }
        view.btnOk.setOnClickListener {
            alertDialog.dismiss()
        }
    }

    private fun startNoti() {
        val intent = Intent(requireContext(),NotificationActivity::class.java )
        startActivity(intent)
    }

    private fun recyclerInit() {
        hospitalRecyclerAdapter = HospitalRecyclerAdapter()
        fileRecyclerAdapter = FileRecyclerAdapter()

        binding.rcvFile.apply{
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = fileRecyclerAdapter
        }

        binding.rcvHospital.apply{
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = hospitalRecyclerAdapter
        }

    }

    override fun onFailure(message: String) {
        requireContext().toast(message)
    }

    override fun onDiseaseLoad(results: ArrayList<Disease>) {
        val model = ArrayList<FileModel>()

        for(i in 0 until results.size){
            model.add(FileModel(results[i].DIS_NAME,results[i].DIS_SUMMARY,results[i].DIS_ROUTE,results[i].DIS_SYMPTOM,results[i].DIS_INCUB,results[i].DIS_PREVENT,results[i].DIS_SOLUTION))

        }
        viewModel.disease.postValue(results)
        fileRecyclerAdapter.clearList()
        fileRecyclerAdapter.submitList(model)
        fileRecyclerAdapter.notifyDataSetChanged()
    }

    override fun onCovidLoad(result: Int) {
        binding.tvCorona.text = result.toString()
    }

    override fun onHospitalLoad(results: ArrayList<Hospital>) {
        val model = ArrayList<HospitalModel>()

        for(i in 0 until results.size){
            model.add(HospitalModel(0,results[i].className,results[i].name,results[i].addr,results[i].phone,results[i].xPos.toFloat(),results[i].yPos.toFloat(),results[i].hospUrl))
        }
        hospitalRecyclerAdapter.clearList()
        hospitalRecyclerAdapter.submitList(model)
        hospitalRecyclerAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View, position: Int) {
        val item = hospitalRecyclerAdapter.getItemContent(position)
        val intent = Intent(context, HospitalActivity::class.java)
        intent.putExtra("item",item)
        startActivity(intent)
    }

    override fun onClickDisease(v: View, position: Int) {
        val item = fileRecyclerAdapter.getItemContent(position)
        val intent = Intent(context, DiseaseActivity::class.java)
        intent.putExtra("item",item)
        startActivity(intent)
    }


}