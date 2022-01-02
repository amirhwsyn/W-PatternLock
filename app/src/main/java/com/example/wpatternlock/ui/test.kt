package com.example.wpatternlock.ui

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CanvasTest(){
    val infiniteTransition = rememberInfiniteTransition()
    val value by infiniteTransition.animateFloat(
        100f,
        50f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = AnimationConstants.DefaultDurationMillis),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = Modifier.size(400.dp)){
        drawCircle(Color.Red,radius =value,center = Offset(center.x,center.y))
    }
}