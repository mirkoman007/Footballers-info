package mirkozaper.from.hr.footballersinfo.utils

import mirkozaper.from.hr.footballersinfo.HeightDisplaySetting
import kotlin.math.roundToInt

fun getHeightFormat(height:Float,heightDisplaySetting: HeightDisplaySetting):String{
    return when(heightDisplaySetting){
        HeightDisplaySetting.Meter -> height.toString()+"m"
        HeightDisplaySetting.Feet -> {
            val feet=((100*height/2.54f)/12).roundToInt()
            val inches=((100*height/2.54f)-12*6).roundToInt()
            return "$feet'$inches"
        }
    }
}