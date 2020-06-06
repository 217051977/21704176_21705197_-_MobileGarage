package pt.ulusofona.cm.mobilegarage.ui.listeners

import pt.ulusofona.cm.mobilegarage.data.local.entities.Park

interface OnReceiveParkingLots {

    fun onReceiveParkingLots(parks: List<Park>)

}