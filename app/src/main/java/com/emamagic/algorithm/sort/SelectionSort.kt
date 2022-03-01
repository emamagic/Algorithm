package com.emamagic.algorithm.sort

import android.util.Log

private const val TAG = "SelectionSort"
class SelectionSort {

    fun sort(list: ArrayList<Int>) {
        for (i in 0 until list.size - 1) {
            var index = i
            for (j in i+1 until list.size) {
                if (list[j] < list[index]) { index = j }
            }
            val c = list[i]
            list[i] = list[index]
            list[index] = c
        }
        Log.e(TAG, "$list")
    }

}