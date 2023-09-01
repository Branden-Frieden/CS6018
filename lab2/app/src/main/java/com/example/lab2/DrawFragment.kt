package com.example.lab2

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.lab2.databinding.FragmentClickBinding
import com.example.lab2.databinding.FragmentDrawBinding

class DrawFragment : Fragment() {

    companion object {
        fun newInstance() = DrawFragment()
    }

    private lateinit var viewModel: DrawViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDrawBinding.inflate(inflater)

        val viewModel : DrawViewModel by activityViewModels()

        viewModel.map.observe(viewLifecycleOwner){
            binding.myView.setMap(it)
        }
        return binding.root
    }

}