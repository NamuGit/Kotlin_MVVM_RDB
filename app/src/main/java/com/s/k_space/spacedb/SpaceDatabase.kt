package com.s.k_space.spacedb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.s.k_space.model.SpaceModel

@Database(entities = [SpaceModel::class], version = 1)
abstract class SpaceDatabase : RoomDatabase() {

    abstract val SpaceDAO : SpaceDAO

    //singleton

    companion object {
        @Volatile
        private var Db_Instance : SpaceDatabase? = null
        fun getDBInstance(context: Context) :
            SpaceDatabase{
                synchronized(this){
                    var instance = Db_Instance
                    if(instance == null){
                        instance = Room.databaseBuilder(context.applicationContext,
                            SpaceDatabase::class.java,"Space_DB"
                        ).build()
                    }
                    return instance
                }

        }

    }


}