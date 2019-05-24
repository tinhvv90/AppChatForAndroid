package com.simson.appChat.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(val uid: String ,val email: String, val name: String, val profileImageUrl: String): Parcelable {
    constructor() : this("","","","")
}