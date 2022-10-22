package com.example.gummy

data class CheckInfo(
    val title: String,
    var selected: Boolean,
    var onCheckedChange: (Boolean)->Unit
    )