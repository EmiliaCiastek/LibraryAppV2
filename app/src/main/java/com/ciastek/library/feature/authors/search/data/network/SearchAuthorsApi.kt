package com.ciastek.library.feature.authors.search.data.network

import com.ciastek.library.feature.authors.search.data.network.model.AuthorSearchDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface SearchAuthorsApi {

  @GET("search/authors.json")
  suspend fun getSearchResults(
    @Query("q") query: String,
    @Query("limit") limit: Int = 10
  ): AuthorSearchDto
}
