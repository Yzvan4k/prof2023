package com.example.codemaniacol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
// Этот клас описывает элементы находящихся во ViewPager
// 02.03.23
// Egor (Yzvan)

class ViewPagerAdapter(val list: List<OnBoard>): RecyclerView.Adapter<ViewPagerAdapter.VH>() {
    class VH(itenView:View):RecyclerView.ViewHolder(itenView) {
        val OnBoardText = itenView.findViewById<TextView>(R.id.OnBoardTEXT)
        val OnBoardImg = itenView.findViewById<ImageView>(R.id.OnboardIMG)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.on_board_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.OnBoardText.text = list[position].text
        holder.OnBoardImg.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, list[position].img))
    }
}