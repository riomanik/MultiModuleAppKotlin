package com.example.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable


abstract class BaseDaggerFragment : Fragment() {

    private lateinit var compositeDisposable: CompositeDisposable

    protected val initDaggerFragment by lazy { buildDaggerFragment() }

    protected abstract fun buildDaggerFragment()

    override fun onAttach(context: Context) {
        initDaggerFragment
        super.onAttach(context)
    }

    protected abstract fun getContentResource(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        compositeDisposable = CompositeDisposable()
        return inflater.inflate(getContentResource(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
        initLiveDataObservers()
    }

    @CallSuper
    protected open fun initLiveDataObservers() {
    }

    @CallSuper
    protected open fun initViews() {
    }

}
