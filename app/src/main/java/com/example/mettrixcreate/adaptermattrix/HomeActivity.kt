package com.example.mettrixcreate.adaptermattrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mettrixcreate.MatrixResponse
import com.example.mettrixcreate.R
import com.example.mettrixcreate.databinding.ActivityHomeBinding
import com.example.mettrixcreate.utils.Constants
import com.example.mettrixcreate.utils.showToast
import com.google.gson.Gson

class HomeActivity : AppCompatActivity() {
    val mBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private var matrixResponse: MatrixResponse? = null
    var arrList = arrayListOf<MatrixResponse>()
    var number:Int=0
    var numberCount:Int=0
    private val adapterMatrix by lazy {
        AdapterMatrix { headerPosition, teamPosition ->
            var clickData=arrList[headerPosition].numberMatrix
            numberCount += clickData
           showToast(numberCount.toString())


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        mBinding.apply {
        intent.extras?.let {
            number=it.getInt(Constants.POST_User_LIST)
            val respon = it.getInt(Constants.POST_User_LIST) * it.getInt(Constants.POST_User_LIST)
            for (i in 1..respon) {
                arrList.add(MatrixResponse(i))

            }
            adapterMatrix.setData(arrList)
        }


                rvMatrix.apply {
                    layoutManager = GridLayoutManager(applicationContext,number)
                    adapter = adapterMatrix
                }
        }
    }
}