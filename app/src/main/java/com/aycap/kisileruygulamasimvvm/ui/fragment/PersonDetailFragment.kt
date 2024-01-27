package com.aycap.kisileruygulamasimvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.aycap.kisileruygulamasimvvm.R
import com.aycap.kisileruygulamasimvvm.databinding.FragmentPersonDetailBinding
import com.aycap.kisileruygulamasimvvm.ui.viewmodel.AddPersonViewModel
import com.aycap.kisileruygulamasimvvm.ui.viewmodel.PersonDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment : Fragment() {

    private lateinit var binding:FragmentPersonDetailBinding
    private lateinit var viewModel: PersonDetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_detail,container,false)
        binding.personDetailFragment = this
        binding.personDetailToolbarTitle = "Person Detail"
        val bundle:PersonDetailFragmentArgs by navArgs()
        val person = bundle.person

        binding.personObj = person



        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun updateButton(person_id:Int,person_name:String,person_num:String)
    {
        viewModel.update(person_id,person_name,person_num)
    }

}