package com.example.loginfeature.presenter

import android.content.Context
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.core.base.BaseDaggerViewModelFragment
import com.example.core.common.SafeObserver
import com.example.core.common.coreComponent
import com.example.core_entity.login.Login
import com.example.loginfeature.R
import com.example.loginfeature.di.DaggerLoginComponent
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: BaseDaggerViewModelFragment() {

    private val viewModel: LoginViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        DaggerLoginComponent.factory().create(coreComponent()).inject(this)
        super.onAttach(context)
    }

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
        viewModel.userInfoLiveData.observe(viewLifecycleOwner, SafeObserver{
            tvUserInfo.text = it.title
        })
        viewModel.userIdPrefLiveData.observe(viewLifecycleOwner, SafeObserver{
            tvUserIdPref.text = it
        })
        viewModel.loginDataFromDbLiveData.observe(viewLifecycleOwner, SafeObserver{
            tvDataFromDb.text = it.username
        })
    }

}