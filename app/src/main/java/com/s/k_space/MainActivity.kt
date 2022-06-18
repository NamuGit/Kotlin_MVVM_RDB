package com.s.k_space

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.s.k_space.databinding.ActivityMainBinding
import com.s.k_space.model.SpaceViewModel
import com.s.k_space.model.SpaceViewModelFactory
import com.s.k_space.spacedb.SpaceDatabase
import com.s.k_space.spacedb.SpaceRepository


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var spaceViewModel: SpaceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao = SpaceDatabase.getDBInstance(application).SpaceDAO
        val spaceRepository = SpaceRepository(dao)
        val factory = SpaceViewModelFactory(spaceRepository)
        spaceViewModel = ViewModelProvider(this,factory).get(SpaceViewModel::class.java)
        binding.mydata = spaceViewModel
        binding.lifecycleOwner = this

        updateRecyclerView()

        spaceViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun updateRecyclerView() {
        binding.firstRecyclerView.layoutManager = LinearLayoutManager(this)
        display()
    }

    private fun display(){

        spaceViewModel.getData().observe(this, Observer{
            Log.i("MyDATA",it.toString())
            binding.firstRecyclerView.adapter = RVAdapter(it)
        })
    }
}


