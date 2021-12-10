package com.project.aidoctor.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityMainBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.chat.ChatActivity
import com.project.aidoctor.ui.home.HomeFragment
import com.project.aidoctor.ui.home.HospitalModel
import com.project.aidoctor.ui.hospital.HospitalFragment
import com.project.aidoctor.ui.profile.ProfileFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        showTabHome()
        binding.bnv.menu.getItem(1).isEnabled = false
        binding.bnv.setOnItemSelectedListener(this)
        binding.btnChat.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v){
            binding.btnChat -> startChat()
        }
    }

    private fun startChat() {
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> showTabHome()
            R.id.menu_profile -> showTabProfile()
        }
        return true
    }

    private fun showTabHome() {
        binding.bnv.menu.getItem(0).setIcon(R.drawable.ic_home_checked)
        binding.bnv.menu.getItem(2).setIcon(R.drawable.ic_setting)
        val transaction = manager.beginTransaction()
        val fragment = HomeFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun showTabProfile() {
        binding.bnv.menu.getItem(0).setIcon(R.drawable.ic_home)
        binding.bnv.menu.getItem(2).setIcon(R.drawable.ic_setting_checked)
        val transaction = manager.beginTransaction()
        val fragment = ProfileFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun openFragment(){
        val transaction = manager.beginTransaction()
        transaction.replace(binding.fragment.id,HospitalFragment())
        transaction.commit()
    }

    fun deliveryItem(item: HospitalModel) {
        HospitalFragment().setContent()
    }


}