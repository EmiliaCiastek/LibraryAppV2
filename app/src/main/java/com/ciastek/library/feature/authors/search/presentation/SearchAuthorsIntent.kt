package com.ciastek.library.feature.authors.search.presentation

internal sealed interface SearchAuthorsIntent {

  data class QueryChanged(val query: String): SearchAuthorsIntent
  data class ToggleSearch(val isActive: Boolean): SearchAuthorsIntent
  data object ClearSearch: SearchAuthorsIntent
}
