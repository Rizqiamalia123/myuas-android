package com.rizqiamalia.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rizqiamalia.myapplication.model.DataProduk

class ProdukAdapter(
    var context: Context,
    var produk: ArrayList<DataProduk>
) : RecyclerView.Adapter<ProdukAdapter.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)!!
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)!!
        val tvStok = view.findViewById<TextView>(R.id.tv_stok)!!
        val ivGambar = view.findViewById<ImageView>(R.id.iv_gambar)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_produk, parent, false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val produk = produk[position]

        holder.tvNama.text = produk.nama
        holder.tvHarga.text = "Rp." + produk.harga
        holder.tvStok.text = produk.stok
        Glide.with(context)
            .load(Constant.IP_IMAGE + produk.gambar)
            .centerCrop()
            .placeholder(R.color.teal_200)
            .error(R.color.teal_200)
            .into(holder.ivGambar)
    }

    override fun getItemCount(): Int {
        return produk.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newDataProduk: List<DataProduk>) {
        produk.clear()
        produk.addAll(newDataProduk)
        notifyDataSetChanged()
    }

}