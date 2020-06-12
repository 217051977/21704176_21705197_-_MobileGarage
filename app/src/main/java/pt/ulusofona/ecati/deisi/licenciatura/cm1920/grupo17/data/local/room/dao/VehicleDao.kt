package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao

import androidx.room.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle

@Dao
interface VehicleDao {


    @Insert
    suspend fun insertVehicle(vehicle: Vehicle)

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insertVehicles(vehicles: List<Vehicle>)

    @Query("SELECT * FROM vehicle")
    suspend fun getAll(): List<Vehicle>

    @Query("SELECT * FROM vehicle WHERE plate= :vehiclePlate ")
    suspend fun getVehicle(vehiclePlate: String): Vehicle

}