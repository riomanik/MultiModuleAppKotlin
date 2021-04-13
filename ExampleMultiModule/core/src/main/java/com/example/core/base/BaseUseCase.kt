package com.example.core.base

import com.example.core.common.SchedulerTransformer
import io.reactivex.Single

abstract class BaseUseCase<T> {

    abstract fun buildSingle(): Single<T>

    fun execute(): Single<T> {
        return buildSingle().compose(SchedulerTransformer())
    }
}