package com.example.slotmachinegame

class SlotGame {
    private var images = mutableListOf<Int>(
        R.drawable.gamepad,
        R.drawable.airline,
        R.drawable.guitar
    )
    fun showSlot(): Int{
        val output: Int = (0..(images.size - 1)).random()
        return images[output]
    }
}