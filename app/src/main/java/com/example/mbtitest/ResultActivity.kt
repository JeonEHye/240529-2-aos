package com.example.mbtitest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val results=intent.getIntegerArrayListExtra("results")?: arrayListOf()

        val resultType= listOf(
            listOf("E","I"),
            listOf("N","S"),
            listOf("T","F"),
            listOf("J","P"),
        )

        var resultString=""
        for (i in results.indices){
            resultString+=resultType[i][results[i]-1]
        }

        val tv_resValue:TextView=findViewById(R.id.tv_resValue)
        tv_resValue.text=resultString

        val iv_ResImg:ImageView=findViewById(R.id.iv_resImg)
        val imageResource=resources.getIdentifier("ic_${resultString.toLowerCase(Locale.ROOT)}","drawable",packageName)

        iv_ResImg.setImageResource(imageResource)

        val btn_retry:Button=findViewById(R.id.btn_res_retry)
        btn_retry.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}
