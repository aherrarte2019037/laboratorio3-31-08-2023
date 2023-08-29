package com.group5.laboratorio3.utils

import android.annotation.SuppressLint
import android.content.Context

abstract class Utils {

    companion object {

        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        @SuppressLint("DiscouragedApi")
        fun getDrawableIdByFileName(fileName: String): Int {
            return context.resources.getIdentifier(fileName, "drawable", context.packageName)
        }

        fun setContext(context: Context) {
            this.context = context
        }
    }
}