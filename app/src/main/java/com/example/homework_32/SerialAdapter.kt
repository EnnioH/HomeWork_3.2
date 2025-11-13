package com.example.homework_32

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_32.databinding.ItemSerialBinding

class SerialAdapter(
    private val serialList: ArrayList<SerialModel>
) : RecyclerView.Adapter<SerialAdapter.SerialViewHolder>() {

    class SerialViewHolder(private val binding: ItemSerialBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(serialModel: SerialModel) {
            binding.tvName.text = serialModel.name
            binding.tvEpisode.text = serialModel.episode
            binding.tvDate.text = serialModel.date

            Glide.with(binding.root)
                .load(serialModel.image)
                .into(binding.imageSerial)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerialViewHolder {
        val binding = ItemSerialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SerialViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return serialList.size
    }

    override fun onBindViewHolder(holder: SerialViewHolder, position: Int) {
        holder.bind(serialList[position])
    }
}