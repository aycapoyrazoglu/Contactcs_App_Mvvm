package com.aycap.kisileruygulamasimvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aycap.kisileruygulamasimvvm.data.entity.Persons

class PersonsDaoRepository {

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
        val list = ArrayList<Persons>()
        val k1 = Persons(1,"Ayca","11111")
        val k2 = Persons(2,"Aycax","22222")
        val k3 = Persons(3,"Sahin","33333")
        val k4 = Persons(4,"Zeytin","44444")
        list.add(k1)
        list.add(k2)
        list.add(k3)
        list.add(k4)

        personsList.value = list
    }
}