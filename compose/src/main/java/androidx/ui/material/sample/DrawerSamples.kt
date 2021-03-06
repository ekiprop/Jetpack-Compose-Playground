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
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.foundation.ColoredRect
import androidx.ui.graphics.Color
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.material.BottomDrawerLayout
import androidx.ui.material.Button
import androidx.ui.material.DrawerState
import androidx.ui.material.ModalDrawerLayout
import androidx.ui.material.StaticDrawer
import androidx.ui.unit.dp


@Composable
fun StaticDrawerSample() {
    Row(LayoutWidth.Fill) {
        StaticDrawer {
            Center {
                Text("Drawer Content")
            }
        }
        ColoredRect(Color.Black, width = 1.dp)
        Text("Rest of App")
    }
}


@Composable
fun ModalDrawerSample() {
    val (state, onStateChange) = state { DrawerState.Closed }
    val appContentText =
        if (state == DrawerState.Closed) ">>> Pull to open >>>" else "<<< Swipe to close <<<"
    ModalDrawerLayout(
        drawerState = state,
        onStateChange = onStateChange,
        drawerContent = { YourDrawerContent(onStateChange) },
        bodyContent = { YourAppContent(appContentText, onStateChange) }
    )
}


@Composable
fun BottomDrawerSample() {
    val (state, onStateChange) = state { DrawerState.Closed }
    val appContentText =
        if (state == DrawerState.Closed) "▲▲▲ Pull to open ▲▲▲" else "▼▼▼ Drag down to close ▼▼▼"
    BottomDrawerLayout(
        drawerState = state,
        onStateChange = onStateChange,
        drawerContent = { YourDrawerContent(onStateChange) },
        bodyContent = { YourAppContent(appContentText, onStateChange) }
    )
}

@Composable
private fun YourDrawerContent(onStateChange: (DrawerState) -> Unit) {
    Container(expanded = true) {
        Column(LayoutHeight.Fill) {
            Text(text = "Drawer Content")
            Spacer(LayoutHeight(20.dp))
            Button(
                text = "Close Drawer",
                onClick = { onStateChange(DrawerState.Closed) })
        }
    }
}

@Composable
private fun YourAppContent(text: String, onDrawerStateChange: (DrawerState) -> Unit) {
    Center {
        Column(LayoutHeight.Fill) {
            Text(text = text)
            Spacer(LayoutHeight(20.dp))
            Button(
                text = "Click to open",
                onClick = { onDrawerStateChange(DrawerState.Opened) }
            )
        }
    }
}
