package com.example.core.common

import android.util.Log
import io.reactivex.functions.Consumer
import io.reactivex.plugins.RxJavaPlugins

/*
* RxJava error handling: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling
* */
object RxErrorHandler {

    fun onError(t: Throwable?) {
        try {
            setErrorHandler(t)
        } catch (e: Exception) {
            e.message?.let { Log.e("RxErrorHandler", it) }
        }
    }

    private fun setErrorHandler(throwable: Throwable?) {
        val consumer: Consumer<Throwable?> =
                Consumer { t: Throwable? -> Log.e("RxErrorHandler", t?.message ?: t.toString()) }
                        .also {
                            it.accept(throwable)
                        }
        RxJavaPlugins.setErrorHandler(consumer)
    }
}
