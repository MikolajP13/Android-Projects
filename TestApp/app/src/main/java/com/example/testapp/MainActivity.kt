package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.network.Response
import com.example.testapp.network.ResponseHandler


class MainActivity : AppCompatActivity() {
    var pole1: String = "Abc"
    var pole2: String = "xyz"
    private lateinit var binding: ActivityMainBinding

    companion object{
        private val TAG = "MainActivityTag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        pole1 = "Abc-create"
        savedInstanceState?.let {
            pole1 = it.getString(pole2)?: "Empty"
        }

        Log.d(TAG, "onCreate() $pole1")

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val responseHandler = ResponseHandler()
        val response = responseHandler.parseResponse(200, "example data")
        response.handlerResponse()

        binding.callBtn.setOnClickListener {
            Toast.makeText(applicationContext, binding.phoneNumber.text, Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart(){
        Log.d(TAG, "onStart() $pole1")
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() $pole1")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() $pole1")

    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop() $pole1")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, "onStop() $pole1")
        pole1 = "saved!"
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() $pole1")
    }

    //extension function
    private fun Response.handlerResponse(){
        when(this){
            is Response.Success -> {
                Log.d("android", "${this.javaClass.simpleName}")}
            is Response.Failure -> {
                Log.d("android", errorMessage)
            }
            is Response.Progress -> {
                Log.d("android", "progress")
            }
        }
    }
}