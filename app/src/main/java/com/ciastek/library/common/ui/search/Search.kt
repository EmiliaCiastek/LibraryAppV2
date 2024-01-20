package com.ciastek.library.common.ui.search

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ciastek.library.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicSearchBar(
  modifier: Modifier,
  query: String,
  clearEnabled: Boolean,
  @StringRes placeholderRes: Int = R.string.search_placeholder,
  searchSuggestionsVisible: Boolean = false,
  clearClicked: () -> Unit,
  queryChanged: (String) -> Unit,
  activeChanged: (Boolean) -> Unit
) {
  SearchBar(
    modifier = modifier,
    leadingIcon = { SearchIcon() },
    trailingIcon = { ClearSearchIcon(clearEnabled, clearClicked) },
    placeholder = { SearchPlaceholder(placeholderRes) },
    query = query,
    onQueryChange = queryChanged,
    onSearch = queryChanged,
    active = searchSuggestionsVisible,
    onActiveChange = activeChanged,
  ) {
  }
}

@Composable
private fun SearchIcon() {
  Icon(imageVector = Outlined.Search, contentDescription = "")
}

@Composable
private fun ClearSearchIcon(
  isClearEnabled: Boolean,
  onClick: () -> Unit
) {
  if (isClearEnabled) {
    IconButton(onClick = onClick) {
      Icon(imageVector = Outlined.Clear, contentDescription = "")
    }
  }
}

@Composable
private fun SearchPlaceholder(@StringRes placeholderRes: Int) {
  Text(text = stringResource(id = placeholderRes))
}
