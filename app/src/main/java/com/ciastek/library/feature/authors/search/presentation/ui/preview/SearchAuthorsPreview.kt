package com.ciastek.library.feature.authors.search.presentation.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsState

internal class SearchAuthorsPreview : PreviewParameterProvider<SearchAuthorsState> {

  override val values: Sequence<SearchAuthorsState> = sequenceOf(
    SearchAuthorsState(
      query = "e",
      isClearEnabled = true,
      authors = listOf("Tess Gerritsen", "JRR Tolkien")
    ),
    SearchAuthorsState(
      query = "",
      isClearEnabled = false,
      authors = emptyList()
    )
  )
}
