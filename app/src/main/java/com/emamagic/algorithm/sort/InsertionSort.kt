package com.emamagic.algorithm.sort

import android.util.Log

private const val TAG = "InsertionSort"
class InsertionSort {

    fun sort(list: ArrayList<Int>) {
        for (i in 1 until list.size) {
            val tmp = list[i]
            var k = -1
            for (j in i-1 downTo 0) {
                if (tmp < list[j]) {
                    list[j+1] = list[j]
                    k = j
                }
            }
            if (k != -1) list[k] = tmp
        }
        Log.e(TAG, "$list")
    }
}