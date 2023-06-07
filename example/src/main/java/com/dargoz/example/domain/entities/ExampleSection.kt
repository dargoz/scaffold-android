package com.dargoz.example.domain.entities

import android.util.Log
import com.dargoz.core.mediator.Section

class ExampleSection : Section {

    override fun getTitle(): String = "Example"


    override fun onAction() {
        Log.d("DRG","onAction")
    }

    override fun getSectionName(): String {
        return "example"
    }
}