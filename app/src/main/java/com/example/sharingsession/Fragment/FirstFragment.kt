package com.example.sharingsession.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.example.sharingsession.R
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnToSecond.setOnClickListener { view ->
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name = et_name.text.toString())
            view.findNavController().navigate(action)
        }
    }

}
