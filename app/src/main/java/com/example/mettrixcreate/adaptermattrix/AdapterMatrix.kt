package com.example.mettrixcreate.adaptermattrix

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mettrixcreate.MatrixResponse
import com.example.mettrixcreate.databinding.RowMatrixBinding

class AdapterMatrix(private val onClick: (headerPosition: Int, teamPosition: Int) -> Unit) : RecyclerView.Adapter<AdapterMatrix.MatrixViewHolder>() {

    private var postLikeList = listOf<MatrixResponse>()
    private var selectedItemPosition: Int = 0
    inner class MatrixViewHolder(val mBinding: RowMatrixBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatrixViewHolder = MatrixViewHolder(RowMatrixBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MatrixViewHolder, position: Int) {
        holder.mBinding.apply {
            val matrixResponse = postLikeList[position]
            postLikeList[position].apply {
                tvNumber.text=matrixResponse.numberMatrix.toString()
            }
            root.setOnClickListener {
                onClick(position, -1)
                selectedItemPosition =position
                if (selectedItemPosition==position) {
                    carBackGround.setBackgroundColor(Color.parseColor("#FF7A33"))
                }else{
                    carBackGround.setBackgroundColor(Color.parseColor("#33FF33"))

                }
            }
        }
    }

    override fun getItemCount(): Int = postLikeList.size

    fun setData(followingList: List<MatrixResponse>) {
        this.postLikeList = followingList
        notifyDataSetChanged()
    }
}