package com.coderefer.weatherrefer.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.coderefer.weatherrefer.R

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_city).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_search).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_help).setOnClickListener(this)
        view.findViewById<Button>(R.id.btn_prefs).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        lateinit var action: NavDirections
        when (v!!.id) {
            R.id.btn_city -> {
                action = HomeFragmentDirections.actionHomeFragmentToCityFragment()
            }
            R.id.btn_help -> {
                action = HomeFragmentDirections.actionHomeFragmentToHelpFragment()
            }
            R.id.btn_search -> {
                action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
            }
            R.id.btn_prefs -> {
                action = HomeFragmentDirections.actionHomeFragmentToPrefsFragment()
            }
        }
        v.findNavController().navigate(action)

    }
}