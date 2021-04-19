package com.example.core.common

import android.app.Activity
import com.example.core.base.BaseApplication


fun Activity.coreComponent() = BaseApplication.coreComponent(this)