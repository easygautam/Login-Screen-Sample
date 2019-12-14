package com.easygautam.loginscreen.view

import android.view.animation.AccelerateInterpolator

import android.view.animation.Animation

import android.view.animation.TranslateAnimation


fun inFromRightAnimation(): Animation? {
    val inFromRight: Animation = TranslateAnimation(
        Animation.RELATIVE_TO_PARENT, +1.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f
    )
    inFromRight.duration = 300
    inFromRight.interpolator = AccelerateInterpolator()
    return inFromRight
}

fun outToLeftAnimation(): Animation? {
    val outtoLeft: Animation = TranslateAnimation(
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, -1.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f
    )
    outtoLeft.duration = 300
    outtoLeft.interpolator = AccelerateInterpolator()
    return outtoLeft
}

fun inFromLeftAnimation(): Animation? {
    val inFromLeft: Animation = TranslateAnimation(
        Animation.RELATIVE_TO_PARENT, -1.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f
    )
    inFromLeft.duration = 300
    inFromLeft.interpolator = AccelerateInterpolator()
    return inFromLeft
}

fun outToRightAnimation(): Animation? {
    val outtoRight: Animation = TranslateAnimation(
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, +1.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f
    )
    outtoRight.duration = 300
    outtoRight.interpolator = AccelerateInterpolator()
    return outtoRight
}
