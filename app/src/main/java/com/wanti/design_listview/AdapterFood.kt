package com.wanti.design_listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class AdapterFood internal constructor(private val context: Context): BaseAdapter(){
    internal var foodData = arrayListOf<ModelFood>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        }
        val viewHolder = ViewHolder(view as View)
        val food = getItem(position) as ModelFood
        viewHolder.bindFood(food)

        return view
    }

    override fun getItem(position: Int): Any {
        return foodData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = foodData.size

    private inner class ViewHolder internal constructor(view: View){
        private val tvName: TextView = view.findViewById(R.id.tv_name)
        private val tvDesc: TextView = view.findViewById(R.id.tv_desc)
        private val images: ImageView = view.findViewById(R.id.iv_main)

        internal fun bindFood (food: ModelFood){
            tvName.setText(food.name)
            tvDesc.setText(food.desc)

            Glide.with(context)
                .load(food.img)
                .override(200)
                .into(images)
        }
    }
}