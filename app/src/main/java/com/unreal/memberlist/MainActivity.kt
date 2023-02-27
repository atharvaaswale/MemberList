package com.unreal.memberlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val call: Call<List<UserListResItem>> = RetrofitClient.instance.getList()

            call!!.enqueue(object : Callback<List<UserListResItem>>{
                /*override fun onResponse(call: Call<List<UserListResItem>>, response: Response<UserListResItem?>) {
                    if (response.isSuccessful){
                        tvName.visibility = View.VISIBLE
                        image.visibility = View.VISIBLE
                        response.body().let {
                            tvName.text = "AUTHOR NAME\n${it!!.UserListResItem!![1]!!.author}"
                            Glide.with(applicationContext).load(it.UserListResItem!![1]!!.url).into(image)
                        }
                    }
                }

                override fun onFailure(call: Call<List<UserListResItem>>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed: $t", Toast.LENGTH_SHORT).show()
                }*/


                override fun onResponse(
                    call: Call<List<UserListResItem>>,
                    response: Response<List<UserListResItem>>
                ) {
                    if (response.isSuccessful){
                        tvName.visibility = View.VISIBLE
                        image.visibility = View.VISIBLE
                        response.body().let {
                            tvName.text = "AUTHOR NAME\n${it!![1]!!.author}"
                            Glide.with(applicationContext).load(it!![1]!!.download_url).into(image)
                        }
                    }
                }

                override fun onFailure(call: Call<List<UserListResItem>>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed: $t", Toast.LENGTH_SHORT).show()
                }

            })

            //RetrofitClient.PicsumApi
        }
    }
}
