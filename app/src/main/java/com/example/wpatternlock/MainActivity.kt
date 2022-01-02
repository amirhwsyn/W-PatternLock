package com.example.wpatternlock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wpatternlock.ui.theme.WPatternLockTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WPatternLockTheme {
                    WPatternLock(
                        size = 400.dp,
                        key = arrayListOf(0, 1, 2),
                        dotColor = Color.White,
                        dotRadius = 18f,
                        lineColor = Color.White,
                        lineStroke = 12f,
                        callback = object : WPatternLockCallback {
                            override fun onStart() {

                            }
                            override fun onProgress(index: Int) {

                            }
                            override fun onEnd(result: ArrayList<Int>, isCorrect:Boolean) {

                            }
                        }
                    )
            }
        }
    }
}