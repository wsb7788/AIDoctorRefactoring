package com.project.aidoctor.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


class SharedPreferencesManager(private val context: Context){

    companion object{
        const val TAG = "MOBILE_TEMPLATE_APP"
        const val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        const val ERROR_TAG = "WEKIT_ERROR_TAG"
        const val CHECK_TAG = "WEKIT_CHECK_TAG"
        const val CLIENT_ID = "CLIENT_ID"
        const val NICKNAME = "NICKNAME"
        const val PUSH_FLAG = "PUSH_FLAG"
        const val BODY = "BODY"
        const val USER = "USER"
        const val EMAIL = "EMAIL"
    }


    private fun getSignUpPref() : SharedPreferences {
        return context.getSharedPreferences("signUp", Context.MODE_PRIVATE)
    }
    private fun getUserInfoPref() : SharedPreferences {
        return context.getSharedPreferences("userInfo", Context.MODE_PRIVATE)
    }
    private fun getSettingInfoPref() : SharedPreferences{
        return context.getSharedPreferences("SettingInfo",Context.MODE_PRIVATE)
    }
    private fun getTokenPref() : SharedPreferences{
        return context.getSharedPreferences("token",Context.MODE_PRIVATE)
    }
    private fun getInstantPref() : SharedPreferences{
        return context.getSharedPreferences("instant",Context.MODE_PRIVATE)
    }

    fun getToken():String{
        val pref = getTokenPref()
        return pref.getString("token","")!!
    }
    fun removeAll(){
        val pref = getUserInfoPref()
        val edit = pref.edit()
        edit.clear()
        edit.apply()
    }

    fun saveUser(id: String){
        val pref = getUserInfoPref()
        val edit = pref.edit()
        edit.putString("id",id)
        edit.putString("token",getToken())
        edit.apply()
    }

    fun notFirstLaunch(){
        val pref = getSettingInfoPref()
        val edit = pref.edit()
        edit.putBoolean("isFirstLaunch",false)
        edit.apply()
    }
    fun saveAutoLogin(){
        val pref = getUserInfoPref()
        val edit = pref.edit()
        edit.putBoolean("autoLoginSuccess",true)
        edit.apply()
    }
    fun getId():String{
        val pref = getUserInfoPref()
        return pref.getString("id","")!!
    }

    fun saveNickname(nickname: String) {
        val pref = getUserInfoPref()
        val edit = pref.edit()
        edit.putBoolean("nickname",true)
        edit.apply()
    }

    fun getAutoLoginSuccess(): Boolean {
        val pref = getUserInfoPref()
        return pref.getBoolean("autoLoginSuccess",false)
    }
    fun saveSignUpUserInfo2(email:String, password:String){
        val pref = getSignUpPref()
        val edit = pref.edit()
        edit.putString("email",email)
        edit.putString("password",password)
        edit.apply()
    }
    fun getSignUpEmail():String{
        val pref = getSignUpPref()
        return pref.getString("email","")!!
    }
    fun getSignUpPassword():String{
        val pref = getSignUpPref()
        return pref.getString("password","")!!
    }

    fun saveSignUpCode(code: String) {
        val pref = getSignUpPref()
        val edit = pref.edit()
        edit.putString("code",code)
        edit.apply()
    }

    fun getSignUpCode(): String {
        val pref = getSignUpPref()
        return pref.getString("code","")!!
    }

    fun getSignUpBdate(): String {
        val pref = getSignUpPref()
        return pref.getString("bdate","")!!
    }

    fun getSignUpName(): String {
        val pref = getSignUpPref()
        return pref.getString("name","")!!
    }

    fun saveSignUpUserInfo(name: String,bdate:String) {
        val pref = getSignUpPref()
        val edit = pref.edit()
        edit.putString("name",name)
        edit.putString("bdate",bdate)
        edit.apply()
    }

    fun saveJwtToken(jwtToken: String) {
        val pref = getUserInfoPref()
        val edit = pref.edit()
        edit.putString("jwt_token",jwtToken)
        edit.apply()
    }
    fun getJwtToken():String{
        val pref = getUserInfoPref()
        return pref.getString("jwt_token","")!!
    }

    fun saveChatCode(code: String) {
        val pref = getUserInfoPref()
        val edit = pref.edit()
        edit.putString("chat_code",code)
        edit.apply()
    }
    fun getChatCode():String{
        val pref = getUserInfoPref()
        return pref.getString("chat_code","")!!
    }

    fun saveDate(date: String) {
        val pref = getInstantPref()
        val edit = pref.edit()
        edit.putString("date",date)
        edit.apply()
    }
    fun saveTime(hour:Int, minute:Int) {
        val pref = getInstantPref()
        val edit = pref.edit()
        if(hour>12){
            edit.putString("time"," 오후 ${hour-12}:${minute}")
            edit.apply()
            return
        }
        edit.putString("time"," 오전 ${hour}:${minute}")
        edit.apply()
    }

    fun getDate(): String {
        val pref = getInstantPref()
        return pref.getString("date","123")!!
    }
    fun getTime(): String {
        val pref = getInstantPref()
        return pref.getString("time","456")!!
    }

    fun saveQuestionIndex(index:Int){
        val pref = getInstantPref()
        val edit = pref.edit()
        edit.putInt("questionIndex",index)
        edit.apply()
    }
    fun getQuestionIndex(): Int {
        val pref = getInstantPref()
        return pref.getInt("questionIndex",12312312)!!
    }

    fun saveCvsID(cvsID: String) {
        val pref = getInstantPref()
        val edit = pref.edit()
        edit.putString("cvsID",cvsID)
        edit.apply()
    }
    fun getCvsID(): String {
        val pref = getInstantPref()
        return pref.getString("cvsID","")!!
    }
}