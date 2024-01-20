package com.ciastek.library.feature.authors.search.presentation.ui

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import com.ciastek.library.common.ui.preview.LightDarkPreview
import com.ciastek.library.common.ui.search.BasicSearchBar
import com.ciastek.library.common.ui.theme.LibraryAppV2Theme
import com.ciastek.library.common.ui.theme.Spacing.Margin_16
import com.ciastek.library.common.ui.theme.Spacing.Margin_5
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.ClearSearch
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.QueryChanged
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsIntent.ToggleSearch
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsState
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsViewModel
import com.ciastek.library.feature.authors.search.presentation.ui.preview.SearchAuthorsPreview

@Composable
internal fun SearchAuthorsScreen() {
  val viewModel = hiltViewModel<SearchAuthorsViewModel>()
  val state by viewModel.state.collectAsState()

  SearchAuthorsContent(state, viewModel::handleIntent)
}

@Composable
private fun SearchAuthorsContent(
  state: SearchAuthorsState,
  sendIntent: (SearchAuthorsIntent) -> Unit
) {
  Scaffold(
    topBar = {
      BasicSearchBar(
        modifier = Modifier
          .fillMaxWidth()
          .padding(Margin_16),
        query = state.query,
        clearEnabled = state.isClearEnabled,
        queryChanged = {
          sendIntent(QueryChanged(it))
        },
        activeChanged = { sendIntent(ToggleSearch(it)) },
        clearClicked = { sendIntent(ClearSearch) }
      )
    }
  ) {
    AuthorsList(state = state, paddingValues = it)
  }
}

@Composable
private fun AuthorsList(
  state: SearchAuthorsState,
  paddingValues: PaddingValues
) {
  LazyColumn(
    modifier = Modifier
      .padding(paddingValues)
      .padding(horizontal = Margin_16),
    verticalArrangement = spacedBy(Margin_5),
  ) {
    items(
      items = state.authors,
      key = { it.id }
    ) { item ->
      AuthorListItem(item)
    }
  }
}

@LightDarkPreview
@Composable
private fun SearchAuthorsScreenPreview(
  @PreviewParameter(SearchAuthorsPreview::class)
  state: SearchAuthorsState
) {
  LibraryAppV2Theme {
    SearchAuthorsContent(state) {}
  }
}
