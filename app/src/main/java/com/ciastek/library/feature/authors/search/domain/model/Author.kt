package com.ciastek.library.feature.authors.search.domain.model

internal data class Author(
  val id: String,
  val name: String,
  val imageUrl: String,
  val topWork: String,
  val worksCount: Int
)
