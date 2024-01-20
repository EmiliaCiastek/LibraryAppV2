package com.ciastek.library.feature.authors.search.presentation.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ciastek.library.feature.authors.search.presentation.SearchAuthorsViewModel

@Composable
internal fun SearchAuthorsScreen() {
  val viewModel = hiltViewModel<SearchAuthorsViewModel>()


}
