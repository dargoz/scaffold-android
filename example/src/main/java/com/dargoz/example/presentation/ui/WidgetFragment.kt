package com.dargoz.example.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dargoz.core.binding.BaseFragment
import com.dargoz.example.databinding.FragmentWidgetBinding
import com.dargoz.example.presentation.viewmodels.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WidgetFragment : BaseFragment<FragmentWidgetBinding>() {

    private val testViewModel: TestViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWidgetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            testViewModel.state.collectLatest {
                val data = it.getOrDefault(listOf("sample 1")).toString()
                Log.d("DRG", "set Text to View ${this@WidgetFragment} :: $data")
                binding.widgetText.text = data
            }
        }
        testViewModel.getData()
    }


}