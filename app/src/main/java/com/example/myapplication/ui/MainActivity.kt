package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.data.ResultWrapper
import com.example.myapplication.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: DemoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getDemo.postValue(Unit)


         viewModel.run {
            getDemoOutPut.observe(this@MainActivity, Observer { resultWrapper ->

                if (resultWrapper is ResultWrapper.Success) {
                    resultWrapper.value?.let {
                        Log.e("value ", it.toString())
                    }
                }

                if (resultWrapper is ResultWrapper.GenericError) {
                    Log.e("value ", "True ßßßßßßßßßßßßß")
                }

            })
        }

    }
}