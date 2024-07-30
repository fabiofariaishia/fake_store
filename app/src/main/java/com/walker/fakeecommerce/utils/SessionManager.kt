package com.walker.fakeecommerce.utils

import android.content.SharedPreferences
import com.walker.fakeecommerce.model.AcessToken
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class SessionManager @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    private val ACESS_TOKEN_KEY = "ACESS_TOKEN_KEY"
    private val LOGIN_DATE_KEY = "LOGIN_DATE_KEY"

    fun writeToken(acessToken: AcessToken): Boolean {
        return try {
            val sharedPreferencesEdit = sharedPreferences.edit()

            sharedPreferencesEdit.putString(ACESS_TOKEN_KEY, acessToken.acessToken)
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

            val date = simpleDateFormat.format(Date())

            sharedPreferencesEdit.putString(LOGIN_DATE_KEY, date)

            sharedPreferencesEdit.apply()

            true
        } catch (e: Exception) {
            false
        }
    }

    fun readToken() = sharedPreferences.getString(ACESS_TOKEN_KEY, null)

    fun readDate() = sharedPreferences.getString(LOGIN_DATE_KEY, null)

    fun logout() = sharedPreferences.edit().clear().apply()
}