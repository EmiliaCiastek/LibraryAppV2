package com.ciastek.library.feature.authors.search.domain

import com.ciastek.library.feature.authors.search.domain.model.Author
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal interface ObserveSearchResult {

  operator fun invoke(): Flow<List<Author>>
}

internal class ObserveSearchResultUseCase @Inject constructor(
  private val repository: AuthorsRepository
) : ObserveSearchResult {

  override fun invoke(): Flow<List<Author>> =
    repository.searchResult
}
