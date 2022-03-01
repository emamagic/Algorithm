package com.emamagic.algorithm.dynamic_array;

import android.util.Log;

// Vector vs ArrayList :)
public class DynamicArray {

    private static final String TAG = "DynamicArray";
    private final StringBuilder builder = new StringBuilder();

    private int count;
    private int[] mArray;

    public DynamicArray(int length) {
        mArray = new int[length];
    }

    public void insert(int item) {
        resizeIfRequired();
        mArray[count++] = item;
    }

    private void resizeIfRequired() {
        if (mArray.length == count) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < mArray.length; i++) newArray[i] = mArray[i];
            mArray = newArray;
        }
    }

    public void removeAt(int index) throws Exception {
        if (index >= 0 && index < count) {
            for (int i = index; i < count; i++) mArray[i] = mArray[i + 1];
            count--;
        } else throw new Exception("Out Of Bound Exception");

    }

    // first index of
    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (mArray[i] == item) return i;
        return -1;
    }

    public int max() {
        int max = mArray[0];
        for (int i = 1; i < count; i++)
            if (mArray[i] > max) max = mArray[i];
        return max;
    }

    public DynamicArray intersect(DynamicArray array) {
        int length = count;
        if (count > array.length()) length = array.length();
        DynamicArray intersectArray = new DynamicArray(length);
        for (int i = 0; i < count; i++)
            for (int j = 0; j < array.length(); j++)
                if (array.indexOf(mArray[j]) >= 0) intersectArray.insert(mArray[j]);
        return intersectArray;
    }

    public void reverse() {
        int[] newArray = new int[count];
        for (int i = 0; i < count; i++)
            newArray[i] = mArray[count - 1 - i];
        mArray = newArray;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException("Invalid Index");
        resizeIfRequired();
        for (int i = count - 1; i >= index; i--) mArray[i + 1] = mArray[i];
        mArray[index] = item;
        count++;
    }


    public int length() {
        return count;
    }


    public void print() {
        builder.setLength(0);
        builder.append("[");
        for (int i = 0; i < mArray.length; i++) {
            if (i == mArray.length - 1) builder.append(mArray[i]);
            else builder.append(mArray[i]).append(", ");
        }
        builder.append("]");
        Log.e(TAG, "dynamic array items -> " + builder);
    }

}
