package com.ciastek.library.common.ui.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
  name = "Light Mode",
  group = "light",
  showBackground = true,
  backgroundColor = 0xFFFFFFFF
)
@Preview(name = "Dark Mode",
  uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
  group = "dark",
  showBackground = true,
  backgroundColor = 0xFF000000
)
annotation class LightDarkPreview()
