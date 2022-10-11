package com.example.slotmachinegame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.slotmachinegame.databinding.ActivityMainBinding
import kotlin.math.absoluteValue
import kotlin.collections.groupBy as groupBy

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var score = 1000
    var betPlus = 10
    var images = Array(5){0}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvScore.text = "Счет: ${score}"
        binding.tvSumBet.text = betPlus.toString()
        binding.iBPlus.setOnClickListener(){
            betPlus += 10
            binding.tvSumBet.text = betPlus.toString()
            if(betPlus >= score){
                binding.tvYWin.visibility = View.VISIBLE
                binding.tvYWin.text = "Ставка не может превышать сумму на счете"
                betPlus = score - 10
                }else{}
        }
        binding.iBMinus.setOnClickListener(){
            betPlus -= 10
            binding.tvSumBet.text = betPlus.toString()
            if (betPlus <= 0){
                binding.tvSumBet.text = "Cтавка не должна быть меньше 0"
            }
        }
    }

    var imagesRundom = mutableListOf<Int>(
        R.drawable.gamepad,
        R.drawable.airline,
        R.drawable.guitar,
        R.drawable.crown,
        R.drawable.palm_tree
    )

    fun onClickSpin(view: View) {
        images[0] = imagesRundom.random()
        binding.iV1.setImageResource(images[0])
        images[1] = imagesRundom.random()
        binding.iV2.setImageResource(images[1])
        images[2] = imagesRundom.random()
        binding.iV3.setImageResource(images[2])
        images[3] = imagesRundom.random()
        binding.iV4.setImageResource(images[3])
        images[4] = imagesRundom.random()
        binding.iV5.setImageResource(images[4])

        score -= betPlus

        if (score <= 0){
            score += 1000
            binding.tvScore.text = "0"
        }

        var group = images.groupingBy({ it }).eachCount().maxBy { it.value }.value

            if (group == 2){
                var win = betPlus * 2
                score += win
                binding.tvYWin.visibility = View.VISIBLE
                binding.tvYWin.text = "Выигрыш составляет: $win (x2)"
                binding.tvScore.text = "Счет: $score"
                if (win <= 0){
                    betPlus = 0
                    binding.tvYWin.visibility = View.VISIBLE
                    binding.tvYWin.text = "Необходимо сделать ставку"
                }else{}
            } else if (group == 3){
                var win = betPlus * 4
                score += win
                binding.tvYWin.visibility = View.VISIBLE
                binding.tvYWin.text = "Выигрыш составляет: $win (x4)"
                binding.tvScore.text = "Счет: $score"
                if (win <= 0){
                    betPlus = 0
                    binding.tvYWin.visibility = View.VISIBLE
                    binding.tvYWin.text = "Необходимо сделать ставку"
                }else{}
            }else if (group == 4){
                var win = betPlus * 6
                score += win
                binding.tvYWin.visibility = View.VISIBLE
                binding.tvYWin.text = "Выигрыш составляет: $win (x6)"
                binding.tvScore.text = "Счет: $score"
                if (win <= 0){
                    betPlus = 0
                    binding.tvYWin.visibility = View.VISIBLE
                    binding.tvYWin.text = "Необходимо сделать ставку"
                }else{}
            }else if (group == 5){
                var win = betPlus * 10
                score += win
                binding.tvYWin.visibility = View.VISIBLE
                binding.tvYWin.text = "Выигрыш составляет: $win (x10)"
                binding.tvScore.text = "Счет: $score"
                if (win <= 0){
                    betPlus = 0
                    binding.tvYWin.visibility = View.VISIBLE
                    binding.tvYWin.text = "Необходимо сделать ставку"
                }else{}
            }else{

                score -= betPlus
                binding.tvYWin.visibility = View.VISIBLE
                binding.tvYWin.text = "Нет выигрышных комбинаций"
                binding.tvScore.text = "Счет: $score"
            }
        }
    }



