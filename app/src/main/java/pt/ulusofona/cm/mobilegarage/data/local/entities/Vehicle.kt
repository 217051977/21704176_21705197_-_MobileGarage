package pt.ulusofona.cm.mobilegarage.data.local.entities

import java.util.*

open class Vehicle (
    val plate: String,
    var insuranceDeadLineDate: Calendar,
    val category: String,
    var year: Int = 0,
    var pictureSrc: String = "mipmap-xxxhdpi/mustang_shelby_gt500.jpg",
    var isParked: Boolean = false,
    var vehicleTypeIconSrc: String = "drawable/ic_directions_car_black_24dp.xml"
) {

    fun isYoungerThan(year: Int): Boolean = this.year < year

    fun isOlderThan(year: Int): Boolean = this.year > year

    fun getParkedStatus(): String = if (isParked) {
        "Parked"
    } else {
        "Not Parked"
    }

    fun setInsuranceDate(year: Int, month: Int, day: Int) {
        insuranceDeadLineDate.set(year, month, day)
    }

    fun insuranceState(): String {
        val actualDate = Calendar.getInstance()

        return when {
            youngerDateThan(actualDate) -> {
                "Insurance expired"
            }
            olderDateThan(actualDate) -> {
                "Insurance in day"
            }
            else -> {
                "Insurance expires today"
            }
        }

    }

    fun isInsuranceStillInDate(): Boolean = !this.insuranceDeadLineDate.before(
        Calendar.getInstance()
    )

    private fun olderDateThan(actualDate: Calendar): Boolean = smallerYearThan(actualDate) ||
        equalYearTo(actualDate) && smallerMonthThan(actualDate) ||
        equalYearTo(actualDate) && equalMonthTo(actualDate) && smallerDayThan(actualDate)

    private fun youngerDateThan(actualDate: Calendar): Boolean = biggerYearThan(actualDate) ||
            equalYearTo(actualDate) && biggerMonthThan(actualDate) ||
            equalYearTo(actualDate) && equalMonthTo(actualDate) && biggerDayThan(actualDate)

    private fun biggerYearThan(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.YEAR) < insuranceDeadLineDate.get(Calendar.YEAR)

    private fun biggerMonthThan(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.MONTH) < insuranceDeadLineDate.get(Calendar.MONTH)

    private fun biggerDayThan(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.DAY_OF_MONTH) < insuranceDeadLineDate.get(Calendar.DAY_OF_MONTH)

    private fun smallerYearThan(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.YEAR) > insuranceDeadLineDate.get(Calendar.YEAR)

    private fun smallerMonthThan(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.MONTH) > insuranceDeadLineDate.get(Calendar.MONTH)

    private fun smallerDayThan(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.DAY_OF_MONTH) > insuranceDeadLineDate.get(Calendar.DAY_OF_MONTH)

    private fun equalYearTo(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.YEAR) == insuranceDeadLineDate.get(Calendar.YEAR)

    private fun equalMonthTo(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.MONTH) == insuranceDeadLineDate.get(Calendar.MONTH)

    private fun equalDayTo(actualDate: Calendar): Boolean =
        actualDate.get(Calendar.DAY_OF_MONTH) == insuranceDeadLineDate.get(Calendar.DAY_OF_MONTH)

}