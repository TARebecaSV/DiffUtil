package com.example.diffutill

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutill.databinding.ItemLayoutBinding
import com.example.diffutill.databinding.ItemRowBinding
import com.example.diffutill.model.Row


class MyAdapter(val context: Context): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var oldPersonList = emptyList<Row>()
    private val rows: List<Row> = listOf()

    //class MyViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) // TODO o clasa care nu face nimic? : este return sau implmenteaza?

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.binding.nameTextView.text = oldPersonList[position].name
//        holder.binding.ageTextView.text = oldPersonList[position].age.toString()

        holder.bindRow(rows[position], context)
    }

    override fun getItemCount(): Int {
        return oldPersonList.size
    }

    fun setData(newPersonList: List<Row>){
        val diffUtil = MyDiffUtil(oldPersonList, newPersonList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldPersonList = newPersonList
        diffResult.dispatchUpdatesTo(this)
    }

//    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val rowImage = itemView.findViewById<ImageView>(R.id.image)
//        val rowName = itemView.findViewById<TextView>(R.id.textView)
//
//        fun bindRow(row: Row, context: Context){
//            val resourceId = context.resources.getIdentifier(row.image, "drawable", context.packageName)
//            rowName.text = row.name
//        }
//    }

    inner class MyViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
//        val rowImage = itemView.findViewById<ImageView>(R.id.image)
//        val rowName = itemView.findViewById<TextView>(R.id.textView)

        fun bindRow(row: Row, context: Context){
            val resourceId = context.resources.getIdentifier(row.image, "drawable", context.packageName)
            binding.imageR.setImageResource(resourceId)
            binding.textView.text = row.name
        }
    }

}