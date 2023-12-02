package com.example.mettrixcreate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mettrixcreate.adaptermattrix.AdapterMatrix
import com.example.mettrixcreate.adaptermattrix.HomeActivity
import com.example.mettrixcreate.databinding.ActivityMainBinding
import com.example.mettrixcreate.utils.Constants
import com.example.mettrixcreate.utils.showToast
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        mBinding.apply {
            btnSubmit.setOnClickListener {
                if (!etdNumber.text.toString().equals(""))
                { startActivity(Intent(this@MainActivity, HomeActivity::class.java).apply {
                          putExtra(Constants.POST_User_LIST, etdNumber.text.toString().toInt()) } )
                }else{
                    showToast("Please enter the number")
                }

            }

        }
    }
}