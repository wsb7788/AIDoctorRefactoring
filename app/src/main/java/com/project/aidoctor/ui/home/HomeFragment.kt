package com.project.aidoctor.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(), HomeListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()


    lateinit var hospitalRecyclerAdapter: HospitalRecyclerAdapter
    lateinit var fileRecyclerAdapter: FileRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.homeListener = this


        recyclerInit()


        return binding.root
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
        val model1 = ArrayList<FileModel>()
        val model2 = ArrayList<HospitalModel>()
        for(i in 0..2){
            model1.add(FileModel("",""))
            model2.add(HospitalModel(1,"","",""))
        }
        fileRecyclerAdapter.submitList(model1)
        hospitalRecyclerAdapter.submitList(model2)
        fileRecyclerAdapter.notifyDataSetChanged()
        hospitalRecyclerAdapter.notifyDataSetChanged()
    }


}