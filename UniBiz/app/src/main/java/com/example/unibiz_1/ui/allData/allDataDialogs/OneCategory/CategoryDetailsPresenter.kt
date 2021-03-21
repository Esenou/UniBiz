package com.example.unibiz_1.ui.allData.allDataDialogs.OneCategory

import com.example.unibiz_1.StartApplication
import com.example.unibiz_1.model.*
import com.example.unibiz_1.ui.allData.allDataDialogs.CategoryContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryDetailsPresenter(val view: CategoryDetailsContract.View): CategoryDetailsContract.Presenter  {

    override fun setCategory(jwtResponse: JwtResponse, category: CategoryUpdate, id:Long?) {
        StartApplication.service.getUpdateCategory(jwtResponse.USERAUTH.token,jwtResponse.USERAUTH.userId,category,id).enqueue(
            object : Callback<Success> {
                override fun onResponse(call: Call<Success>, response: Response<Success>) {

                    if (response!!.isSuccessful && response != null) {
                        view.onSuccessful(response?.body()!!)
                    } else
                        view.onFailure()
                }

                override fun onFailure(call: Call<Success>, t: Throwable) {
                    t?.printStackTrace()
                }
            }
        )
    }
}