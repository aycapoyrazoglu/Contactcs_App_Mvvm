package com.aycap.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.aycap.kisileruygulamasimvvm.R
import com.aycap.kisileruygulamasimvvm.databinding.FragmentAddPersonBinding
import com.aycap.kisileruygulamasimvvm.ui.viewmodel.AddPersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPersonFragment : Fragment() {

    private lateinit var binding:FragmentAddPersonBinding
    private lateinit var viewModel:AddPersonViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_person,container,false)
        binding.addPersonFragment = this
        binding.addPersonToolbarTitle = "Add Person"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddPersonViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun addButton(person_name:String,person_num:String)
    {
        viewModel.add(person_name,person_num)
    }

}