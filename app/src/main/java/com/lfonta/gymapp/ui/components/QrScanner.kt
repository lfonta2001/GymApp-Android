package com.lfonta.gymapp.ui.components

import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

private fun checkCameraHardware(context: Context): Boolean {
    return context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)
}

@Composable
fun QrScanner(modifier: Modifier) {
    val context = LocalContext.current
    Text(
        if (checkCameraHardware(context)) "Has Camera" else "Not Camera"
    )
}