package com.codechacha.mockito

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.test.InstrumentationRegistry
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExampleInstrumentedTest {

    @Test
    fun sample_app_is_installed() {
        val pm = Mockito.mock(PackageManager::class.java)

        val pi = PackageInfo()
        pi.packageName = "com.codechacha.sample"
        val installedApps: List<PackageInfo> = listOf(pi)
        Mockito.`when`(pm.getInstalledPackages(0)).thenReturn(installedApps)

        val appContext = InstrumentationRegistry.getTargetContext()
        assertTrue(MainActivity.isSampleAppInstalled(pm))
    }

}
