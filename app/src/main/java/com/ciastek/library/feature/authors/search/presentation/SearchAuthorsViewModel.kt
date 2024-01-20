package com.ciastek.library.feature.authors.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.ClearSearch
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.QueryChanged
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.ToggleSearch
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsState.Companion.empty
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class SearchAuthorsViewModel @Inject constructor(

) : ViewModel() {

  private val isSearching = MutableStateFlow(false)
  private val query = MutableStateFlow("")
  private val authors = flowOf(
    listOf(
      "Tess Gerritsen",
      "JRR Tolkien",
      "Mark Twain",
      "James Patterson"
    )
  )

  val state =
    combine(
      query,
      isSearching,
      authors
    ) { query, isSearchActive, authors ->
      SearchAuthorsState(
        query = query,
        isClearEnabled = isSearchActive,
        authors = authors.filter { it.contains(query, ignoreCase = true) }
      )
    }.stateIn(
      initialValue = empty,
      scope = viewModelScope,
      started = Eagerly
    )

  fun handleIntent(intent: SearchAuthorsIntent) {
    when (intent) {
      is QueryChanged -> onSearchTextChange(intent.query)
      is ToggleSearch -> onToogleSearch(intent.isActive)
      ClearSearch -> query.update { "" }
    }
  }

  private fun onSearchTextChange(text: String) {
    query.update {
      text
    }
  }

  private fun onToogleSearch(isActive: Boolean) {
    isSearching.value = isActive
  }
}
