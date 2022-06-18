package com.s.k_space.model

import androidx.databinding.Observable
import androidx.lifecycle.*
import com.s.k_space.Event
import com.s.k_space.spacedb.SpaceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SpaceViewModel(private val spaceRepository: SpaceRepository): ViewModel() {

    val Spacedetails = spaceRepository.Spacedetails
    val SpaceName = MutableLiveData<String>()
    val SpaceCountry = MutableLiveData<String>()
    val save_btn = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    init {
        save_btn.value ="Save"
    }


    fun getData() = liveData {
        spaceRepository.Spacedetails.collect {
            emit(it)
        }
    }

    fun saveData(){

        if (SpaceName.value == null) {
            statusMessage.value = Event("Please enter  name")
        }else if (SpaceCountry.value == null) {
            statusMessage.value = Event("Please enter company")
        }else{
            val name= SpaceName.value!!
            val country = SpaceCountry.value!!
            insertDetails(SpaceModel(0,name,country))
            SpaceName.value=""
            SpaceCountry.value=""
        }
    }

    //CoroutineScope(Dispatchers.IO).launch
     fun insertDetails(spaceModel: SpaceModel)=  CoroutineScope(Dispatchers.IO).launch{

//             spaceRepository.insertvalue(spaceModel)

             val Rid= spaceRepository.insertvalue(spaceModel)
//             if(Rid > -1){
//                 statusMessage.value = Event("Inserted Successfully $Rid")
//             }else {
//                 statusMessage.value = Event("Error!! ")
//             }



    }




}