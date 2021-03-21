package com.example.unibiz_1.ui.allData.allDataDialogs.OneCategory

import com.example.unibiz_1.model.*

interface CategoryDetailsContract {
    interface View{
        fun onSuccessful(success: Success)
        fun onFailure()
    }
    interface Presenter{
        fun setCategory(jwtResponse: JwtResponse, category: CategoryUpdate, id:Long?)
    }
}