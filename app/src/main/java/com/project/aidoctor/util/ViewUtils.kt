package com.project.aidoctor.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun Context.getWeekDay(date: String):String{
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val cal = Calendar.getInstance()
    cal.time = dateFormat.parse(date)!!
    return when(cal.get(Calendar.DAY_OF_WEEK)){
        1->"일"
        2->"월"
        3->"화"
        4->"수"
        5->"목"
        6->"금"
        7->"토"
        else -> ""
    }
}

fun ProgressBar.show(){
    if(visibility == View.INVISIBLE) {
        visibility = View.VISIBLE
    }
}

fun ProgressBar.hide(){
    if(visibility == View.VISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun View.snackbar(message: String){
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { snackbar ->
        snackbar.setAction("OK"){
            snackbar.dismiss()
        }
    }.show()
}

fun View.showKeyboard(){
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 1)
}

fun View.hideKeyboard(){
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}