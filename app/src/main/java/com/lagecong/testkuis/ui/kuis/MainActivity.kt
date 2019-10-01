package com.lagecong.testkuis.ui.kuis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lagecong.testkuis.R
import com.lagecong.testkuis.data.models.Kuis
import com.lagecong.testkuis.ui.detail_kuis.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mSoal = 0
    var mCache: MutableList<String> = mutableListOf()
    var data: MutableList<Kuis> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tambahData()
        buttonNext.setOnClickListener {
            var pilihan = radioGroup.checkedRadioButtonId
            if (pilihan == -1) {
                Toast.makeText(this, "Silihkan pilih jawabannya !!", Toast.LENGTH_LONG).show()
            } else {
                when (pilihan) {
                    R.id.radioA -> mCache.add("a")
                    R.id.radioB -> mCache.add("b")
                    R.id.radioC -> mCache.add("c")
                    R.id.radioD -> mCache.add("d")
                }

                if (mSoal == data.size - 1) {
                    var intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("soal", ArrayList(data))
                    intent.putExtra("cache", ArrayList(mCache))
                    startActivity(intent)
                } else {
                    mSoal++
                    setData(mSoal)
                }
                radioGroup.clearCheck()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        radioGroup.clearCheck()
        mSoal = 0
        mCache.clear()
        setData(0)
    }

    fun setData(pos: Int) {
        tvSoal.text = data[0].soal
        radioA.text = data[0].choiceA
        radioB.text = data[0].choiceB
        radioC.text = data[0].choiceC
        radioD.text = data[0].choiceD
    }

    fun tambahData() {
        data.run {
            add(
                Kuis(
                    "Siapa nama saya ?",
                    "andi", "tenroaji", "ahmad", "andi tenroaji ahmad",
                    "d"
                )
            )
            add(
                Kuis(
                    "Siapa nama pertama saya ?",
                    "andi", "tenroaji", "ahmad", "andi tenroaji ahmad",
                    "a"
                )
            )
            add(
                Kuis(
                    "Siapa nama kedua saya ?",
                    "andi", "tenroaji", "ahmad", "andi tenroaji ahmad",
                    "b"
                )
            )
            add(
                Kuis(
                    "Siapa nama ketiga saya ?",
                    "andi", "tenroaji", "ahmad", "andi tenroaji ahmad",
                    "c"
                )
            )
            add(
                Kuis(
                    "Siapa nama keempat saya ?",
                    "andi", "tenroaji", "ahmad", "andi tenroaji ahmad",
                    "d"
                )
            )
        }
    }

}
