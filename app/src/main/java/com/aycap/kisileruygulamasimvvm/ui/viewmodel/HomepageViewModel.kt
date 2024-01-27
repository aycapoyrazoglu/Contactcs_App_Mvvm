package com.aycap.kisileruygulamasimvvm.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aycap.kisileruygulamasimvvm.data.entity.Persons
import com.aycap.kisileruygulamasimvvm.data.repo.PersonsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var pRepo : PersonsDaoRepository) : ViewModel() {


    var personsList = MutableLiveData<List<Persons>>()
    init {
        allPerson()
        personsList = pRepo.allPersonTake()
    }

    fun search(searchWord:String)
    {
        pRepo.searchPerson(searchWord)
    }

    fun delete(person_id:Int)
    {
        pRepo.deletePerson(person_id)
    }

    fun allPerson()
    {
        pRepo.allPersonShow()
    }
}