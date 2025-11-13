package com.example.homework_32

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_32.databinding.FragmentSerialsBinding

class SerialsFragment : Fragment() {

    private var _binding: FragmentSerialsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSerialsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val serialsData = loadSerialsData()
        val adapter = SerialAdapter(serialsData) { serialModel ->
            navigateToDetail(serialModel)
        }

        binding.recycleViewSerials.layoutManager = LinearLayoutManager(requireContext())
        binding.recycleViewSerials.adapter = adapter
    }

    private fun navigateToDetail(serialModel: SerialModel) {
        val action = SerialsFragmentDirections.actionSerialsFragmentToSerialDetailFragment(serialModel)
        findNavController().navigate(action)
    }

    private fun loadSerialsData(): ArrayList<SerialModel> {
        val serialsList = ArrayList<SerialModel>()
        serialsList.add(SerialModel(
            "https://m.media-amazon.com/images/M/MV5BNTdkN2QwMDItMDM1YS00YmY1LTk0NjgtODMyM2M2MWEyM2VmXkEyXkFqcGdeQXVyMTAwMDIwNTg2._V1_FMjpg_UX1000_.jpg",
            "Чернобыль",
            "S1.E5",
            "Mon, Jun 3, 2019"
        ))
        serialsList.add(SerialModel(
            "https://flxt.tmsimg.com/assets/p23128919_b_v13_ab.jpg",
            "The Bear",
            "S2.E10",
            "Thu, Jun 22, 2023"
        ))
        serialsList.add(SerialModel(
            "https://m.media-amazon.com/images/M/MV5BMGRiOTM5YjQtZDA4Ny00YTRjLTkxM2MtMjNhYjVjYjE0Y2JlXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_.jpg",
            "Shogun",
            "S1.E9",
            "Tue, Apr 16, 2024"
        ))

        val duplicatedList = ArrayList<SerialModel>()
        for (i in 0..4) {
            duplicatedList.addAll(serialsList)
        }

        return duplicatedList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}