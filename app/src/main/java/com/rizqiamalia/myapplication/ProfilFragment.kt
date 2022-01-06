package com.rizqiamalia.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.rizqiamalia.myapplication.model.DataProduk
import com.rizqiamalia.myapplication.model.DataUser
import com.rizqiamalia.myapplication.model.ResponseUser
import com.rizqiamalia.myapplication.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilFragment : Fragment() {

    lateinit var ivGambar: ImageView
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var pBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profil, container, false)

        init(view)

        return view
    }

    override fun onStart() {
        super.onStart()
        setData()
    }

    private fun init(view: View) {
        ivGambar = view.findViewById(R.id.iv_gambar)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        pBar = view.findViewById(R.id.progress_bar)
    }

    private fun setData() {
        pBar.visibility = View.VISIBLE
        ApiService.endPoint.getUser().enqueue(object : Callback<ResponseUser> {
            override fun onResponse(
                call: Call<ResponseUser>,
                response: Response<ResponseUser>
            ) {
                pBar.visibility = View.GONE
                if (response.isSuccessful) {
                    if (response.body()!!.status) {
                        val data: DataUser = response.body()!!.data!!
                        Glide.with(requireActivity())
                            .load(Constant.IP_IMAGE + data.gambar)
                            .centerCrop()
                            .placeholder(R.color.teal_200)
                            .error(R.color.teal_200)
                            .into(ivGambar)
                        tvNama.text = data.nama
                        tvEmail.text = data.email
                    } else {
                        Toast.makeText(requireContext(), response.body()!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                pBar.visibility = View.GONE
            }

        })
    }
}