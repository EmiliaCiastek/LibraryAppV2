package com.ciastek.library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ciastek.library.common.ui.theme.LibraryAppV2Theme
import com.ciastek.library.feature.authors.search.presentation.ui.SearchAuthorsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      LibraryAppV2Theme {
        //TODO: Add bottom bar and change main screen
        SearchAuthorsScreen()
      }
    }
  }
}
