package com.example.tugaspertemuan11

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan11.databinding.ActivityMainBinding
import com.example.tugaspertemuan11.model.ItemModel
import com.example.tugaspertemuan11.model.ApiResponse
import com.example.tugaspertemuan11.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listView = binding.listView

        fetchData()
    }

    private fun fetchData() {
        val apiService = ApiService.getInstance().getItemData()

        apiService.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val itemList: List<ItemModel>? = response.body()?.data
                    if (itemList != null) {
                        val adapter = ItemAdapter(this@MainActivity, itemList)
                        listView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                  t.printStackTrace()
            }
        })
    }
}
