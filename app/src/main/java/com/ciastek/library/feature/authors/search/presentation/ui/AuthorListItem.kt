package com.ciastek.library.feature.authors.search.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ciastek.library.common.ui.theme.Spacing.Margin_10
import com.ciastek.library.common.ui.theme.Spacing.Margin_16

@Composable
fun AuthorListItem(
  author: String
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = Margin_16, vertical = Margin_10)
      .background(colorScheme.background),
  ) {
    Text(
      text = author,
      style = typography.titleMedium,
      color = colorScheme.onBackground
    )
  }

}
