package com.project.aidoctor.ui.chat


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.aidoctor.data.remote.home.HomeListener
import com.project.aidoctor.databinding.FragmentChatBinding
import com.project.aidoctor.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ChatFragment : Fragment(), HomeListener {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ChatViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentChatBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.homeListener = this

        return binding.root
    }


}