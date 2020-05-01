package pt.ulusofona.cm.mobilegarage.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_park_element.view.*
import pt.ulusofona.cm.mobilegarage.R
import pt.ulusofona.cm.mobilegarage.data.local.entities.Park

class FavoritesAdapter(
    private val context: Context,
    private val layout: Int,
    private val items: MutableList<Park>,
    private val supportFragmentManager: FragmentManager
) : RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    class FavoritesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val parkName: TextView = view.text_park_name
        val availability: TextView = view.text_availability
        val parkType: TextView = view.text_park_type
        val favIcon: ImageView = view.add_favorite
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(
            LayoutInflater.from(
                context
            ).inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        setOnClickTreatment(holder, position)
        holder.parkName.text = items[position].name
        holder.availability.text = items[position].getAvailabilityStatus()
        holder.parkType.text = items[position].type
    }

    override fun getItemCount() = items.size

    private fun setOnClickTreatment(holder: FavoritesViewHolder, position: Int) {
        holder.itemView.add_favorite.setOnClickListener {
            val park: Park = items[position]
            Toast.makeText(
                context,
                "${park.name} added to the Favorites",
                Toast.LENGTH_SHORT
            ).show()
            park.favorite = false
            holder.favIcon.setImageResource(
                R.drawable.ic_favorite_border_black_24dp
            )
            items.remove(park)
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                items[position].name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}