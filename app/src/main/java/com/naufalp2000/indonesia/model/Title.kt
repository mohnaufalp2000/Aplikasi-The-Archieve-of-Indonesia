package com.naufalp2000.indonesia.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Title (
    var title : String,
    var img : Int
) : Parcelable