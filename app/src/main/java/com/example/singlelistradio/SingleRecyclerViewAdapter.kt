package com.example.singlelistradio

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import com.example.singlelistradio.SingleRecyclerViewAdapter.DataObjectHolder
import kotlinx.android.synthetic.main.list_item.view.*

class SingleRecyclerViewAdapter(private val mData: Array<String>) : RecyclerView.Adapter<DataObjectHolder>() {

    fun selectedItem() {
        notifyDataSetChanged()
    }

    internal fun setOnItemClickListener(clickListener: SingleClickListener) {
        sClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return DataObjectHolder(view)
    }

    override fun onBindViewHolder(holder: DataObjectHolder, position: Int) {
        holder.memberName.text = mData[position]
        holder.mRadioButton.isChecked = sSelected == position
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    internal interface SingleClickListener {
        fun onItemClickListener(position: Int, view: View)
    }

    class DataObjectHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mRadioButton: RadioButton = itemView.check_btn
        val memberName: TextView = itemView.textView2

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            sSelected = adapterPosition
            sClickListener!!.onItemClickListener(adapterPosition, view)
        }
    }

    companion object {
        private var sClickListener: SingleClickListener? = null
        private var sSelected = -1
    }

}