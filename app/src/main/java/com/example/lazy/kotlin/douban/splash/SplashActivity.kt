package com.example.lazy.kotlin.douban.splash

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lazy.kotlin.R
import com.example.lazy.kotlin.douban.main.MainActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class SplashActivity : AppCompatActivity() {
    val PERMISSION_LIST = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

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
        RxPermissions(this)
                .request(*PERMISSION_LIST)
                .subscribe({
                    if (it) {
                        doAsync {
                            Thread.sleep(500)
                            uiThread {
                                startMainActivity()
                            }
                        }
                    } else {
                        finish()
                    }
                }, {
                    toast(it.message!!)
                })
    }

    private fun startMainActivity() {
        startActivity<MainActivity>()
        finish()
        overridePendingTransition(0, 0)
    }
}
