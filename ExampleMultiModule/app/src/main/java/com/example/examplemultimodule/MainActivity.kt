package com.example.examplemultimodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.core.di.InjectUtils
import com.example.examplemultimodule.di.DaggerMainActivityComponent
import com.example.loginfeature.presenter.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent
            .builder()
            .coreComponent(InjectUtils.provideCoreComponent(applicationContext))
            .build()
            .inject(this)

        startActivity(Intent(this, LoginActivity::class.java))
    }

}