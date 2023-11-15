package com.example.tugaspertemuan11

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tugaspertemuan11.model.ItemModel

class ItemAdapter(private val context: Context, private val itemList: List<ItemModel>) : BaseAdapter() {

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            holder = ViewHolder()
            holder.nameTextView = view.findViewById(R.id.nameTextView)
            holder.categoryTextView = view.findViewById(R.id.categoryTextView)
            holder.priceTextView = view.findViewById(R.id.priceTextView)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val item = getItem(position) as ItemModel
        holder.nameTextView.text = item.title
        holder.categoryTextView.text = item.category
        holder.priceTextView.text = item.price

        return view!!
    }

    private class ViewHolder {
        lateinit var nameTextView: TextView
        lateinit var categoryTextView: TextView
        lateinit var priceTextView: TextView
    }
}
