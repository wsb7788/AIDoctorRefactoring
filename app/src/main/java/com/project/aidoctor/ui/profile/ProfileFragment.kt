package com.project.aidoctor.ui.profile


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.aidoctor.data.remote.profile.ProfileListener
import com.project.aidoctor.databinding.DialogLogoutBinding
import com.project.aidoctor.databinding.FragmentProfileBinding
import com.project.aidoctor.ui.BaseFragment
import com.project.aidoctor.ui.login.LoginActivity
import com.project.aidoctor.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : BaseFragment(),ProfileListener {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by viewModel()

    private lateinit var view: DialogLogoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.profileListener = this


        binding.btnLogout.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {

        when(v){
            binding.btnLogout -> logoutDialog()
        }
    }

    private fun logoutDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        view = DialogLogoutBinding.inflate(layoutInflater)
        dialogBuilder.setView(view.root)
        val alertDialog = dialogBuilder.create()
        alertDialog.show()

        view.btnNo.setOnClickListener {
            alertDialog.dismiss()
        }
        view.btnOk.setOnClickListener {
            viewModel.logout()
        }

    }

    override fun onFailure(message: String) {
        requireContext().toast(message)
    }

    override fun onSuccess() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
    }


}