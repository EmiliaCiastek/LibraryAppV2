package com.ciastek.library.feature.authors.search.presentation

import com.ciastek.library.feature.authors.search.presentation.ui.AuthorState

internal data class SearchAuthorsState(
  val query: String,
  val isClearEnabled: Boolean,
  val authors: List<AuthorState>,
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
