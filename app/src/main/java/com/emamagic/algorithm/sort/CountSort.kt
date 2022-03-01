package com.emamagic.algorithm.sort

import android.util.Log

private const val TAG = "CountSort"
class CountSort {


    fun sort(list: List<Int>) {
        val max = list.maxOrNull() ?: 0
        val result = ArrayList<Int>(max)
        for (i in 0..max) { result.add(0) }
        list.forEach { result[it] += 1 }
        result.forEachIndexed { index, i ->
            for (j in 1..i) {
                Log.e(TAG, "$index")
            }
        }
    }


}