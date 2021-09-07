package mirkozaper.from.hr.footballersinfo.BroadcastReceiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import java.util.*

class BootReceiver: BroadcastReceiver() {
    private val HOUR_TO_SHOW_PUSH = 10

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.intent.action.BOOT_COMPLETED") {
            val alarmManager = context?.getSystemService(ALARM_SERVICE) as AlarmManager
            val alarmPendingIntent by lazy {
                val intent = Intent(context, AlarmReceiver::class.java)
                PendingIntent.getBroadcast(context, 0, intent, 0)
            }



            val calendar = GregorianCalendar.getInstance().apply {
                if (get(Calendar.HOUR_OF_DAY) >= HOUR_TO_SHOW_PUSH) {
                    add(Calendar.DAY_OF_MONTH, 1)
                }

                set(Calendar.HOUR_OF_DAY, HOUR_TO_SHOW_PUSH)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }

            alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    AlarmManager.INTERVAL_DAY,
                    alarmPendingIntent
            )
        }
    }

}