package com.emamagic.algorithm.sort

import android.util.Log

private const val TAG = "BubbleSort"
class BubbleSort {

    fun sort(list: ArrayList<Int>) {
        for (i in 0 until list.size) {
            var bubbleFound = false
            for (j in 0 until (list.size - 1) - i) {
                if (list[j] > list[j + 1]) {
                    val a = list[i]
                    list[j] = list[j + 1]
                    list[j + 1] = a
                    bubbleFound = true
                }
                if (!bubbleFound) break
            }
        }
        Log.e(TAG, "$list")
    }

}