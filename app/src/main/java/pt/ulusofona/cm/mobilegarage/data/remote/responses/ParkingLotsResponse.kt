package pt.ulusofona.cm.mobilegarage.data.remote.responses

import com.google.gson.annotations.SerializedName

// RESPOSTA DA API DO PARKING LOTS

data class ParkingLotsResponse (
    @SerializedName("id_parque") val parkID: String,
    @SerializedName("nome") val name: String,
    @SerializedName("activo") val active: Short,
    @SerializedName("id_entidade") val entityID: Int,
    @SerializedName("capacidade_maxima") val maxCapacity: String,
    @SerializedName("ocupacao") val occupation: Int,
    @SerializedName("data_ocupacao") val lastUpdateDate: String,
    val latitude: String, var longitude: String,
    @SerializedName("tipo") val parkType: String
) {}