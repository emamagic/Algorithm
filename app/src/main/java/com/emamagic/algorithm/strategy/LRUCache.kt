package com.emamagic.algorithm.strategy

import android.util.Log

private const val CAPACITY = 5
private const val TAG = "LRUCache"

class LRUCache<K, V> constructor(
    private val capacity: Int? = CAPACITY
) {
    private val builder = StringBuilder()

    private val map = hashMapOf<K, Node<K, V>>()
    private var head = Node<K, V>(null, null, null, null)
    private var tail = Node<K, V>(null, null, null, null)

    data class Node<K, V>(
        var prev: Node<K, V>? = null,
        var next: Node<K, V>? = null,
        var key: K?,
        var value: V?
    )

    private fun delete(node: Node<K, V>) {
        if (node.prev != null) {
            node.prev!!.next = node.next
        } else {
            head = node.next!!
        }
        if (node.next != null) {
            node.next!!.prev = node.prev
        } else {
            tail = node.prev!!
        }
    }

    private fun updateHead(node: Node<K, V>) {
        node.next = head
        node.prev = null
        head.prev = node
        head = node
        tail = head
    }

    operator fun set(key: K, value: V) {
        if (map.containsKey(key)) {
            val old: Node<K, V> = map[key]!!
            old.value = value
            delete(old)
            updateHead(old)
        } else {
            val newNode = Node(key = key, value = value)
            if (map.size >= capacity!!) {
                map.remove(tail.key)
                // remove last node
                delete(tail)
                updateHead(newNode)
            } else {
                updateHead(newNode)
            }
            map[key] = newNode
        }
    }

    operator fun get(key: K): V? {
        if (map.containsKey(key)) {
            val n: Node<K,V> = map[key]!!
            delete(n)
            updateHead(n)
            return n.value
        }
        return null
    }

    fun print() {
        val currentValue: V? = head.value
        if (currentValue == null) {
            builder.append("[]")
        } else {
            builder.append('[')
            var currentNode: Node<K,V>? = head
            while (currentNode?.value != null) {
                builder.append(currentNode.value).append(", ")
                currentNode = currentNode.next
            }
            builder.delete(builder.length - 2, builder.length)
            builder.append(']')
        }
        Log.e(TAG, "linked list items -> $builder")
    }

}