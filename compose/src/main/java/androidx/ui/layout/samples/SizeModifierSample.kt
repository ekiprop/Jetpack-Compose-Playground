/*
 * Copyright 2019 The Android Open Source Project
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

package androidx.ui.layout.samples


import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.foundation.ColoredRect
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Align
import androidx.ui.layout.Center
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutAspectRatio
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.unit.dp


@Composable
fun SimpleSizeModifier() {
    Center {
        Container(modifier = LayoutSize(width = 100.dp, height = 100.dp)) {
            DrawShape(shape = RectangleShape, color = Color.Red)
        }
    }
}


@Composable
fun SimpleWidthModifier() {
    Center {
        Container(modifier = LayoutWidth(100.dp) + LayoutAspectRatio(1f)) {
            DrawShape(shape = RectangleShape, color = Color.Magenta)
        }
    }
}


@Composable
fun SimpleHeightModifier() {
    Center {
        Container(modifier = LayoutHeight(100.dp) + LayoutAspectRatio(1f)) {
            DrawShape(shape = RectangleShape, color = Color.Blue)
        }
    }
}


@Composable
fun SimpleFillWidthModifier() {
    Container(modifier = LayoutWidth.Fill) {
        DrawShape(RectangleShape, Color.Red)
        ColoredRect(color = Color.Magenta, width = 100.dp, height = 100.dp)
    }
}


@Composable
fun SimpleFillHeightModifier() {
    Align(alignment = Alignment.TopLeft) {
        Container(modifier = LayoutHeight.Fill) {
            DrawShape(RectangleShape, Color.Red)
            ColoredRect(color = Color.Magenta, width = 100.dp, height = 100.dp)
        }
    }
}


@Composable
fun SimpleFillModifier() {
    Align(alignment = Alignment.TopLeft) {
        Container(modifier = LayoutSize.Fill) {
            DrawShape(RectangleShape, Color.Red)
            ColoredRect(color = Color.Magenta, width = 100.dp, height = 100.dp)
        }
    }
}
