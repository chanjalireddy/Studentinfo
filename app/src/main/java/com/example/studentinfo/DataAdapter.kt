package com.example.studentinfo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.SmsManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.widget.Filterable

class DataAdapter(val context:Context,val repos: List<Model>) : RecyclerView.Adapter<DataAdapter.ViewHolder>(),Filterable {

    private var reposFiltered: List<Model> = repos

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById<TextView>(R.id.Rollno)
        val nam: TextView = itemView.findViewById<TextView>(R.id.Name)
        val phon: TextView = itemView.findViewById<TextView>(R.id.Phoneno)
        val fnam: TextView = itemView.findViewById<TextView>(R.id.Fname)
        val fphom: TextView = itemView.findViewById<TextView>(R.id.Fphone)
        val img: ImageView = itemView.findViewById(R.id.Image)
        val but1:Button=itemView.findViewById(R.id.callp)
        val but2:Button=itemView.findViewById(R.id.calls)
        val but3:Button=itemView.findViewById(R.id.msg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):DataAdapter.ViewHolder {
        return  ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        )

    }



    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val repo = reposFiltered[position]

        holder.id.text=repo.rollno
        holder.nam.text=repo.name
        holder.phon.text=repo.phoneno
        holder.fnam.text=repo.fname
        holder.fphom.text=repo.fphone

        Glide.with(holder.itemView.context)
            .load(repo.image).into(holder.img)

        holder.but2.setOnClickListener {
            var p=Intent(Intent.ACTION_DIAL)
            p.setData(Uri.parse("tel:${holder.phon.text}"))
            context.startActivity(p)
        }
        holder.but1.setOnClickListener {
            var pi=Intent(Intent.ACTION_DIAL)
            pi.setData(Uri.parse("tel:${holder.fphom.text}"))
            context.startActivity(pi)
        }
        holder.but3.setOnClickListener {

            var i =Intent(Intent.ACTION_VIEW,Uri.parse("sms:"+{holder.fphom.text}.toString()))
            i.putExtra("msg_body","hello sir/madam")
            context.startActivity(i)
            /*var j=SmsManager.getDefault()
            j.sendTextMessage("${holder.fphom.text}",null,"Hi,Welcome",null,null)*/

/*
            var m=SmsManager.getDefault()
            m.sendTextMessage({holder.fphom.text}.toString(),null,"hi sir",null,null)*/

        }









    }

    override fun getItemCount() : Int {


        return reposFiltered.size
    }




    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString() ?: ""

                reposFiltered = if (query.isEmpty()) {
                    repos
                } else {
                    repos.filter { it.rollno.contains(query, true) }
                }
                Log.d("DataAdapter", "Filtered list size: ${reposFiltered.size}") // Log filtered results

                val filterResults = FilterResults()
                filterResults.values = reposFiltered
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                reposFiltered = results?.values as List<Model>
                Log.d("DataAdapter", "Publishing results with size: ${reposFiltered.size}")
                notifyDataSetChanged()
            }
        }
    }
}