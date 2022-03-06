package com.emamagic.algorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.emamagic.algorithm.dynamic_array.DynamicArray
import com.emamagic.algorithm.linked_list.LinkedList
import com.emamagic.algorithm.sort.*
import com.emamagic.algorithm.stack.Expression
import com.emamagic.algorithm.stack.StringReverser
import com.emamagic.algorithm.strategy.LRUCache

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = arrayListOf(1, 1, 6, 2, 2, 2, 5, 12, 3, 8, 4, 3, 6)
//        val arrayList = arrayListOf(1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 8)

        CountSort().sort(arrayList)
        InsertionSort().sort(arrayList)
        BubbleSort().sort(arrayList)
        SelectionSort().sort(arrayList)
        val t = MergeSort().sort(arrayList)
        Test().selectionSort(arrayList)

        val dynamicArray = DynamicArray(4)

        dynamicArray.insert(10)
        dynamicArray.insert(20)
        dynamicArray.insert(30)
        dynamicArray.insert(40)

        dynamicArray.insert(50)
        dynamicArray.insert(60)
        dynamicArray.insert(70)
        dynamicArray.insert(80)

        dynamicArray.insert(90)
        dynamicArray.insert(100)
        dynamicArray.insert(110)
        dynamicArray.insert(120)

//        dynamicArray.print()

        val linkedList = LinkedList()

        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        linkedList.addLast(40)
        linkedList.addLast(50)
        linkedList.addLast(60)
//        linkedList.addLast(70)

        val loopList = LinkedList.createWithLoop()
        Log.e(TAG, "onCreate: " + loopList.hasLoop())

        val lruCache = LRUCache<String, Int>(2)

        lruCache["one"] = 1
        lruCache["two"] = 2
        lruCache["one"]
        lruCache.print()

        val reverser = StringReverser()
        val output = reverser.revers("abcd")
        Log.e(TAG, "onCreate: $output")

        val expression = Expression();
        val isExpression = expression.isBalance("(1+2)")
        Log.e(TAG, "onCreate: $isExpression")


    }
}