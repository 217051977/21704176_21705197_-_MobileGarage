package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: Long?): Calendar? {
        if (timestamp == null) return null
        return Calendar.getInstance()
    }

    @TypeConverter
    fun toTime(date: Calendar?): Long? {
        if (date == null) return null
        return Calendar.getInstance().timeInMillis
    }
}