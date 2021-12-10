package com.project.aidoctor.ui.hospital


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.databinding.FragmentHospitalBinding
import com.project.aidoctor.databinding.FragmentProfileBinding
import com.project.aidoctor.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class HospitalFragment : BaseFragment() {

    private var _binding: FragmentHospitalBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HospitalViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHospitalBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel



        return binding.root
    }


}