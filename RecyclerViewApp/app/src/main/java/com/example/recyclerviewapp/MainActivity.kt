package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var parentLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        parentLayout = findViewById(R.id.mainActivityList)

        val recyclerData = mutableListOf<RecyclerItemData>()
        for (i in 1 .. 1000){
//            parentLayout.addView(
//                LinearLayout(this).apply {
//                    orientation = HORIZONTAL
//                    addView(TextView(this@MainActivity).apply { text = "Text View $i" })
//                    addView(Button(this@MainActivity).apply { text = "Button" })
//                }
//            )
            recyclerData.add(RecyclerItemData("text $i", "button $i"))
        }

        val adapter = MainActivityAdapter(recyclerData)
        val recycler = findViewById<RecyclerView>(R.id.mainActivityList)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }

    class TestViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView
        val button: Button

        init{
            textView = view.findViewById(R.id.adapterItemTextView)
            button = view.findViewById(R.id.adapterItemButton)
        }
    }

    class MainActivityAdapter(var data: List<RecyclerItemData>) : RecyclerView.Adapter<TestViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_main_adapter, parent, false)
            return TestViewHolder(view)
        }

        override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
            val currentItemData = data[position]
            holder.button.text = currentItemData.buttonText
            holder.textView.text = currentItemData.text
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }
}