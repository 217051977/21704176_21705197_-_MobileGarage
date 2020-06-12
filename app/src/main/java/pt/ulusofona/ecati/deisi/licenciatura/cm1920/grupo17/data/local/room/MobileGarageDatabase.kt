package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room

import android.content.Context
import androidx.room.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao.ParkDao
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao.VehicleDao

@Database(entities = arrayOf(Vehicle::class, Park::class), version = 2)
@TypeConverters(DateConverter::class)
abstract class MobileGarageDatabase : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao
    abstract fun parkDao(): ParkDao

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