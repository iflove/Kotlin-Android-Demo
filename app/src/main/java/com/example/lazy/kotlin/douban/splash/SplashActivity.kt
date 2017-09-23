package com.example.lazy.kotlin.douban.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.main.MainActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class SplashActivity : AppCompatActivity() {
    companion object {
        var isSplashed = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isSplashed.not()) {
            setContentView(R.layout.activity_splash)
            inHome()
            isSplashed = true
            return
        }
        startMainActivity()
    }

    private fun inHome() {
        doAsync {
            Thread.sleep(500)
            uiThread {
                startMainActivity()
            }
        }
    }

    private fun startMainActivity() {
        startActivity<MainActivity>()
        finish()
        overridePendingTransition(0, 0)
    }
}
