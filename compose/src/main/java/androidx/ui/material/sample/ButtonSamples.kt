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

package androidx.ui.material.samples


import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.material.Button
import androidx.ui.material.OutlinedButtonStyle
import androidx.ui.material.TextButtonStyle
import androidx.ui.text.TextStyle


@Composable
fun OutlinedButtonSample(onClick: () -> Unit) {
    Button(text = "Outlined Button", onClick = onClick, style = OutlinedButtonStyle())
}


@Composable
fun ContainedButtonSample(onClick: () -> Unit) {
    // ContainedButtonStyle is the default style.
    Button(text = "Contained Button", onClick = onClick)
}


@Composable
fun TextButtonSample(onClick: () -> Unit) {
    Button(text = "Text Button", onClick = onClick, style = TextButtonStyle())
}


@Composable
fun ButtonSample(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Custom text style", style = TextStyle(color = Color.Green))
    }
}


@Composable
fun ButtonWithTextSample(onClick: () -> Unit) {
    Button(text = "Button", onClick = onClick)
}
