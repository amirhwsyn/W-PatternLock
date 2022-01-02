package com.example.wpatternlock

import android.view.MotionEvent
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


data class DOT(
    val id: Int,
    val position: Offset
)

data class LINE(
    val start: Offset,
    val end: Offset
)

@ExperimentalComposeUiApi
@Composable
fun WPatternLock(
    size: Dp,
    key: ArrayList<Int>,
    dotColor: Color,
    dotRadius: Float,
    lineColor: Color,
    lineStroke: Float,
    callback: WPatternLockCallback
) {
    var PROGRESS_KEY by remember { mutableStateOf(ArrayList<Int>()) }
    var DOTS by remember { mutableStateOf(ArrayList<DOT>()) }
    var LINES by remember { mutableStateOf(ArrayList<LINE>()) }
    var CONNECTED_DOTS by remember { mutableStateOf(ArrayList<DOT>()) }
    var DOT_RANGE by remember { mutableStateOf(0f) }
    var PROGRESS by remember { mutableStateOf(false) }
    var LINE_PREVIEW_START by remember {
        mutableStateOf(
            Offset(0f, 0f)
        )
    }
    var LINE_PREVIEW_END by remember {
        mutableStateOf(
            Offset(0f, 0f)
        )
    }
    val scope = rememberCoroutineScope()
    val AnimateDotDelay = 18.toLong()
    var ANIMATED_DOT_0 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_1 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_2 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_3 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_4 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_5 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_6 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_7 by remember {
        mutableStateOf(Animatable(dotRadius))
    }
    var ANIMATED_DOT_8 by remember {
        mutableStateOf(Animatable(dotRadius))
    }

    Canvas(
        modifier = Modifier
            .size(size)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        for (dot in DOTS) {
                            if (it.x in dot.position.x - DOT_RANGE..dot.position.x + DOT_RANGE &&
                                it.y in dot.position.y - DOT_RANGE..dot.position.y + DOT_RANGE
                            ) {
                                LINE_PREVIEW_START = Offset(dot.position.x, dot.position.y)
                                LINE_PREVIEW_END = Offset(dot.position.x, dot.position.y)
                                PROGRESS = true
                                callback.onStart()
                            }
                        }
                    }
                    MotionEvent.ACTION_MOVE -> {
                        if (PROGRESS) LINE_PREVIEW_END = Offset(it.rawX, it.rawY)
                        for (dot in DOTS) {
                            if (it.x in dot.position.x - DOT_RANGE..dot.position.x + DOT_RANGE &&
                                it.y in dot.position.y - DOT_RANGE..dot.position.y + DOT_RANGE &&
                                !CONNECTED_DOTS.contains(dot)
                            ) {
                                // set new line
                                if (PROGRESS) {
                                    val LINES_OLD_LIST = LINES
                                    val LINES_NEW_LIST = arrayListOf<LINE>()
                                    for (line in LINES_OLD_LIST) LINES_NEW_LIST.add(line)
                                    LINES_NEW_LIST.add(LINE(LINE_PREVIEW_START, dot.position))
                                    LINES = LINES_NEW_LIST
                                    LINE_PREVIEW_START = Offset(dot.position.x, dot.position.y)
                                }

                                // add dot
                                if (PROGRESS) {
                                    val DOT_OLD_LIST = CONNECTED_DOTS
                                    val DOT_NEW_LIST = arrayListOf<DOT>()
                                    for (DOT in DOT_OLD_LIST) DOT_NEW_LIST.add(DOT)
                                    DOT_NEW_LIST.add(dot)
                                    CONNECTED_DOTS = DOT_NEW_LIST
                                    callback.onProgress(dot.id)
                                    scope.launch {
                                        when (dot.id) {
                                            0 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_0.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_0.animateTo(dotRadius)
                                            }
                                            1 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_1.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_1.animateTo(dotRadius)
                                            }
                                            2 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_2.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_2.animateTo(dotRadius)
                                            }
                                            3 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_3.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_3.animateTo(dotRadius)
                                            }
                                            4 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_4.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_4.animateTo(dotRadius)
                                            }
                                            5 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_5.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_5.animateTo(dotRadius)
                                            }
                                            6 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_6.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_6.animateTo(dotRadius)
                                            }
                                            7 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_7.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_7.animateTo(dotRadius)
                                            }
                                            8 -> {
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_8.animateTo(dotRadius * 2)
                                                delay(AnimateDotDelay)
                                                ANIMATED_DOT_8.animateTo(dotRadius)
                                            }
                                        }
                                    }
                                }

                                if (PROGRESS) {
                                    val KEY_OLD_LIST = PROGRESS_KEY
                                    val KEY_NEW_LIST = arrayListOf<Int>()
                                    for (KEY in KEY_OLD_LIST) KEY_NEW_LIST.add(KEY)
                                    KEY_NEW_LIST.add(dot.id)
                                    PROGRESS_KEY = KEY_NEW_LIST
                                }
                            }
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        PROGRESS = false
                        LINE_PREVIEW_START = Offset(0f, 0f)
                        LINE_PREVIEW_END = Offset(0f, 0f)
                        LINES = arrayListOf()
                        CONNECTED_DOTS = arrayListOf()
                        callback.onEnd(PROGRESS_KEY, key == PROGRESS_KEY)
                        PROGRESS_KEY = arrayListOf()
                    }
                }
                true
            }
    ) {
        val CANVAS_WIDTH = this.size.width
        val CANVAS_CENTER = this.center
        val DOT_DISTANCE = CANVAS_WIDTH / 3
        DOT_RANGE = DOT_DISTANCE / 3.5f
        val dots = arrayListOf(
            // Raw 1
            DOT(
                0,
                Offset(CANVAS_CENTER.x - DOT_DISTANCE, CANVAS_CENTER.y - DOT_DISTANCE)
            ),
            DOT(
                1,
                Offset(CANVAS_CENTER.x, CANVAS_CENTER.y - DOT_DISTANCE)
            ),
            DOT(
                2,
                Offset(CANVAS_CENTER.x + DOT_DISTANCE, CANVAS_CENTER.y - DOT_DISTANCE)
            ),
            // Raw 2
            DOT(
                3,
                Offset(CANVAS_CENTER.x - DOT_DISTANCE, CANVAS_CENTER.y)
            ),
            DOT(
                4,
                Offset(CANVAS_CENTER.x, CANVAS_CENTER.y)
            ),
            DOT(
                5,
                Offset(CANVAS_CENTER.x + DOT_DISTANCE, CANVAS_CENTER.y)
            ),
            // Raw 3
            DOT(
                6,
                Offset(CANVAS_CENTER.x - DOT_DISTANCE, CANVAS_CENTER.y + DOT_DISTANCE)
            ),
            DOT(
                7,
                Offset(CANVAS_CENTER.x, CANVAS_CENTER.y + DOT_DISTANCE)
            ),
            DOT(
                8,
                Offset(CANVAS_CENTER.x + DOT_DISTANCE, CANVAS_CENTER.y + DOT_DISTANCE)
            ),
        )
        DOTS = dots
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_0.value,
            dots[0].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_1.value,
            dots[1].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_2.value,
            dots[2].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_3.value,
            dots[3].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_4.value,
            dots[4].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_5.value,
            dots[5].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_6.value,
            dots[6].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_7.value,
            dots[7].position,
        )
        drawCircle(
            color = dotColor,
            ANIMATED_DOT_8.value,
            dots[8].position,
        )

        // draw preview line
        if (PROGRESS) {
            drawLine(lineColor, LINE_PREVIEW_START, LINE_PREVIEW_END, lineStroke)
        }
        // draw main lines
        if (PROGRESS) {
            for (line in LINES) drawLine(lineColor, line.start, line.end, lineStroke)
        }
    }
}