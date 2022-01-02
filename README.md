
# WPatternLock

android jetpack compose pattern lock library

[![](https://jitpack.io/v/amirhwsyn/WPatternLock.svg)](https://jitpack.io/#amirhwsyn/WPatternLock)

[![](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

- easy to use
- customizable
- beautiful design

## Installation

install WPatternLock library from jitpack.io repository

step 1 : Add the JitPack repository to your build file
```gradle
allprojects {
    repositories {
	...
	maven { url 'https://jitpack.io' }
    }
}
```

step 2 : Add WPatternLock the dependency
```gradle
dependencies {
    implementation 'com.github.amirhwsyn:WPatternLock:5.0.0'
}
```
## Usage

Use WPatternLock in composeable block

```kotlin
WPatternLock(
    size = 400.dp,
    // key -> sorted list of dots id that must connect
    key = arrayListOf(0, 1, 2),
    dotColor = Color.White,
    dotRadius = 18f,
    lineColor = Color.White,
    lineStroke = 12f,
    callback = object : WPatternLockCallback {
        override fun onStart() {
            // when wirting pattern start    
        }
        override fun onProgress(index: Int) {
            // when writing and new dot connected
            // index -> dot id
            // dots are sorted from left to right and up to down
        }
        override fun onEnd(result: ArrayList<Int>, isCorrect:Boolean) {
            // when writing pattern end
            // result -> connected dots during writing
            // isCorrect -> check if writed pattern correct based on key parameter
        }
    }
)
```

## Exampel
preview :

![Alt Text](https://media.giphy.com/media/FJAgeFnldh1NOhZYHR/giphy.gif)

code :

```kotlin
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
```


