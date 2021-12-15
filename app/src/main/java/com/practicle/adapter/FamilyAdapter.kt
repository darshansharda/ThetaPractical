package com.practicle.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.practicle.databinding.RowFamilyBinding
import com.practicle.model.FamilyData

class FamilyAdapter(private val familyList: ArrayList<FamilyData>) :
    RecyclerView.Adapter<FamilyAdapter.OpenExchangeDataHolder>() {

    class OpenExchangeDataHolder(val binding: RowFamilyBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OpenExchangeDataHolder {
        return OpenExchangeDataHolder(
            RowFamilyBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(
        holder: OpenExchangeDataHolder,
        position: Int
    ) {
        holder.binding.apply {

            tvName.text = familyList[holder.adapterPosition].name
            tvAge.text = familyList[holder.adapterPosition].age
            tvEmail.text = familyList[holder.adapterPosition].email

        }

    }

    override fun getItemCount() = familyList.size
}