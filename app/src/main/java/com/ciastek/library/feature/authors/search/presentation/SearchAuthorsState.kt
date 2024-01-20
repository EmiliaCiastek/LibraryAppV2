package com.ciastek.library.feature.authors.search.presentation

data class SearchAuthorsState(
  val query: String,
  val isClearEnabled: Boolean,
  val authors: List<String>,
) {

  companion object {
    val empty by lazy {
      SearchAuthorsState(
        query = "",
        isClearEnabled = false,
        authors = emptyList()
      )
    }
  }
}
