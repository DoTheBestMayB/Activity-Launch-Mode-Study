package com.dothebestmayb.launchmodestudy

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build


fun getTaskAffinity(activity: Activity): String? {
    val am = activity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val appTaskList = am.appTasks
    var taskId: Int
    for (appTask in appTaskList) {
        val taskInfo = appTask.taskInfo

        // Get the id of the task
        taskId = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            taskInfo.id
        } else {
            taskInfo.taskId
        }

        // Detect the task that the activity is belonged to
        if (activity.taskId == taskId) {
            val rootActivity = taskInfo.baseActivity
            return try {
                val pm = activity.packageManager
                val ai = pm.getActivityInfo(rootActivity!!, PackageManager.GET_META_DATA)
                ai.taskAffinity
            } catch (e: PackageManager.NameNotFoundException) {
                null
            }
        }
    }
    return null
}