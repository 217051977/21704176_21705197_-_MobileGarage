package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
open class Vehicle (
    val brand: String = "Mustang",
    val model: String = "GT500",
    @PrimaryKey
    val plate: String = "NN-NN-NN",
    val plateDate: String = "10/10",
    var insuranceDeadLineDate: Calendar,
    val category: String = "N",
    var month: Int = 0,
    var year: Int = 0,
    var pictureSrc: String = "mipmap-xxxhdpi/mustang_shelby_gt500.jpg",
    var isParked: Boolean = false,
    var vehicleTypeIconSrc: String = "drawable/ic_car.xml"
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