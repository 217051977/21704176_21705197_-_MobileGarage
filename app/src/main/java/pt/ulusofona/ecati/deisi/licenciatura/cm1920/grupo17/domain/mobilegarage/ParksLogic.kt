package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import android.app.Activity
import android.content.Context
import android.view.View
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list.MockingDBParks
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.repositories.ParkRepository
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveFavorites
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceiveParks

class ParksLogic(private val repository: ParkRepository) {

    private val storage: MockingDBParks = MockingDBParks.getInstance()

    fun getParks(listener: OnReceiveParks?, view: View?, context: Context) = repository.getParks(listener, view, context)

    fun getFavorites(listener: OnReceiveFavorites?) = repository.getFavorites(listener)

}