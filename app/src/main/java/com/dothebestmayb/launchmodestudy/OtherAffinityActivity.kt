package com.dothebestmayb.launchmodestudy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dothebestmayb.launchmodestudy.databinding.ActivityOtherAffinityBinding

class OtherAffinityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtherAffinityBinding
    private val TAG = OtherAffinityActivity::class.java.simpleName
    private val order = count++
    private lateinit var taskAffinity: String
    override fun onCreate(savedInstanceState: Bundle?) {
        taskAffinity = getTaskAffinity(this) ?: ""
        Log.i(TAG, "[task#${taskId}][affinity#$taskAffinity]onCreate - $order")
        super.onCreate(savedInstanceState)
        binding = ActivityOtherAffinityBinding.inflate(layoutInflater)
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
            btnOtherAffinity to OtherAffinityActivity::class.java,
            btnSingleInstance to SingleInstanceActivity::class.java,
            btnLauncher to NewLauncherActivity::class.java,
        ).forEach { (btn, cls) ->
            btn.setOnClickListener {
                val intent = Intent(this@OtherAffinityActivity, cls)
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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        Log.i(TAG, "[task#$taskId][affinity#${taskAffinity}]onNewIntent - $order")
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

    companion object {
        private var count = 0
    }
}