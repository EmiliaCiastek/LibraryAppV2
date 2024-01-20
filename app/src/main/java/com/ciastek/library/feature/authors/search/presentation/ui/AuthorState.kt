package com.ciastek.library.feature.authors.search.presentation.ui

internal data class AuthorState(
  val id: String,
  val name: String,
  val worksCount: Int,
  val topWork: String,
  val imageUrl: String
) {
  companion object {
    val empty by lazy {
      AuthorState(
        id = "",
        name = "",
        worksCount = 0,
        topWork = "",
        imageUrl = ""
      )
    }
  }
}
