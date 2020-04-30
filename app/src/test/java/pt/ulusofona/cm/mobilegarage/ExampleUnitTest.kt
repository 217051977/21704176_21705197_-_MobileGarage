package pt.ulusofona.cm.mobilegarage

import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
//    Example
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    /*@Test
    fun checkCalendar_GetInstance() {
        val actualDate = Calendar.getInstance()
        val newDate = Calendar.getInstance()
        newDate.set(2020, 5, 5)
        println(newDate.get(Calendar.YEAR))
        println(newDate.get(Calendar.MONTH) + 1)
        println(newDate.get(Calendar.DAY_OF_MONTH))
        assertEquals(
            "The year is not the same",
            2020,
            actualDate.get(Calendar.YEAR)
        )
        assertEquals(
            "The month is not the same",
            4,
            actualDate.get(Calendar.MONTH) + 1
        )
        assertEquals(
            "The day is not the same",
            30,
            actualDate.get(Calendar.DATE)
        )
        assertTrue(
            "Is not before",
            actualDate.before(newDate)
        )
//        assertTrue(
//            "Is not after",
//            actualDate.after(newDate)
//        )
        print(Calendar.getInstance().toString())
    }*/

}
