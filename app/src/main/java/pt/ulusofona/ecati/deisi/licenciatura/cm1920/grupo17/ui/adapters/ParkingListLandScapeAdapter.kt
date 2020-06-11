package pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_park_element.view.*
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.R
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Feedback
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.data.local.entities.Park
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.listeners.OnReceivePark
import pt.ulusofona.ecati.deisi.licenciatura.cm1920.grupo17.ui.utils.ParkNavigationManager

class ParkingListLandScapeAdapter(
    private val context: Context,
    private val layout: Int,
    private val items: MutableList<Park>,
    private val supportFragmentManager: FragmentManager
) : RecyclerView.Adapter<ParkingListLandScapeAdapter.ParkingListLandScapeViewHolder>() {

    private val feedback: Feedback = Feedback.getInstance()

    class ParkingListLandScapeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val parkName: TextView = view.text_park_name
        val availability: TextView = view.text_availability
        val parkType: TextView = view.text_park_type
        val favIcon: ImageView = view.add_favorite
        val address: TextView = view.text_park_address
        val distance: TextView = view.text_distance
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingListLandScapeViewHolder {
        return ParkingListLandScapeViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ParkingListLandScapeViewHolder, position: Int) {
        setOnClickTreatment(holder, position)
        holder.parkName.text = items[position].name
        holder.availability.text = items[position].getAvailabilityStatus()
        holder.parkType.text = items[position].type
        if (items[position].favorite) {
            holder.favIcon.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            holder.favIcon.setImageResource(R.drawable.ic_favorite_border)
        }
        holder.address.text = items[position].address
        holder.distance.text = items[position].distance.toString()
    }

    override fun getItemCount() = items.size

    private fun setOnClickTreatment(holder: ParkingListLandScapeViewHolder, position: Int) {
        holder.itemView.goTo.setOnClickListener {
            val gmmIntentURI: Uri = Uri.parse("google.navigation:q=${items[position].address}")
            val mapIntent: Intent = Intent(Intent.ACTION_VIEW, gmmIntentURI)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)
        }
        holder.itemView.add_favorite.setOnClickListener {
            val park: Park = items[position]
            feedback.createFullButton(
                this::class.java.simpleName,
                context,
                "${park.name} added to the Favorites"
            )
            if (park.favorite) {
                park.favorite = false
                holder.favIcon.setImageResource(
                    R.drawable.ic_favorite_border
                )
            } else {
                park.favorite = true
                holder.favIcon.setImageResource(
                    R.drawable.ic_favorite_filled
                )
            }
            notifyDataSetChanged()
        }

        holder.itemView.park.setOnClickListener {
            feedback.createFullButton(
                this::class.java.simpleName,
                context,
                items[position].name
            )
            ParkNavigationManager.goToParkDetails(supportFragmentManager)
        }
    }

}