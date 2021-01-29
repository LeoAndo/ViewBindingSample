package com.template.viewbindingsample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.template.viewbindingsample.R
import com.template.viewbindingsample.databinding.MainFragmentBinding
import com.template.viewbindingsample.viewBindings

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val binding by viewBindings(MainFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w("---", "onViewCreated")
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.message.text = "Hello ViewBinding!!!"
    }

    // View Bindingを使用する場合、
    // onDestroyViewのタイミングで保持しているBindingの参照を解放しないと
    // メモリリークする
    // https://satoshun.github.io/2020/01/fragment-view-memory-leak/
    override fun onDestroyView() {
        Log.w("---", "onDestroyView")
        super.onDestroyView()
    }
}
