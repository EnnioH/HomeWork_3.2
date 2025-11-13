package com.example.homework_32

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_32.databinding.ItemSerialBinding

class SerialAdapter(
    private val serialList: ArrayList<SerialModel>,
    private val onClick: (SerialModel) -> Unit
) : RecyclerView.Adapter<SerialAdapter.SerialViewHolder>() {

    class SerialViewHolder(
        private val binding: ItemSerialBinding,
        private val onClick: (SerialModel) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(serialModel: SerialModel) {
            binding.tvName.text = serialModel.name
            binding.tvEpisode.text = serialModel.episode
            binding.tvDate.text = serialModel.date

            binding.imageSerial.loadImage(serialModel.image)

            binding.root.setOnClickListener {
                onClick(serialModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerialViewHolder {
        val binding = ItemSerialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SerialViewHolder(binding, onClick)
    }

    override fun getItemCount(): Int {
        return serialList.size
    }

    override fun onBindViewHolder(holder: SerialViewHolder, position: Int) {
        holder.bind(serialList[position])
    }
}