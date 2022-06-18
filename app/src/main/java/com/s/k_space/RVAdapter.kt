package com.s.k_space

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.s.k_space.databinding.ActivityMainBinding
import com.s.k_space.databinding.FirstviewBinding
import com.s.k_space.model.SpaceModel
import com.s.k_space.model.SpaceViewModel
import java.util.concurrent.Flow

class RVAdapter(private val spaceList: List<SpaceModel>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding : FirstviewBinding = DataBindingUtil.inflate(inflater, R.layout.firstview, parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(spaceList[position])
    }

    override fun getItemCount(): Int {
        return spaceList.size
    }


}

class MyViewHolder(val binding: FirstviewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(spaceModel: SpaceModel){
        binding.nameTextView.text = spaceModel.name
        binding.countryTextView.text =spaceModel.country
    }

}