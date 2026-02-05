package com.lfonta.gymapp.core.utils

import android.content.Context
import android.os.Build
import android.util.Base64
import androidx.core.content.edit
import java.security.MessageDigest
import java.util.*

object DeviceIdManager {

    private const val PREFS_NAME = "device_prefs"
    private const val KEY_DEVICE_ID = "device_id"

    fun getDeviceId(context: Context): String {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        var savedId = prefs.getString(KEY_DEVICE_ID, null)

        if (savedId == null) {
            savedId = generateDeviceId()
            prefs.edit { putString(KEY_DEVICE_ID, savedId) }
        }

        return savedId
    }

    private fun generateDeviceId(): String {
        val deviceInfo = listOf(
            Build.MANUFACTURER,
            Build.MODEL,
            Build.VERSION.SDK_INT.toString(),
            Build.HARDWARE,
            TimeZone.getDefault().id
        ).joinToString("|")

        val randomPart = UUID.randomUUID().toString().take(8)

        val hash = sha256(deviceInfo + randomPart).take(12)

        return hash
    }

    private fun sha256(input: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(input.toByteArray(Charsets.UTF_8))
        return Base64.encodeToString(hashBytes, Base64.NO_WRAP).replace("[^a-zA-Z0-9]".toRegex(), "")
    }
}