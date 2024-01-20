package com.ciastek.library.feature.authors.search.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

  @Provides
  fun api(retrofit: Retrofit): SearchAuthorsApi =
    retrofit.create(SearchAuthorsApi::class.java)
}
