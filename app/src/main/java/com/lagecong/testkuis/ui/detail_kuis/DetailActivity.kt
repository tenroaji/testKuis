package com.lagecong.testkuis.ui.detail_kuis

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lagecong.testkuis.R
import com.lagecong.testkuis.data.models.Kuis
import kotlinx.android.synthetic.main.activity_detail_kuis.*

/**
 * Created by Andi Tenroaji Ahmad on 10/1/2019.
 */

class DetailActivity : AppCompatActivity() {
    var perbaikan = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kuis)

        var hasil = intent.getStringArrayListExtra("hasil")
        var soal = intent.getSerializableExtra("soal") as MutableList<Kuis>
        var cache = intent.getStringArrayListExtra("cache")
        var benar = 0
        var salah = 0
        perbaikan = "Perbaikan : \n"
        tvPerbaikan.text = perbaikan
        for ((count, hasil) in hasil.withIndex()) {
            if (hasil == "benar") {
                benar++
            } else {
                salah++
                perbaikan += "${count + 1} . Pilihan = ${cache[count]} Jawaban yang benar = ${soal[count].jawaban} \n"
            }
        }
        tvHasilTest.text = "Benar = $benar dan Salah = $salah"
        tvPerbaikan.text = perbaikan
    }

}