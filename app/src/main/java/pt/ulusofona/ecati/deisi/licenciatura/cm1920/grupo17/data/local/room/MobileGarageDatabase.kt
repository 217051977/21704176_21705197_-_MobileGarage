package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room

import androidx.room.*

//@Database(entities = arrayOf(Vehicle::class), version = 1)
//@TypeConverters(DateConverter::class)
abstract class MobileGarageDatabase : RoomDatabase() {

    /*
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
     */

}