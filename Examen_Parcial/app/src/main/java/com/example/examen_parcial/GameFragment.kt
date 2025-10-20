package com.example.examen_parcial

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlin.random.Random

class GameFragment : Fragment() {

    private var score = 0
    private var targetColorIndex = 0
    private var timer: CountDownTimer? = null
    private val colors = listOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGame()
        startTimer()
    }

    private fun setupGame() {
        val buttons = listOf(
            requireView().findViewById<View>(R.id.btn_red),
            requireView().findViewById<View>(R.id.btn_green),
            requireView().findViewById<View>(R.id.btn_blue),
            requireView().findViewById<View>(R.id.btn_yellow),
            requireView().findViewById<View>(R.id.btn_purple),
            requireView().findViewById<View>(R.id.btn_orange)
        )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener { checkAnswer(index) }
        }

        generateNewColor()
        updateScore()
    }

    private fun checkAnswer(selectedIndex: Int) {
        if (selectedIndex == targetColorIndex) {
            score++
            updateScore()
            animateColorChange()
            generateNewColor()
        }
    }

    private fun animateColorChange() {
        val animation = AlphaAnimation(0.3f, 1.0f)
        animation.duration = 200
        requireView().findViewById<View>(R.id.color_target).startAnimation(animation)
    }

    private fun generateNewColor() {
        targetColorIndex = Random.nextInt(colors.size)
        requireView().findViewById<View>(R.id.color_target).setBackgroundColor(colors[targetColorIndex])
    }

    private fun updateScore() {
        requireView().findViewById<android.widget.TextView>(R.id.tv_score).text = getString(R.string.score, score)
    }

    private fun startTimer() {
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                requireView().findViewById<android.widget.TextView>(R.id.tv_time).text = getString(R.string.time, millisUntilFinished / 1000)
            }

            override fun onFinish() {
                endGame()
            }
        }.start()
    }

    private fun endGame() {
        timer?.cancel()
        val action = R.id.action_game_to_result
        val bundle = Bundle()
        bundle.putInt("score", score)
        findNavController().navigate(action, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
    }
}