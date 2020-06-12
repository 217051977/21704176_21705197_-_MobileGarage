package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.domain.mobilegarage

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list.FiltersStatus

class FilterLogic {

    private val filterStatus: FiltersStatus = FiltersStatus.getInstance()

    fun getFilters(): Array<String> = filterStatus.getFilters()

    fun getFilterSortStatus(): String = filterStatus.getFilterSortStatus()

    fun getFilterParkTypeStatus(): String = filterStatus.getFilterParkTypeStatus()

    fun getAccessibilityStatus(): Boolean = filterStatus.getAccessibilityStatus()

    fun getDistanceValueStatus(): Int = filterStatus.getDistanceValueStatus()

    fun setSortByDistanceStatus() { filterStatus.setSortByDistanceStatus() }

    fun setSortByAvailabilityStatus() { filterStatus.setSortByAvailabilityStatus() }

    fun setSurfaceParkDistanceStatus() { filterStatus.setSurfaceParkStatus() }

    fun setStructureParkAvailabilityStatus() { filterStatus.setStructureParkStatus() }

    fun setAllParkAllStatus() { filterStatus.setAllParksStatus() }

    fun setAccessibilityStatus(status: Boolean) { filterStatus.setAccessibilityStatus(status) }

    fun setDistanceValueStatus(value: Int) { filterStatus.setDistanceValueStatus(value) }

}