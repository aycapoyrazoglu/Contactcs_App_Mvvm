package com.aycap.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aycap.kisileruygulamasimvvm.data.entity.Persons
import com.aycap.kisileruygulamasimvvm.room.PersonsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonsDaoRepository(var pdao:PersonsDao) {

    var personsList : MutableLiveData<List<Persons>>
    init {
        personsList = MutableLiveData()
    }

    fun allPersonTake() : MutableLiveData<List<Persons>>
    {
        return personsList
    }

    fun addPerson(person_name:String,person_num:String)
    {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newPerson = Persons(0,person_name,person_num)
            pdao.addPerson(newPerson)
        }
    }

    fun updatePerson(person_id:Int,person_name:String,person_num:String)
    {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedPerson = Persons(person_id,person_name,person_num)
            pdao.updatePerson(updatedPerson)
        }
    }

    fun searchPerson(searchWord:String)
    {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = pdao.searchPeople(searchWord)
        }

    }

    fun deletePerson(person_id:Int)
    {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedPerson = Persons(person_id,"","")
            pdao.deletePerson(deletedPerson)
            allPersonShow()
        }
    }

    fun allPersonShow()
    {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = pdao.allPeople()
        }
    }
}