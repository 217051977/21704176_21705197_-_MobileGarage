package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao

import androidx.room.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Vehicle

@Dao
interface VehicleDao {

    @Insert
    suspend fun insert(vehicle: Vehicle)

    @Query("SELECT * FROM vehicle")
    suspend fun getAll(): List<Vehicle>

    @Query("SELECT * FROM vehicle WHERE plate= :plate ")
    suspend fun setVehicleToShow(plate: String): Vehicle

}