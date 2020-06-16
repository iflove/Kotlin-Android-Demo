package com.example.lazy.kotlin.module.utils

import android.app.Application
import android.util.Log
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.lazy.kotlin.helper.R

/**
 * Created by Lazy on 2016/12/13.
 *
 *
 * Describe:
 */

object ResUtil {
    private val TAG = "ResUtil"

    private lateinit var mApplication: Application

    fun inject(application: Application) {
        mApplication = application
    }

    fun getViewId(packageName: String, idName: String): Int {
        var id = 0
        try {
            val cls = Class.forName("$packageName.R\$id")
            id = cls.getField(idName).getInt(cls)
        } catch (e: NoSuchFieldException) {
            Log.e(TAG, "NoSuchFieldException: " + e.message)
        } catch (e: Exception) {
        }

        return id
    }

    fun getViewId(idName: String): Int {
        var id = 0
        try {
            val cls = R.id::class.java
            id = cls.getField(idName).getInt(cls)
        } catch (e: NoSuchFieldException) {
            Log.e(TAG, "NoSuchFieldException: " + e.message)
        } catch (e: Exception) {
        }
        return id

    }

    fun getDrawableId(packageName: String, idName: String): Int {
        var id = 0
        try {
            val cls = Class.forName("$packageName.R\$drawable")
            id = cls.getField(idName).getInt(cls)
        } catch (e: NoSuchFieldException) {
            Log.e(TAG, "NoSuchFieldException: " + e.message)
        } catch (e: Exception) {
        }

        return id
    }

    fun getDrawableId(idName: String): Int {
        var id = 0
        try {
            val cls = R.drawable::class.java
            id = cls.getField(idName).getInt(cls)
        } catch (e: NoSuchFieldException) {
            Log.e(TAG, "NoSuchFieldException: " + e.message)
        } catch (e: Exception) {
        }

        return id
    }

    fun getStringId(packageName: String, idName: String): Int {
        var id = 0
        try {
            val cls = Class.forName("$packageName.R\$string")
            id = cls.getField(idName).getInt(cls)
        } catch (e: NoSuchFieldException) {
            Log.e(TAG, "NoSuchFieldException: " + e.message)
        } catch (e: Exception) {
        }

        return id
    }

    fun getStringId(idName: String): Int {
        var id = 0
        try {
            val cls = R.string::class.java
            id = cls.getField(idName).getInt(cls)
        } catch (e: NoSuchFieldException) {
            Log.e(TAG, "NoSuchFieldException: " + e.message)
        } catch (e: Exception) {
        }

        return id
    }

    fun getXmlId(packageName: String, idName: String): Int {
        var id = 0
        try {
            val cls = Class.forName("$packageName.R\$xml")
            id = cls.getField(idName).getInt(cls)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return id
    }

//    fun getXmlId(idName: String): Int {
//        var id = 0
//        try {
//            val cls = R.xml::class.java
//            id = cls.getField(idName).getInt(cls)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//        return id
//    }

    /**
     * @param id
     * *
     * @return
     */
    fun getArrayRes(@ArrayRes id: Int): IntArray {
        return mApplication.resources.getIntArray(id)
    }

    /**
     * @param id
     * *
     * @return
     */
    fun getStringArray(@ArrayRes id: Int): Array<String> {
        return mApplication.resources.getStringArray(id)
    }

    fun getResourcesIdArray(@ArrayRes id: Int): IntArray {
        val typedArray = mApplication.resources.obtainTypedArray(id)
        val length = typedArray.length()
        val resArray = IntArray(length)
        for (i in 0..length - 1) {
            val resourceId = typedArray.getResourceId(i, 0)
            resArray[i] = resourceId
        }
        typedArray.recycle()
        return resArray
    }

    fun getListString(@ArrayRes id: Int): List<String> {
        val list = listOf<String>(*mApplication.resources.getStringArray(id))
        return list
    }

    fun getMutableListString(@ArrayRes id: Int): List<String> {
        val list = mutableListOf<String>(*mApplication.resources.getStringArray(id))
        return list
    }

    fun getString(@StringRes id: Int): String {
        return mApplication.resources.getString(id)
    }

    fun getColor(@ColorRes id: Int): Int {
        return mApplication.resources.getColor(id)
    }

}
