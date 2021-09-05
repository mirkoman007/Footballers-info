package mirkozaper.from.hr.footballersinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mirkozaper.from.hr.footballersinfo.model.Player

class PlayerViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val firstName: TextView =view.findViewById(R.id.firstName)
    private val lastName: TextView =view.findViewById(R.id.lastName)

    fun bind(player:Player){
        firstName.text=player.firstName.toString()
        lastName.text=player.lastName.toString()
    }

}
class PlayerAdapter(
        private val clickHandler:(Player)->Unit
):ListAdapter<Player,PlayerViewHolder>(DIFF_CONFIG){
    companion object{
        val DIFF_CONFIG=object :DiffUtil.ItemCallback<Player>(){
            override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
                return oldItem===newItem
            }

            override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_player,parent,false)
        return PlayerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener{
            clickHandler(getItem((position)))
        }
    }
}