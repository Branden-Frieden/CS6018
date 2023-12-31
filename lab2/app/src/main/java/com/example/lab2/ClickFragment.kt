package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lab2.databinding.FragmentClickBinding


class ClickFragment : Fragment() {


    private var buttonFunction : () -> Unit = {}

    fun setButtonFunction(newFunc: () -> Unit){
        buttonFunction = newFunc
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentClickBinding.inflate(inflater, container, false)
        val viewModel : DrawViewModel by activityViewModels()

        binding.beginButton.setOnClickListener {
            viewModel.makeBitMap(requireContext().display!!.width, requireContext().display!!.height)
            buttonFunction()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}