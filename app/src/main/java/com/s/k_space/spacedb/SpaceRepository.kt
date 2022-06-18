package com.s.k_space.spacedb

import com.s.k_space.model.SpaceModel

class SpaceRepository(private val dao: SpaceDAO) {

    val Spacedetails = dao.getAllRecord()

    suspend fun insertvalue(spaceModel: SpaceModel):Long{
        return dao.insertSpaceData(spaceModel)
    }

    suspend fun delete(spaceModel: SpaceModel): Int {
        return dao.deleteRecord()
    }


}