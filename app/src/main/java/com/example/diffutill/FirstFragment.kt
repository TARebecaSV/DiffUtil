package com.example.diffutill

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutill.databinding.FragmentFirstBinding
import com.example.diffutill.model.Person
import com.example.diffutill.model.Row

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MyAdapter(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.rvFirstFragment.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFirstFragment.adapter = myAdapter

        val person1 = Person(1, "John", 21)
        val person2 = Person(2, "Mike", 24)
        val person3 = Person(3, "Dany", 22)

        myAdapter.setData(DataServices.rows)

//        binding.btnAdd.setOnClickListener(){
//           // val person4 = Person(1, "Mara", 23)
//            val newRow = Row(5," Image 5", "i5")
//            val otherList = DataServices.rows.toMutableList()
//            otherList.add(newRow)
//            myAdapter.setData(otherList)
//        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}