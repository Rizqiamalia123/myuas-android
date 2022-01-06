package com.rizqiamalia.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rizqiamalia.myapplication.model.DataProduk
import com.rizqiamalia.myapplication.model.ResponseProduk
import com.rizqiamalia.myapplication.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BajuFragment : Fragment() {

    lateinit var rvProduk: RecyclerView
    lateinit var pBar: ProgressBar
    lateinit var adapter: ProdukAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_produk, container, false)

        init(view)

        return view
    }

    override fun onStart() {
        super.onStart()
        setData()
    }

    @SuppressLint("SetTextI18n")
    private fun init(view: View) {
        val tvJudul: TextView = view.findViewById(R.id.tv_judul)
        rvProduk = view.findViewById(R.id.rv_produk)
        pBar = view.findViewById(R.id.progress_bar)

        tvJudul.text = "Baju Pria & Wanita"

        val layoutManager = GridLayoutManager(requireActivity(), 2)

        adapter = ProdukAdapter(requireActivity(), arrayListOf())

        rvProduk.adapter = adapter
        rvProduk.layoutManager = layoutManager
    }

    private fun setData() {
        pBar.visibility = View.VISIBLE
        ApiService.endPoint.getBaju().enqueue(object : Callback<ResponseProduk> {
            override fun onResponse(
                call: Call<ResponseProduk>,
                response: Response<ResponseProduk>
            ) {
                pBar.visibility = View.GONE
                if (response.isSuccessful) {
                    val data: List<DataProduk> = response.body()!!.data!!
                    adapter.setData(data)
                }
            }

            override fun onFailure(call: Call<ResponseProduk>, t: Throwable) {
                pBar.visibility = View.GONE
            }

        })
    }
}