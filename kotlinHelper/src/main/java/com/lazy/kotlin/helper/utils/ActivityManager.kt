package com.lazy.kotlin.helper.utils

import android.app.Activity
import java.util.*

object ActivityManager {

    private val activityStack = Stack<Activity>()

    /**
     * 获取指定的Activity
     */
    fun getActivity(cls: Class<*>): Activity? {
        return activityStack.firstOrNull { it.javaClass == cls }
    }

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    fun currentActivity(): Activity? {
        if (activityStack.isEmpty()) {
            return null
        }
        return activityStack.lastElement()
    }

    /**
     * 获取当前Activity（堆栈中第一个压入的）
     */
    fun topActivity(): Activity? {
        if (activityStack.isEmpty()) {
            return null
        }
        return activityStack.firstElement()
    }

    fun activityStackIsEmpty(): Boolean {
        return activityStack.isEmpty()
    }

    fun activityStackIsNotEmpty(): Boolean {
        return activityStack.isNotEmpty()
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        val activity = activityStack.lastElement()
        finishAndRemoveActivity(activity)
    }

    /**
     * 结束指定的Activity
     */
    fun finishAndRemoveActivity(activity: Activity?) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity)
            activity.finish()
        }
    }

    fun finishActivity(activity: Activity?) {
        if (activity != null && activityStack.contains(activity)) {
            activity.finish()
        }
    }

    /**
     * 结束指定的Activity
     */
    fun removeActivity(activity: Activity) {
        if (activityStack.contains(activity)) {
            activityStack.remove(activity)
        }
    }

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                finishAndRemoveActivity(activity)
                break
            }
        }
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        val size = activityStack.size
        //FIFO
        (size - 1 downTo 0)
                .filter { null != activityStack[it] }
                .forEach { finishActivity(activityStack[it]) }
        activityStack.clear()
    }

    /**
     * 退出应用程序
     */
    fun AppExit() {
        try {
            finishAllActivity()
            // 杀死该应用进程
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(0)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
