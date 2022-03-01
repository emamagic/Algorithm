package com.emamagic.algorithm

import android.util.Log

private const val TAG = "Test"
class Test {

    var albaloo = 0
    fun bubbleSort(list: ArrayList<Int>) {
        for (i in 0 until list.size) {
            var bubbleFound = false
            for (j in 0 until (list.size - 1) - i) {
                if (list[j] > list[j + 1]) {
                    val a = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = a
                    bubbleFound = true
                }
            }
            if (!bubbleFound) break
        }
        Log.e(TAG, "bubbleSort: $list $albaloo")
    }
    
    fun insertionSort(list: ArrayList<Int>) {
        for (i in 1 until list.size) {
            val tmp = list[i]
            var k = -1
            for (j in i -1 downTo  0) {
                if (list[tmp] < list[j]) {
                    list[j] = list[j - 1]
                    k = j
                }
            }
            if (k != -1) list[k] = tmp
        }
        Log.e(TAG, "insertionSort: $list")
    }

    fun selectionSort(list: ArrayList<Int>) {
        for (i in 0 until list.size) {
            var k = i
            for (j in 0 until list.size - i) {
                if (list[j] < list[i]) k = j
            }
            val a = list[k]
            list[k] = list[list.size -1 - i]
            list[list.size -1 - i] = a
        }
        Log.e(TAG, "selectionSort: $list")
    }

}