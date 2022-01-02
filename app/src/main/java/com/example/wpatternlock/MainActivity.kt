package com.example.wpatternlock

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wpatternlock.ui.theme.WPatternLockTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WPatternLockTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    WPatternLock(
                        size = 400.dp,
                        key = arrayListOf(0, 1, 2, 5, 8),
                        dotColor = Color.White,
                        dotRadius = 18f,
                        lineColor = Color.White,
                        lineStroke = 12f,
                        callback = object : WPatternLockCallback {
                            override fun onStart() {
                                Toast.makeText(this@MainActivity,"start!",Toast.LENGTH_LONG).show()
                            }
                            override fun onProgress(index: Int) {
                                Toast.makeText(this@MainActivity,"dot $index connected!",Toast.LENGTH_LONG).show()
                            }
                            override fun onEnd(result: ArrayList<Int>, isCorrect:Boolean) {
                                Toast.makeText(this@MainActivity,"pattern was ${if (isCorrect) "correct" else "wrong"}",Toast.LENGTH_LONG).show()
                            }
                        }
                    )
                }
            }
        }
    }
}