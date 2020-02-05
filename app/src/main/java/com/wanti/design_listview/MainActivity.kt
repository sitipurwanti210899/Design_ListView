package com.wanti.design_listview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var foodAdapter: AdapterFood
    private var foodModel = arrayListOf<ModelFood>()
    private lateinit var name: Array<String>
    private lateinit var desc: Array<String>
    private lateinit var img : TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foodAdapter = AdapterFood(this)
        lv_main.adapter = foodAdapter
        attachData()
        loadData()
    }

    private fun loadData() {
        for (position in name.indices){
            val food = ModelFood(
                name[position],
                desc[position],
                img.getResourceId(position, -1)
            )
            foodModel.add(food)
        }
        foodAdapter.foodData = foodModel
    }

    private fun attachData() {
        name = resources.getStringArray(R.array.name)
        desc = resources.getStringArray(R.array.desc)
        img = resources.obtainTypedArray(R.array.img)
    }
}
