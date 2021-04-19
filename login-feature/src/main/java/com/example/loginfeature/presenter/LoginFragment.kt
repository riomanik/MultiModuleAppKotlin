package com.example.loginfeature.presenter

import android.content.Context
import androidx.fragment.app.viewModels
import com.example.core.base.BaseDaggerFragment
import com.example.core.common.SafeObserver
import com.example.core_entity.login.Login
import com.example.loginfeature.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: BaseDaggerFragment() {

    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
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