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

package androidx.ui.framework.demos.gestures

import android.app.Activity
import android.os.Bundle
import androidx.compose.state
import androidx.ui.core.gesture.DoubleTapGestureDetector
import androidx.ui.core.setContent
import androidx.ui.unit.PxPosition
import androidx.ui.unit.dp
import androidx.ui.unit.px

/**
 * Simple DoubleTapGestureDetector demo.
 */
class DoubleTapGestureDetectorDemo : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color = state { Colors.random() }

            val onDoubleTap: (PxPosition) -> Unit = {
                color.value = color.value.anotherRandomColor()
            }

            Center {
                DoubleTapGestureDetector(onDoubleTap = onDoubleTap) {
                    SimpleContainer(192.dp, 192.dp, 0.dp) {
                        DrawBox(
                            0.px,
                            0.px,
                            192.dp,
                            192.dp,
                            color.value
                        )
                    }
                }
            }
        }
    }
}