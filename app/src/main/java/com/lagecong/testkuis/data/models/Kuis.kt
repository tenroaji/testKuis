package com.lagecong.testkuis.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Andi Tenroaji Ahmad on 9/26/2019.
 */

data class Kuis (
    var soal : String? = "",
    var choiceA : String? = "",
    var choiceB : String? = "",
    var choiceC : String? = "",
    var choiceD : String? = "",
    var jawaban : String? = ""
):Serializable
