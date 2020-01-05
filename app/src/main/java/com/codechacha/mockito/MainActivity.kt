package com.codechacha.mockito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Log


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"

        fun isSampleAppInstalled(pm: PackageManager): Boolean {
            val SAMPLE_APP_PKG = "com.codechacha.sample"
            val ris = pm.getInstalledPackages(0)
            Log.d(TAG, "ris : $ris")
            for (ri: PackageInfo in ris) {
                if (ri.packageName == SAMPLE_APP_PKG) {
                    return true
                }
            }
            return false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isSampleAppInstalled(packageManager)) {
            Log.d(TAG, "Sample app is installed in the device.")
        }
    }
}
