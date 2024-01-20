package com.ciastek.library.feature.authors.search.domain

import com.ciastek.library.feature.authors.search.domain.model.Author
import kotlinx.coroutines.flow.Flow

internal interface AuthorsRepository {

  val searchResult: Flow<List<Author>>

  suspend fun searchAuthors(query: String)
}
