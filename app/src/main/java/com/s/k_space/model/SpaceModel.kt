package com.s.k_space.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.s.k_space.R

@Entity(tableName = "space_data_table")
data class SpaceModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "Sid")
    var Sid: Int,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="country")
    var country: String
)