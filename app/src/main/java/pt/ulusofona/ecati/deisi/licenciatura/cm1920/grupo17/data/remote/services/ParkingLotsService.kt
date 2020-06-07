package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.services

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.remote.responses.ParkingLotsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ParkingLotsService {

    @GET("parking/lots")
    suspend fun getParkingLots(@Header ("api_key") apiKey: String):
            Response<List<ParkingLotsResponse>>

}