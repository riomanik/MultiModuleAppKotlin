package com.example.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseViewModelActivity<T : BaseViewModel> : AppCompatActivity() {

    protected val viewModel by lazy { buildViewModel() }

    protected abstract fun buildViewModel(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initLiveDataObservers()
    }


    protected open fun initView() {
    }

    protected open fun initLiveDataObservers() {
    }

}