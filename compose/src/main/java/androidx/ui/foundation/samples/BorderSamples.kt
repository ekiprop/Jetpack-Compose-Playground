/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.foundation.samples

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Border
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.HorizontalGradient
import androidx.ui.graphics.TileMode
import androidx.ui.layout.LayoutPadding
import androidx.ui.unit.dp
import androidx.ui.unit.px

@Composable

fun BorderSampleWithColor() {
    Text(
        "Text with border",
        modifier = Border(shape = CircleShape, width = 2.dp, color = Color.Red) +
                LayoutPadding(10.dp)
    )
}

@Composable

fun BorderSampleWithBrush() {
    val gradientBrush = HorizontalGradient(
        colors = listOf(Color.Red, Color.Blue, Color.Green),
        startX = 0.px,
        endX = 500.px,
        tileMode = TileMode.Repeated
    )
    Text(
        "Text with border",
        modifier = Border(shape = CircleShape, width = 2.dp, brush = gradientBrush) +
                LayoutPadding(10.dp)
    )
}