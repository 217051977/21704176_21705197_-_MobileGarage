package pt.ulusofona.cm.mobilegarage.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_vehicle_list.view.*
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park
import pt.ulusofona.cm.mobilegarage.data.local.entities.Vehicle

class MyVehiclesAdapter(
    private val context: Context,
    private val layout: Int,
    private val items: MutableList<Vehicle>,
    private val supportFragmentManager: FragmentManager
) : RecyclerView.Adapter<MyVehiclesAdapter.MyVehiclesViewHolder>() {

    class MyVehiclesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val isParked: TextView = view.is_parked
        val insurancePaid: TextView = view.insurance_paid
        val plate: TextView = view.plate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVehiclesViewHolder {
        return MyVehiclesViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyVehiclesViewHolder, position: Int) {
        setOnClickTreatment(holder, position)
        holder.isParked.text = items[position].getParkedStatus()
        holder.insurancePaid.text = items[position].insuranceState()
        holder.plate.text = items[position].plate
    }

    override fun getItemCount(): Int = items.size

    private fun setOnClickTreatment(holder: MyVehiclesViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                items[position].plate,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}