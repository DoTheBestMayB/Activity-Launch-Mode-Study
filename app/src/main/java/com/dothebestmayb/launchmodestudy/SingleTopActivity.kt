package com.dothebestmayb.launchmodestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dothebestmayb.launchmodestudy.databinding.ActivitySingleTopBinding

class SingleTopActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleTopBinding
    private val TAG = SingleTopActivity::class.java.simpleName
    private val order = count++
    private lateinit var taskAffinity: String

    override fun onCreate(savedInstanceState: Bundle?) {
        taskAffinity = getTaskAffinity(this) ?: ""
        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onCreate - $order")
        super.onCreate(savedInstanceState)
        binding = ActivitySingleTopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }

    private fun setListener() = with(binding) {
        listOf(
            btnMain to MainActivity::class.java,
            btnStandard to StandardActivity::class.java,
            btnSingleTop to SingleTopActivity::class.java,
            btnSingleTask to SingleTaskActivity::class.java,
            btnSingleTaskWithOtherAffinity to SingleTaskWithOtherAffinityActivity::class.java,
            btnSingleInstance to SingleInstanceActivity::class.java,
            btnLauncher to NewLauncherActivity::class.java,
        ).forEach { (btn, cls) ->
            btn.setOnClickListener {
                val intent = Intent(this@SingleTopActivity, cls)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onStart - $order")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onRestart - $order")
    }

    override fun onResume() {
        super.onResume()

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onResume - $order")
    }

    override fun onPause() {
        super.onPause()

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onPause - $order")
    }

    override fun onStop() {
        super.onStop()

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onStop - $order")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onDestroy - $order")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onNewIntent - $order")
    }

    companion object {
        private var count = 0
    }
}