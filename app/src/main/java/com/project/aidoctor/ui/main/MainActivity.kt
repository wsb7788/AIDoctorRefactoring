package com.project.aidoctor.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.project.aidoctor.R
import com.project.aidoctor.databinding.ActivityMainBinding
import com.project.aidoctor.ui.BaseActivity
import com.project.aidoctor.ui.chat.ChatFragment
import com.project.aidoctor.ui.home.HomeFragment
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


        binding.bnv.menu.getItem(2).isEnabled = false
        showTabHome()


        binding.bnv.setOnItemSelectedListener(this)

    }


    override fun onClick(v: View?) {

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> showTabHome()
            R.id.menu_profile -> showTabProfile()
            R.id.menu_chat -> showTabChat()
        }
        return true
    }

    private fun showTabHome() {
        binding.bnv.selectedItemId = R.id.menu_home
        val transaction = manager.beginTransaction()
        val fragment = HomeFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun showTabProfile() {
        binding.bnv.selectedItemId = R.id.menu_profile
        val transaction = manager.beginTransaction()
        val fragment = ProfileFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun showTabChat() {
        binding.bnv.selectedItemId = R.id.menu_chat
        val transaction = manager.beginTransaction()
        val fragment = ChatFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }




}