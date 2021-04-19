package com.example.core.common

import androidx.fragment.app.Fragment
import com.example.core.base.BaseApplication


fun Fragment.coreComponent() = BaseApplication.coreComponent(requireContext())