package com.ciastek.library.feature.authors.search.data

import com.ciastek.library.feature.authors.search.data.network.SearchAuthorsApi
import com.ciastek.library.feature.authors.search.domain.AuthorsRepository
import com.ciastek.library.feature.authors.search.domain.model.Author
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

internal class AuthorsRepositoryImpl @Inject constructor(
  private val api: SearchAuthorsApi
) : AuthorsRepository {

  private val authors = listOf(
    Author(
      id = UUID.randomUUID().toString(),
      name = "JRR Tolkien",
      imageUrl = generateImage(),
      topWork = "Hobbit",
      worksCount = 65
    ),
    Author(
      id = UUID.randomUUID().toString(),
      name = "James Patterson",
      imageUrl = generateImage(),
      topWork = "Something",
      worksCount = 650
    ),
    Author(
      id = UUID.randomUUID().toString(),
      name = "John Green",
      imageUrl = generateImage(),
      topWork = "Looking for alaska",
      worksCount = 15
    ),
    Author(
      id = UUID.randomUUID().toString(),
      name = "Marcin Mortka",
      imageUrl = generateImage(),
      topWork = "Nie ma tego złego",
      worksCount = 30
    ),
    Author(
      id = UUID.randomUUID().toString(),
      name = "Tess Gerritsen",
      worksCount = 123,
      topWork = "The Surgeon (Jane Rizzoli, Book 1)",
      imageUrl = "https://picsum.photos/200"
    )
  )

  private fun generateImage() =
    "https://picsum.photos/id/${Random.nextInt(IntRange(1, 200))}/200/200"

  private val recentResults = MutableStateFlow<List<Author>>(emptyList())

  override val searchResult: Flow<List<Author>> = recentResults

  override suspend fun searchAuthors(query: String) {
    val result = if (query.isBlank()) emptyList()
    else {
      api.getSearchResults(query)
        .items.map {
          Author(
            id = it.key,
            name = it.name,
            worksCount = it.workCount,
            topWork = it.topWork.orEmpty(),
            imageUrl = "https://covers.openlibrary.org/a/olid/${it.key}-S.jpg" // TODO: Change to const
          )
        }
    }

    recentResults.update {
      result
    }
  }
}
