package com.wanti.design_listview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelFood (var name:String, var desc:String, var img:Int) : Parcelable