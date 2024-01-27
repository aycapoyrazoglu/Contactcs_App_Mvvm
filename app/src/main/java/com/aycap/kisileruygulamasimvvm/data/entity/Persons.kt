package com.aycap.kisileruygulamasimvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable
@Entity(tableName = "persons")
data class Persons(@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name="person_id") @NotNull var person_id:Int,
                   @ColumnInfo(name="person_name") @NotNull var person_name:String,
                   @ColumnInfo(name = "person_num") @NotNull var person_num:String) : Serializable {

}