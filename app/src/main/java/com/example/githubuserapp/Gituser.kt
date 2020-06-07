package com.example.githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Gituser(
    var photo: Int,
    var name: String,
    var description: String,
    var company: String,
    var location: String,
    var repo: String,
    var follower:String,
    var followin:String

) :Parcelable