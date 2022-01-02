package com.example.wpatternlock

interface WPatternLockCallback {
    fun onStart() {}
    fun onEnd(result: ArrayList<Int>) {}
    fun onProgress(index: Int) {}
    fun onCorrect() {}
    fun onWrong() {}
}