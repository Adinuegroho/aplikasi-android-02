package com.example.githubapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String,
    var username: String,
    var image: Int,
    var follow: Int,
    var follower: Int,
    var repository: Int,
    var location: String,
    var company: String
): Parcelable
