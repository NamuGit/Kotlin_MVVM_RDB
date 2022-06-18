package com.s.k_space.spacedb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.s.k_space.model.SpaceModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SpaceDAO {

    @Insert
     fun insertSpaceData(spaceModel: SpaceModel) :Long


    @Query("DELETE FROM space_data_table")
      fun deleteRecord() :Int

    @Query("SELECT * FROM space_data_table")
     fun getAllRecord(): Flow<List<SpaceModel>>
}