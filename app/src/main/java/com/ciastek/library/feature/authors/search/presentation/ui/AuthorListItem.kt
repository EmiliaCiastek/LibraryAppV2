package com.ciastek.library.feature.authors.search.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ciastek.library.R
import com.ciastek.library.common.ui.preview.LightDarkPreview
import com.ciastek.library.common.ui.theme.Corners.SmallCorners
import com.ciastek.library.common.ui.theme.Corners.SmallStartCorners
import com.ciastek.library.common.ui.theme.LibraryAppV2Theme
import com.ciastek.library.common.ui.theme.Spacing.Margin_10
import com.ciastek.library.feature.authors.search.presentation.ui.preview.AuthorListItemPreview

@Composable
internal fun AuthorListItem(
  state: AuthorState
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .background(colorScheme.surface, SmallCorners),
    verticalAlignment = Alignment.CenterVertically
  ) {

    AsyncImage(
      model = state.imageUrl,
      modifier = Modifier
        .size(ImageSize)
        .clip(SmallStartCorners),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      placeholder = ColorPainter(color = colorScheme.error),
    )
    Column(
      modifier = Modifier
        .padding(horizontal = Margin_10)
        .fillMaxWidth(),
    ) {
      Text(
        text = state.name,
        style = typography.labelLarge,
        color = colorScheme.onSurface
      )

      Text(
        text = stringResource(id = R.string.works_count, state.worksCount),
        style = typography.labelMedium,
        color = colorScheme.onSurfaceVariant
      )

      Text(
        text = state.topWork,
        style = typography.labelMedium,
        color = colorScheme.onSurfaceVariant,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
    }
  }
}

val ImageSize = 60.dp

@LightDarkPreview
@Composable
private fun AuthorItemPreview(
  @PreviewParameter(AuthorListItemPreview::class)
  state: AuthorState
) {
  LibraryAppV2Theme {
    AuthorListItem(state)
  }
}

