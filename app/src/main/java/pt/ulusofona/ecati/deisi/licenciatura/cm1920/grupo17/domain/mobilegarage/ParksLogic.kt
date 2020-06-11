package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import android.content.Context
import android.view.View
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list.MockingDBParks
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.ParkRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveFavorites
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParks

class ParksLogic(private val repository: ParkRepository) {

    fun getParksOnline(listener: OnReceiveParks?, view: View?, context: Context) = repository.getParksOnline(listener, view, context)

    fun getParksOffline(listener: OnReceiveParks?, view: View?, context: Context) = repository.getParksOffline(listener, view, context)

    fun getFavorites(listener: OnReceiveFavorites?) = repository.getFavorites(listener)

}