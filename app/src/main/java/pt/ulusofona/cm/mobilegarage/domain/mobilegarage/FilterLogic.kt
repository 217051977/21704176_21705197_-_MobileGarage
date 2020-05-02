package pt.ulusofona.cm.mobilegarage.domain.mobilegarage

import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.data.local.list.MockingDBParks

class FilterLogic {

    private val storage: MockingDBParks = MockingDBParks.getInstance()

    fun getFilterSortStatus(): String = storage.getFilterSortStatus()

    fun getFilterParkTypeStatus(): String = storage.getFilterParkTypeStatus()

    fun setSortByDistanceStatus() {
        storage.setSortByDistanceStatus()
    }

    fun setSortByAvailabilityStatus() {
        storage.setSortByAvailabilityStatus()
    }

    fun setSurfaceParkDistanceStatus() {
        storage.setSurfaceParkDistanceStatus()
    }

    fun setStructureParkAvailabilityStatus() {
        storage.setStructureParkAvailabilityStatus()
    }

    fun setAllParkAllStatus() {
        storage.setAllParkAllStatus()
    }

}