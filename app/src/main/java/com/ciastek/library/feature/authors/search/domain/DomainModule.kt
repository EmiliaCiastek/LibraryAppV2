package com.ciastek.library.feature.authors.search.domain

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DomainModule {

  @Binds
  fun bindSearchAuthors(useCase: SearchAuthorsUseCase): SearchAuthors

  @Binds
  fun bindObserveSearchResult(useCase: ObserveSearchResultUseCase): ObserveSearchResult
}
