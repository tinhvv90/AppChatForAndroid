package com.simson.appChat.models

class User(val email: String, val name: String, val profileImageUrl: String) {
    constructor() : this("","","")
}