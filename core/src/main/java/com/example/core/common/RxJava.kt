package com.example.core.common

import android.util.Log
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

fun <T> Single<T>.customSubscribe(success: (T) -> Unit, error: (LionParcelHttpException) -> Unit): Disposable {
    return this.subscribe(Consumer {
        success(it)
    }, object : CustomErrorConsumer() {
        override fun accept(it: LionParcelHttpException) {
            RxErrorHandler.onError(it)
            Log.d(this::class.java.simpleName, it.localizedMessage, it)
            error(it)
        }
    })
}

fun <T> Single<T>.customSubscribe(success: (T) -> Unit): Disposable {
    return this.customSubscribe(
        success,
        {
            RxErrorHandler.onError(it)
            Log.d(this::class.java.simpleName, it.localizedMessage, it)
        }
    )
}