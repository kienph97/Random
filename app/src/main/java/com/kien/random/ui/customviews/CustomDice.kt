package com.kien.random.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.kien.random.R
import com.kien.random.databinding.LayoutCustomDiceBinding

class CustomDice @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    var root: View? = null
    var binding: LayoutCustomDiceBinding? = null
    init {
        root = LayoutInflater.from(context).inflate(R.layout.layout_custom_dice, this, true)
        binding = LayoutCustomDiceBinding.inflate(LayoutInflater.from(context))
    }

    fun drawDice(list: ArrayList<Int>) {
        for (i in 0 until list.size) {
            when (i) {
                0 -> {
                    root?.findViewById<ImageView>(R.id.imvFirst)?.apply {
                        isVisible = true
                        setImageResource(getIconImage(list.get(i)))
                    }
                    root?.findViewById<ImageView>(R.id.imvForth)?.isVisible = false
                    root?.findViewById<ImageView>(R.id.imvThird)?.isVisible = false
                    root?.findViewById<ImageView>(R.id.imvSecond)?.isVisible = false
//                    binding?.imvFirst?.apply {
//                        isVisible = true
//                        setImageResource(getIconImage(list.get(i)))
//                    }
                }
                1 -> {
                    root?.findViewById<ImageView>(R.id.imvSecond)?.apply {
                        isVisible = true
                        setImageResource(getIconImage(list.get(i)))
                    }
                    root?.findViewById<ImageView>(R.id.imvForth)?.isVisible = false
                    root?.findViewById<ImageView>(R.id.imvThird)?.isVisible = false
//                    binding?.imvSecond?.apply {
//                        isVisible = true
//                        setImageResource(getIconImage(list.get(i)))
//                    }
                }
                2 -> {
                    root?.findViewById<ImageView>(R.id.imvThird)?.apply {
                        isVisible = true
                        setImageResource(getIconImage(list.get(i)))
                    }
                    root?.findViewById<ImageView>(R.id.imvForth)?.isVisible = false
//                    binding?.imvThird?.apply {
//                        isVisible = true
//                        setImageResource(getIconImage(list.get(i)))
//                    }
                }
                else -> {
                    root?.findViewById<ImageView>(R.id.imvForth)?.apply {
                        isVisible = true
                        setImageResource(getIconImage(list.get(i)))
                    }
//                    binding?.imvForth?.apply {
//                        isVisible = true
//                        setImageResource(getIconImage(list.get(i)))
//                    }
                }
            }
        }

    }

    fun getIconImage(value: Int): Int {
        return when(value) {
            1 -> {
                R.drawable.ic_dice_one
            }
            2 -> {
                R.drawable.ic_dice_two
            }
            3 -> {
                R.drawable.ic_dice_three
            }
            4 -> {
                R.drawable.ic_dice_fore
            }
            5 -> {
                R.drawable.ic_dice_five
            }
            else -> {
                R.drawable.ic_dice_six
            }
        }
    }
}