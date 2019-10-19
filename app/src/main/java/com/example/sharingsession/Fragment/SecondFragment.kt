package com.example.sharingsession.Fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.example.sharingsession.R
import kotlinx.android.synthetic.main.fragment_second.*
import java.io.Console

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    val safeArgs: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("this safeArgs: ", safeArgs.name)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_args.text = safeArgs.name

    }

}
