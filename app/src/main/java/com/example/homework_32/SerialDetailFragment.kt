package com.example.homework_32

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.homework_32.databinding.FragmentSerialDetailBinding

class SerialDetailFragment : Fragment() {

    private var _binding: FragmentSerialDetailBinding? = null
    private val binding get() = _binding!!

    private val args: SerialDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSerialDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
    }

    private fun setupViews() {
        val serialModel = args.serialModel

        binding.tvTitle.text = serialModel.name
        binding.tvEpisode.text = serialModel.episode
        binding.tvDate.text = serialModel.date

        binding.imageSerial.loadImage(serialModel.image)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}