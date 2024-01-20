package com.ciastek.library.feature.authors.search.data

import com.ciastek.library.feature.authors.search.domain.AuthorsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

  @Binds
  @Singleton
  fun bindAuthorsRepository(repository: AuthorsRepositoryImpl): AuthorsRepository
}
