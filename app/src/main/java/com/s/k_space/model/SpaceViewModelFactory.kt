package com.s.k_space.model



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.s.k_space.spacedb.SpaceRepository

class SpaceViewModelFactory( private val spaceRepository: SpaceRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SpaceViewModel::class.java)){
            return SpaceViewModel(spaceRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}