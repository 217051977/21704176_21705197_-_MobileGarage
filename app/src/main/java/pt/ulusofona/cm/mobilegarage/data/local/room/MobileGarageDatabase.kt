package pt.ulusofona.cm.mobilegarage.data.local.room

import android.content.Context
import androidx.room.*
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle
import pt.ulusofona.cm.mobilegarage.data.local.room.dao.VehicleDao

@Database(entities = arrayOf(Vehicle::class), version = 1)
@TypeConverters(DateConverter::class)
abstract class MobileGarageDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao

    companion object{

        private var instance: MobileGarageDatabase? = null

        fun getInstance(applicationContext: Context): MobileGarageDatabase {
            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        applicationContext,
                        MobileGarageDatabase::class.java,
                        "mobilegarage_db"
                    ).build()
                }
                return instance as MobileGarageDatabase
            }
        }
    }

}