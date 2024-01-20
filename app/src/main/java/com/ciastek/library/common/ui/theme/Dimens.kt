package com.ciastek.library.common.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

object Spacing {
  val Margin_16 = 16.dp
  val Margin_10 = 10.dp
  val Margin_5 = 5.dp
}

object Corners {
  private val SmallCornersSize = 4.dp
  val SmallCorners = RoundedCornerShape(SmallCornersSize)
  val SmallStartCorners = RoundedCornerShape(topStart = SmallCornersSize, bottomStart = SmallCornersSize)
}
