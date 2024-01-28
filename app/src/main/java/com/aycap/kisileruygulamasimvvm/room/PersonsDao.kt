package com.aycap.kisileruygulamasimvvm.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.aycap.kisileruygulamasimvvm.data.entity.Persons

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons")
    suspend fun allPeople() : List<Persons>

    @Query("SELECT * FROM persons WHERE person_name like '%' || :searchWord || '%'")
    suspend fun searchPeople(searchWord:String) : List<Persons>

    @Insert
    suspend fun addPerson(persons: Persons)

    @Update
    suspend fun updatePerson(persons: Persons)

    @Delete
    suspend fun deletePerson(persons: Persons)
}