package com.ciastek.library.feature.authors.search.domain

import javax.inject.Inject

internal interface SearchAuthors {

  suspend operator fun invoke(query: String)
}

internal class SearchAuthorsUseCase @Inject constructor(
  private val repository: AuthorsRepository
) : SearchAuthors {

  override suspend fun invoke(query: String) =
    repository.searchAuthors(query)
}
