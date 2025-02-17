package com.afsoftwaresolutions.horoscopeapp.ui.permissions

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PermissionsHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val cameraPermission = android.Manifest.permission.CAMERA

    fun checkCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context, cameraPermission
        ) == PackageManager.PERMISSION_GRANTED
    }
}