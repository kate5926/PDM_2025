package com.example.examen_parcial

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ResultFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    private val scoreHistory = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated
                (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("game_prefs", Context.MODE_PRIVATE)

        // Obtener el score de los argumentos directamente
        val currentScore = arguments?.getInt("score") ?: 0
        setupUI(currentScore)
        updateHighScore(currentScore)
        addToHistory(currentScore)
    }

    private fun setupUI(currentScore: Int) {
        requireView().findViewById<android.widget.TextView>(R.id.tv_final_score).text = getString(R.string.final_score, currentScore)

        val highScore = sharedPreferences.getInt("high_score", 0)
        requireView().findViewById<android.widget.TextView>(R.id.tv_high_score).text = getString(R.string.high_score, highScore)

        requireView().findViewById<View>(R.id.btn_play_again).setOnClickListener {
            findNavController().navigate(R.id.action_result_to_welcome)
        }
    }

    private fun updateHighScore(currentScore: Int) {
        val currentHighScore = sharedPreferences.getInt("high_score", 0)
        if (currentScore > currentHighScore) {
            sharedPreferences.edit().putInt("high_score", currentScore).apply()
        }
    }

    private fun addToHistory(score: Int) {
        scoreHistory.add("Puntaje: $score")
        val listView = requireView().findViewById<android.widget.ListView>(R.id.list_history)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, scoreHistory)
        listView.adapter = adapter
    }
}