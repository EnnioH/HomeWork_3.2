package com.example.homework_32

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_32.SerialAdapter
import com.example.homework_32.SerialModel
import com.example.homework_32.databinding.FragmentSerialsBinding

class SerialsFragment : Fragment() {

    private lateinit var binding: FragmentSerialsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSerialsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = loadData()
        val adapter = SerialAdapter(data)
        binding.recycleViewSerials.adapter = adapter
    }

    private fun loadData(): ArrayList<SerialModel> {
        val list = ArrayList<SerialModel>()
        list.add(SerialModel("https://m.media-amazon.com/images/M/MV5BNTdkN2QwMDItMDM1YS00YmY1LTk0NjgtODMyM2M2MWEyM2VmXkEyXkFqcGdeQXVyMTAwMDIwNTg2._V1_FMjpg_UX1000_.jpg", "Чернобль", "S1.E5", "Mon, Jun 3, 2019"))
        list.add(SerialModel("https://flxt.tmsimg.com/assets/p23128919_b_v13_ab.jpg", "The Bear", "S2.E10", "Thu, Jun 22, 2023"))
        list.add(SerialModel("https://m.media-amazon.com/images/M/MV5BMGRiOTM5YjQtZDA4Ny00YTRjLTkxM2MtMjNhYjVjYjE0Y2JlXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg", "Shogun", "S1.E9", "Tue, Apr 16, 2024"))

        list.addAll(list)
        list.addAll(list)

        return list
    }
}