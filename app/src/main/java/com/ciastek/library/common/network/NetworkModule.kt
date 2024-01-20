package com.ciastek.library.common.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object NetworkModule {

  private const val BASE_URL =
    "https://openlibrary.org/" //TODO: Could be in config to set up different enviorements

  @Provides
  @Singleton
  internal fun retrofit(
    client: OkHttpClient,
    converterFactory: Converter.Factory
  ): Retrofit =
    Retrofit.Builder()
      .addConverterFactory(converterFactory)
      .baseUrl(BASE_URL)
      .client(client)
      .build()

  @Provides
  @Singleton
  internal fun client(
    logging: HttpLoggingInterceptor,
  ): OkHttpClient {
    val builder = OkHttpClient.Builder()
      .addInterceptor(logging)
    //TODO: Add error Interceptor etc

    return builder.build()
  }

  @Provides
  @Singleton
  internal fun converterFactory(moshi: Moshi): Converter.Factory =
    MoshiConverterFactory.create(moshi).asLenient()

  @Provides
  @Singleton
  internal fun moshi(): Moshi =
    //TODO: Add custom adapters if needed
    Moshi.Builder()
      .addLast(KotlinJsonAdapterFactory())
      .build()

  @[Provides Singleton]
  internal fun loggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().setLevel(BODY) //TODO: Should be disable for release for example
}
