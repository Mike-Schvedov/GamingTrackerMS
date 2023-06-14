package com.mikeschvedov.gamingtrackerms.ui

import android.graphics.Color
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mikeschvedov.gamingtrackerms.databinding.GameViewHolderBinding
import com.mikeschvedov.gamingtrackerms.R
import com.mikeschvedov.gamingtrackerms.model.Game


class GTRecyclerViewAdapter(var gameList: List<Game>) :
    RecyclerView.Adapter<GTRecyclerViewAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.game_view_holder, parent, false)
        return GameViewHolder(view)
    }

    // Called for every item in our list
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {

        val binding = GameViewHolderBinding.bind((holder.itemView))

        binding.apply {

            // -----------------------  minimized view -----------------------------------------//

            gameNameXml.text = gameList[position].gameName


            if(gameList[position].totalHours == "0"){
                gameTotalHoursXml.text = ""
            }else{
                gameTotalHoursXml.text = gameList[position].totalHours
            }

            if(gameList[position].totalHours == "0"){
                gameImageXml.visibility = View.INVISIBLE // for the top 10 card
            }else{
                gameImageXml.setImageResource(gameList[position].gameImage)
            }


            if (gameList[position].isStoryCompleted) {
                cardview.setBackgroundColor(Color.parseColor("#a8f0ad"))
            }else if(gameList[position].totalHours == "0"){
                cardview.setBackgroundColor(Color.parseColor("#dbbb3b")) // for the top 10 card
            }

            cardview.setOnClickListener {
                // if layout is visible then hide it, if is hidden then make visible
                if (hiddenLayoutXml.visibility != View.VISIBLE) {
                    hiddenLayoutXml.visibility = View.VISIBLE
                } else {
                    hiddenLayoutXml.visibility = View.GONE
                }
            }

            // -----------------------  expanded view -----------------------------------------//
            if (gameList[position].gamePercent != null) {
                percentXml.text = "${gameList[position].gamePercent.toString()}%"
            } else {
                percentXml.text = ""
            }

            achievementsXml.text = gameList[position].gameAchievements

            if (gameList[position].hasStory) {
                storyXml.setImageResource(R.drawable.yes)
            } else {
                storyXml.setImageResource(R.drawable.no)
            }

            if (gameList[position].hasPlatinum) {
                platinumXml.setImageResource(R.drawable.platinum)
            } else {
                platinumXml.setImageResource(R.drawable.blank_platinum)
            }

            diffModifier1Xml.text = gameList[position].difficultyMod1
            diffModifier2Xml.text = gameList[position].difficultyMod2
            diffModifier3Xml.text = gameList[position].difficultyMod3
            diffModifier4Xml.text = gameList[position].difficultyMod4

            play1Xml.text = gameList[position].playInfo1
            play2Xml.text = gameList[position].playInfo2
            play3Xml.text = gameList[position].playInfo3

        }
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}