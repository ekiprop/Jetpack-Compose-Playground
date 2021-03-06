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

package androidx.ui.animation.demos

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.animation.Crossfade
import androidx.ui.core.Draw
import androidx.ui.core.gesture.PressReleasedGestureDetector
import androidx.ui.core.setContent
import androidx.ui.graphics.Canvas
import androidx.ui.graphics.Color
import androidx.ui.graphics.Paint
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Row
import androidx.ui.unit.PxSize
import androidx.ui.unit.dp
import androidx.ui.unit.toRect
import kotlin.random.Random

class CrossfadeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CrossfadeDemo() }
    }
}

@Composable
private fun CrossfadeDemo() {
    var current by state { tabs[0] }
    Column {
        Row {
            tabs.forEach {
                PressReleasedGestureDetector(onRelease = {
                    Log.e("Crossfade", "Switch to $it")
                    current = it
                }) {
                    Container(LayoutFlexible(1f) + LayoutHeight(48.dp)) {
                        DrawTab(tab = it)
                    }
                }
            }
        }
        Crossfade(current = current) { tab ->
            tab.lastInt = remember { Random.nextInt() }
            Container(LayoutSize.Fill) {
                DrawTab(tab = tab)
            }
        }
    }
}

@Composable
private fun DrawTab(tab: Tab) {
    Draw { canvas: Canvas, parentSize: PxSize ->
        canvas.drawRect(parentSize.toRect(), Paint().apply { color = tab.color })
    }
}

private val tabs = listOf(
    Tab(Color(1f, 0f, 0f)),
    Tab(Color(0f, 1f, 0f)),
    Tab(Color(0f, 0f, 1f))
)

private data class Tab(val color: Color) {
    var lastInt: Int = 0
        set(value) {
            if (value != field) {
                Log.e("Crossfade", "State recreated for $color")
                field = value
            }
        }
}