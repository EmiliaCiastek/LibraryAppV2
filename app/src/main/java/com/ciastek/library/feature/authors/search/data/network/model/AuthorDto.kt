package com.ciastek.library.feature.authors.search.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class AuthorSearchDto(
  @Json(name = "numFound")
  val numFound: Int,
  @Json(name = "docs")
  val items: List<AuthorDto>
) {
  @JsonClass(generateAdapter = true)
  internal data class AuthorDto(
    @Json(name = "key")
    val key: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "top_work")
    val topWork: String?,
    @Json(name = "work_count")
    val workCount: Int,
  )
}
