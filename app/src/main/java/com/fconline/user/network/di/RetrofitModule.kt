package com.fconline.user.network.di

import com.fconline.user.network.api.ApiService
import com.fconline.user.network.di.RetrofitModule.provideOkHttpClient
import com.fconline.user.util.DateUtil
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val BASE_URL = "https://open.api.nexon.com"

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .setDateFormat(DateUtil.serverDateFormat.toPattern())
                .create()
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: AppInterceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            connectTimeout(5, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
            addInterceptor(interceptor)
                .build()
        }


    @Provides
    @Singleton
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .client(provideOkHttpClient(AppInterceptor()))
            .baseUrl(logBaseUrl(BASE_URL))
            .build()
    }

    private fun logBaseUrl(baseUrl: String): String {
        Timber.d("baseUrl $baseUrl")
        return baseUrl
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    class AppInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val newRequest = request().newBuilder()
                .addHeader(
                    "x-nxopen-api-key",
                    "live_901d5ca7706fde3f983d01b7990cad822aeadc51ffdea73da5b295535c277d57cefff0e1831c601b1b53fc439bbdf214"
                )
                .build()
            proceed(newRequest)
        }
    }
}