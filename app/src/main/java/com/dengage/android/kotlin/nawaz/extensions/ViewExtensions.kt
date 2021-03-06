package com.dengage.android.kotlin.nawaz.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Created by Batuhan Coskun on 03 December 2020
 */
fun View.inflater(): LayoutInflater = LayoutInflater.from(context)

fun ViewGroup.inflate(
    @LayoutRes resourceId: Int,
    root: ViewGroup = this,
    attachToRoot: Boolean = false
): View {
    return inflater().inflate(resourceId, root, attachToRoot)
}