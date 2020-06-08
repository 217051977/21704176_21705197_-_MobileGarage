package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.room.dao

import androidx.room.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park

@Dao
interface ParkDao {

    //@Insert
    //suspend fun insert(park: ParkDao)

    @Query("SELECT * FROM park")
    suspend fun getAll(): List<Park>

    @Query("SELECT * FROM park WHERE parkID= :parkID ")
    suspend fun setParkToShow(parkID: String): Park

}