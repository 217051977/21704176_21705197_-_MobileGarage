package pt.ulusofona.cm.mobilegarage.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_park_element.view.*
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park

class ParkingListAdapter(
    private val context: Context,
    private val layout: Int,
    private val items: MutableList<Park>
) : RecyclerView.Adapter<ParkingListAdapter.ParkingListViewHolder>() {

    class ParkingListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val parkName: TextView = view.text_park_name
        val availability: TextView = view.text_availability
        val parkType: TextView = view.text_park_type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingListViewHolder {
        return ParkingListViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ParkingListViewHolder, position: Int) {
        holder.parkName.text = items[position].name
        holder.availability.text = items[position].getAvailabilityStatus()
        holder.parkType.text = items[position].type
    }

    override fun getItemCount() = items.size



}