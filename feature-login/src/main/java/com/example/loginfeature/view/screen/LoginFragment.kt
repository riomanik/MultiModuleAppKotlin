package com.example.loginfeature.view.screen

import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.core.base.BaseFragment
import com.example.core.common.SafeObserver
import com.example.entity.login.domain.Login
import com.example.loginfeature.R
import com.example.loginfeature.view.util.LoginNavBarMenu
import com.example.loginfeature.view.viewmodel.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModels { factory }

    override fun getContentResource(): Int = R.layout.fragment_login

    override fun initViews() {
        super.initViews()
        btnGetUserInfo.setOnClickListener{
            viewModel.getUserInfo()
        }
        btnGetUserId.setOnClickListener {
            viewModel.getUserIdSharePref()
        }
        btnSaveToDb.setOnClickListener {
            viewModel.saveDataToDb(
                Login(
                    1,
                    "Junifer"
                )
            )
        }
        btnGetFromDb.setOnClickListener {
            viewModel.getDataFromDb()
        }
        toolbar.title = "HOME"
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView: BottomNavigationView = bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected)
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        toolbar.title = item.titleCondensed
        return when (item.itemId) {
            LoginNavBarMenu.HOME.menuRes -> {
                Toast.makeText(getContext, "HOME", Toast.LENGTH_SHORT).show()
                true
            }
            LoginNavBarMenu.PROFILE.menuRes -> {
                Toast.makeText(getContext, "PROFILE", Toast.LENGTH_SHORT).show()
                true
            }
            else -> return false
        }
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.userInfoLiveData.observe(this, SafeObserver{
            tvUserInfo.text = it.title
        })
        viewModel.userIdPrefLiveData.observe(this, SafeObserver{
            tvUserIdPref.text = it
        })
        viewModel.loginDataFromDbLiveData.observe(this, SafeObserver{
            tvDataFromDb.text = it.username
        })
    }

}