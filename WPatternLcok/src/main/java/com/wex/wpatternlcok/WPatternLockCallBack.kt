package com.example.wpatternlock

interface WPatternLockCallback {
    fun onStart() {}
    fun onEnd(result: ArrayList<Int>, isCorrect:Boolean) {}
    fun onProgress(index: Int) {}
}