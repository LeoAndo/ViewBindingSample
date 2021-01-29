package com.template.viewbindingsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.template.viewbindingsample.databinding.MainActivityBinding
import com.template.viewbindingsample.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    // Activityの場合は、画面破棄時に bindingをnull初期化しなくてOK.
    private val binding by viewBinding(MainActivityBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
