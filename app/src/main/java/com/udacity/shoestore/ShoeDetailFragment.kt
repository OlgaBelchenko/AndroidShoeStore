package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        binding.apply {

            cancelButton.setOnClickListener { navigateBack() }

            saveButton.setOnClickListener { addShoeToList() }
        }

        return binding.root
    }

    private fun addShoeToList() {
        if (isInputCorrect()) {
            binding.apply {
                viewModel.addShoeToList(
                    shoeNameInput.text.toString(),
                    companyInput.text.toString(),
                    shoeSizeInput.text.toString().toDouble(),
                    descriptionInput.text.toString()
                )
                navigateBack()
            }
        } else {
            Toast.makeText(
                context,
                getString(R.string.fill_all_fields),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun isInputCorrect(): Boolean {
        return !(with(binding) {
            shoeNameInput.text.isBlank() ||
                    companyInput.text.isBlank() ||
                    shoeSizeInput.text.isBlank() ||
                    descriptionInput.text.isBlank()
        })
    }

    private fun navigateBack() {
        findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
    }
}