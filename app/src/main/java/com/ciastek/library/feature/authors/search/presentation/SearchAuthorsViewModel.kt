package com.ciastek.library.feature.authors.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ciastek.library.feature.authors.search.domain.ObserveSearchResult
import com.ciastek.library.feature.authors.search.domain.SearchAuthors
import com.ciastek.library.feature.authors.search.domain.model.Author
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.ClearSearch
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.QueryChanged
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.ToggleSearch
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsState.Companion.empty
import com.ciastek.library.feature.authors.search.presentation.ui.AuthorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
internal class SearchAuthorsViewModel @Inject constructor(
  private val searchAuthors: SearchAuthors,
  private val observeSearchResult: ObserveSearchResult,
) : ViewModel() {

  private val isSearching = MutableStateFlow(false)
  private val query = MutableStateFlow("")

  val state: StateFlow<SearchAuthorsState> =
    combine(
      query,
      isSearching,
      observeSearchResult()
    ) { query, isSearchActive, authors ->
      SearchAuthorsState(
        query = query,
        isClearEnabled = isSearchActive,
        authors = authors.toState()
      )
    }
      .stateIn(
        initialValue = empty,
        scope = viewModelScope,
        started = Eagerly
      )

  init {
    query
      .map { it }
      .distinctUntilChanged()
      .debounce(300) //TODO: Create const
      .onEach(searchAuthors::invoke)
      .launchIn(viewModelScope)
  }

  private fun List<Author>.toState() = //TODO: Create factory
    map {
      AuthorState(
        id = it.id,
        name = it.name,
        worksCount = it.worksCount,
        topWork = it.topWork,
        imageUrl = it.imageUrl
      )
    }

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
