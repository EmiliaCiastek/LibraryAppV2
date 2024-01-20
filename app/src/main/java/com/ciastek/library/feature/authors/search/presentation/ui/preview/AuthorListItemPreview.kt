package com.ciastek.library.feature.authors.search.presentation.ui.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.ciastek.library.feature.authors.search.presentation.ui.AuthorState
import java.util.UUID

internal class AuthorListItemPreview : PreviewParameterProvider<AuthorState> {

  override val values: Sequence<AuthorState> = authors.asSequence()
}

internal val authors = listOf(
  AuthorState(
    id = UUID.randomUUID().toString(),
    name = "Tess Gerritsen",
    worksCount = 123,
    topWork = "The Surgeon (Jane Rizzoli, Book 1)",
    imageUrl = "https://picsum.photos/200"
  ),
  AuthorState(
    id = UUID.randomUUID().toString(),
    name = "JRR Tolkien",
    worksCount = 65,
    topWork = "Unfinished Tales of Númenor and Middle-earth",
    imageUrl = "https://picsum.photos/200"
  )
)
