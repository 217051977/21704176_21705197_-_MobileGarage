package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.list

import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park

class FiltersStatus {

    private val filterStatus: MutableList<String> = mutableListOf(
        "availability",
        "all",
        "false",
        "0"
    )

    companion object {

        private var instance: FiltersStatus? = null

        fun getInstance(): FiltersStatus {
            synchronized(this) {
                if (instance == null) {
                    instance =
                        FiltersStatus()
                }
                return instance as FiltersStatus
            }
        }

    }

    fun getFilters(): Array<String> = filterStatus.toTypedArray()

    fun getFilterSortStatus(): String = filterStatus[0]

    fun getFilterParkTypeStatus(): String = filterStatus[1]

    fun getAccessibilityStatus(): Boolean = filterStatus[2].toBoolean()

    fun getDistanceValueStatus(): Int = filterStatus[3].toInt()

    fun setSortByDistanceStatus() { filterStatus[0] = "distance" }

    fun setSortByAvailabilityStatus() { filterStatus[0] = "availability" }

    fun setSurfaceParkStatus() { filterStatus[1] = "surface" }

    fun setStructureParkStatus() { filterStatus[1] = "structure" }

    fun setAllParksStatus() { filterStatus[1] = "all" }

    fun setAccessibilityStatus(status: Boolean) { filterStatus[2] = status.toString() }

    fun setDistanceValueStatus(value: Int) { filterStatus[3] = value.toString() }

}