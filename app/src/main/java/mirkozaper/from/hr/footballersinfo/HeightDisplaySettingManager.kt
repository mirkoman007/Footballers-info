package mirkozaper.from.hr.footballersinfo

import android.content.Context

enum class HeightDisplaySetting{
    Meter,Feet
}

class HeightDisplaySettingManager(context:Context){
    private val preferences=context.getSharedPreferences("settings",Context.MODE_PRIVATE)

    fun updateSetting(setting:HeightDisplaySetting){
        preferences.edit().putString("key_heightSetting",setting.name).apply()
    }

    fun getTempDisplaySettings():HeightDisplaySetting{
        val settingValue=preferences.getString("key_heightSetting",HeightDisplaySetting.Meter.name)?:HeightDisplaySetting.Meter.name
        return HeightDisplaySetting.valueOf(settingValue)
    }
}