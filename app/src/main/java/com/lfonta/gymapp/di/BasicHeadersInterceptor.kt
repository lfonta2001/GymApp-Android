package com.lfonta.gymapp.di

import com.lfonta.gymapp.GymApp
import com.lfonta.gymapp.core.utils.DeviceIdManager
import com.lfonta.gymapp.data.local.storage.SessionStorage
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BasicHeadersInterceptor @Inject constructor(
    private val sessionStorage: SessionStorage
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val tempRequest = original.newBuilder()
            .addHeader("Accept",  "application/json")
            .addHeader("X-Device-ID", DeviceIdManager.getDeviceId(GymApp.appContext))
            .addHeader("X-Client-Version", "0.0.1")

        if (original.url.pathSegments.contains("private")) {
            val token = runBlocking {
                sessionStorage.accessTokenFlow.first()
            }

            if (token != null) {
                tempRequest
                    .addHeader("Authorization", "Bearer $token")
            }
        }

        val newRequest = tempRequest.build()

        return chain.proceed(newRequest)
    }
}