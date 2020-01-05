package com.codechacha.mockito

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest2 {

    @Test
    fun sample_app_is_installed() {
        val pi = PackageInfo()
        pi.packageName = "com.codechacha.sample"
        val installedApps: List<PackageInfo> = listOf(pi)

        val pm = Mockito.mock(PackageManager::class.java)
        Mockito.`when`(pm.getInstalledPackages(0)).thenReturn(installedApps)

        assertTrue(MainActivity.isSampleAppInstalled(pm))
    }

}
