package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.databinding.ItemMainAdapterBinding
import java.util.*

class MainActivity : AppCompatActivity() {
//    lateinit var parentLayout: LinearLayout

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

    class TestViewHolder(binding: ItemMainAdapterBinding) : RecyclerView.ViewHolder(binding.root){
        val textView: TextView
        val button: Button

        init{
            //textView = view.findViewById(R.id.adapterItemTextView)
            //button = view.findViewById(R.id.adapterItemButton)
            textView = binding.adapterItemTextView
            button = binding.adapterItemButton

            binding.adapterItemButton.setOnClickListener {
                Toast.makeText(binding.root.context, binding.adapterItemTextView.text.toString()
                    .uppercase(Locale.ROOT), Toast.LENGTH_SHORT).show()
            }
        }
    }

    class MainActivityAdapter(var data: List<RecyclerItemData>) : RecyclerView.Adapter<TestViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
            //val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_main_adapter, parent, false)
            val binding = ItemMainAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return TestViewHolder(binding)
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