package com.example.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    private lateinit var compositeDisposable: CompositeDisposable

    protected abstract fun getContentResource(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        compositeDisposable = CompositeDisposable()
        return inflater.inflate(getContentResource(), container, false)
    }

    @CallSuper
    protected open fun initLiveDataObservers() {
    }

    @CallSuper
    protected open fun initViews() {
    }

    @Inject
    lateinit var getContext: Context

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initLiveDataObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dispose()
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    protected fun Disposable.collect() = compositeDisposable.add(this)
}