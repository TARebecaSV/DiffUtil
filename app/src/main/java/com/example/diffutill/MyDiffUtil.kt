package com.example.diffutill

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutill.model.Person
import com.example.diffutill.model.Row

class MyDiffUtil(private val oldList: List<Row>, private val newList: List<Row>): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> {
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name -> {
                false
            }
            oldList[oldItemPosition].image != newList[newItemPosition].image -> {
                false
            }
            else -> true
        }
    }

}