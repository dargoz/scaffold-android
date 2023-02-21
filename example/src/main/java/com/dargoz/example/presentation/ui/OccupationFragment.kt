package com.dargoz.example.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dargoz.core.binding.BaseFragment
import com.dargoz.example.databinding.FragmentOccupationBinding
import com.dargoz.example.presentation.viewmodels.TestViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OccupationFragment : BaseFragment<FragmentOccupationBinding>() {

    private val testViewModel: TestViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOccupationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.submitButton.setOnClickListener {
            testViewModel.getData()
        }
    }

}