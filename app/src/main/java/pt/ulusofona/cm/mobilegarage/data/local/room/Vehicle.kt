package pt.ulusofona.cm.mobilegarage.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Vehicle(val brand: String = "Mustang", val model: String = "GT500",
                   val plate: String = "NN-NN-NN", val plateDate: String = "10/10"
                   ) {

    @PrimaryKey
    var uuid: String = UUID.randomUUID().toString()
}