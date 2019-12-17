package com.easygautam.easymaterialdesign

import android.util.Patterns


fun String?.isEmailNotValid(): Boolean {
    this?.let { it ->
        return !Patterns.EMAIL_ADDRESS.matcher(it).matches()
    } ?: return true
}

fun String?.isPasswordNotValid(): Boolean {
    this?.length?.let { it ->
        return it < 5
    } ?: return true
}

fun String?.isMobileNotValid(): Boolean {
    this?.length?.let { it ->
        return it < 10
    } ?: return true
}

