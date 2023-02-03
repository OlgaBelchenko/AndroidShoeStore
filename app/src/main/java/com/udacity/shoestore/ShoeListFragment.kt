package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.shoe_list_item.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShoeListBinding.inflate(inflater, container, false)

        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {
                addShoeToList(shoe.name, shoe.size, shoe.company, shoe.description)
            }
        })

        return binding.root
    }

    private fun addShoeToList(name: String, size: Double, company: String, description: String) {
        val shoeItem = View.inflate(requireContext(), R.layout.shoe_list_item, null)
        shoeItem.shoe_list_item.text =
            getString(R.string.shoe_item_text, name, company, size, description)
        binding.shoeList.addView(shoeItem)
    }
}