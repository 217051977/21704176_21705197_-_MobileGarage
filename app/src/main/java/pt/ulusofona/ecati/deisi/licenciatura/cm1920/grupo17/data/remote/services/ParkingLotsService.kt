package pt.ulusofona.cm.mobilegarage.data.remote.services

import pt.ulusofona.cm.mobilegarage.data.remote.responses.ParkingLotsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ParkingLotsService {

    @GET("parking/lots")
    suspend fun getParkingLots(@Header ("api_key") apiKey: String):
            Response<List<ParkingLotsResponse>>

}