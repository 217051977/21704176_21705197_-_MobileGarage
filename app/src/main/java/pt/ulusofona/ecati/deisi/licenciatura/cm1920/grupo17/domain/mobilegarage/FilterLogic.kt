package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list.MockingDBParks

class FilterLogic {

    private val storage: MockingDBParks = MockingDBParks.getInstance()

    fun getFilterSortStatus(): String = storage.getFilterSortStatus()

    fun getFilterParkTypeStatus(): String = storage.getFilterParkTypeStatus()

    fun getAccessibilityStatus(): Boolean = storage.getAccessibilityStatus()

    fun getDistanceValueStatus(): Int = storage.getDistanceValueStatus()

    fun setSortByDistanceStatus() { storage.setSortByDistanceStatus() }

    fun setSortByAvailabilityStatus() { storage.setSortByAvailabilityStatus() }

    fun setSurfaceParkDistanceStatus() { storage.setSurfaceParkStatus() }

    fun setStructureParkAvailabilityStatus() { storage.setStructureParkStatus() }

    fun setAllParkAllStatus() { storage.setAllParksStatus() }

    fun setAccessibilityStatus(status: Boolean) { storage.setAccessibilityStatus(status) }

    fun setDistanceValueStatus(value: Int) { storage.setDistanceValueStatus(value) }

}