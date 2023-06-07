package com.dargoz.dashboard.presentation.views

import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dargoz.core.binding.BaseFragment
import com.dargoz.dashboard.databinding.DashboardWidgetLayoutBinding
import com.dargoz.dashboard.databinding.FragmentDashboardBinding

import com.dargoz.dashboard.presentation.viewmodels.DashboardViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val dashboardViewModel : DashboardViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            dashboardViewModel.state.collectLatest {

                val data = it.getOrDefault(emptyList())
                data.forEachIndexed { index, section ->
                    val dashboardWidgetBinding = DashboardWidgetLayoutBinding.inflate(layoutInflater, binding.dashboardContainer, false)
                    dashboardWidgetBinding.widgetTitle.text = "${section.getTitle()} : $index"
                    val containerId = View.generateViewId()
                    Log.d("DRG", "fragment : ${section.fragment}")
                    dashboardWidgetBinding.widgetContent.id = containerId
                    childFragmentManager.beginTransaction()
                    .add(containerId, section.fragment)
                    .commit()
                    binding.dashboardContainer.addView(dashboardWidgetBinding.root)
                }


            }
        }
        dashboardViewModel.getWidgetList()
    }


}