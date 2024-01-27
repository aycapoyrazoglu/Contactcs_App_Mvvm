package com.aycap.kisileruygulamasimvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.aycap.kisileruygulamasimvvm.data.repo.PersonsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class PersonDetailViewModel @Inject constructor(var pRepo : PersonsDaoRepository) : ViewModel() {


    fun update(person_id:Int,person_name:String,person_num:String)
    {
        pRepo.updatePerson(person_id,person_name,person_num)
    }
}