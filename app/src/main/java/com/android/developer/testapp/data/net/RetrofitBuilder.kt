package com.android.developer.testapp.data.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    private val baseUrl = "http://85.143.218.128:10000/"

    val serverApi: ServerApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getInterceptor())
            .build()

        serverApi = retrofit.create(ServerApi::class.java)
    }

    private fun getInterceptor(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.connectTimeout(20, TimeUnit.SECONDS)
        client.readTimeout(20, TimeUnit.SECONDS)
        client.interceptors().add(Interceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "key_for_test")
                .method(original.method(), original.body())
                .build()
            chain.proceed(request)
        })
        return client.build()
    }
}