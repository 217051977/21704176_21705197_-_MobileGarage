package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle

@Dao
interface VehicleDao {

    @Insert
    suspend fun insert(vehicle: Vehicle)

    //@Query("SELECT * FROM vehicle")
    suspend fun getAll(): List<Vehicle>

    //@Query("SELECT * FROM vehicle WHERE uuid= :vehicleID ")
    suspend fun setVehicleToShow(vehicleID: String): Vehicle

}