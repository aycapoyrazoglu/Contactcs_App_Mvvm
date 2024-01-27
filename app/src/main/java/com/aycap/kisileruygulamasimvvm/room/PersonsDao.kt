package com.aycap.kisileruygulamasimvvm.room

import androidx.room.Dao
import androidx.room.Query
import com.aycap.kisileruygulamasimvvm.data.entity.Persons

@Dao
interface PersonsDao {
    @Query("SELECT * FROM persons")
    suspend fun allPeople() : List<Persons>

}