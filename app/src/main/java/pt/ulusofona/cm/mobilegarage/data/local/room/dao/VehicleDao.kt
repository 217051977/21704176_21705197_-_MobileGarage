package pt.ulusofona.cm.mobilegarage.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pt.ulusofona.cm.mobilegarage.data.local.room.Vehicle

@Dao
interface VehicleDao {

    @Insert
    suspend fun insert(vehicle: Vehicle)

    @Query("SELECT * FROM vehicle")
    suspend fun getAll(): List<Vehicle>

    @Query("SELECT * FROM vehicle WHERE uuid= :vehicleID ")
    suspend fun setVehicleToShow(vehicleID: String)


}