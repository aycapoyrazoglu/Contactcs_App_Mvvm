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
        Log.e("Person Add : ", "$person_name - $person_num")
    }

    fun updatePerson(person_id:Int,person_name:String,person_num:String)
    {
        Log.e("Person Update:" , "$person_id - $person_name - $person_num")
    }

    fun searchPerson(searchWord:String)
    {
        Log.e("Kişi Ara",searchWord)
    }

    fun deletePerson(person_id:Int)
    {
        Log.e("Kişi Sil",person_id.toString())
    }

    fun allPersonShow()
    {
        val job = CoroutineScope(Dispatchers.Main).launch {
            personsList.value = pdao.allPeople()
        }
    }
}