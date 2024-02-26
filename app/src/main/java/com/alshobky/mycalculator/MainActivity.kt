package com.alshobky.mycalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.alshobky.mycalculator.R.*


class MainActivity : AppCompatActivity() {
    lateinit var bu0:Button
    lateinit var bu1:Button
    lateinit var bu2:Button
    lateinit var bu3:Button
    lateinit var bu4:Button
    lateinit var bu5:Button
    lateinit var bu6:Button
    lateinit var bu7:Button
    lateinit var bu8:Button
    lateinit var bu9:Button
    lateinit var buDot:Button
    lateinit var buMin:Button
    lateinit var edShowName:EditText
    lateinit var budiv:Button
    lateinit var busub:Button
    lateinit var bumul:Button
    lateinit var busum:Button
    lateinit var bueql:Button
    lateinit var buac:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        bu0=findViewById(id.bu0)
        bu1=findViewById(id.bu1)
        bu2=findViewById(id.bu2)
        bu3=findViewById(id.bu3)
        bu4=findViewById(id.bu4)
        bu5=findViewById(id.bu5)
        bu6=findViewById(id.bu6)
        bu7=findViewById(id.bu7)
        bu8=findViewById(id.bu8)
        bu9=findViewById(id.bu9)
        buDot=findViewById(id.buDot)
        buMin=findViewById(id.buMin)
        budiv=findViewById(id.budiv)
        busub=findViewById(id.busub)
        busum=findViewById(id.busum)
        bumul=findViewById(id.bumul)
        bueql=findViewById(id.buEql)
        buac=findViewById(id.buAc)
        edShowName=findViewById(id.edShowName)
        edShowName.setText(""+edShowName.text)
    }

    // make function to select button and his number
    fun butSelecte(view: View){
        if(isNewOp){
            edShowName.setText("")
        }
        isNewOp=false
        var butSelect=view as Button

        var clikNum :String=edShowName.text.toString()

        when(butSelect.id){
            bu0.id-> {

                clikNum +="0"
            }
            bu1.id-> {
                clikNum +="1"
            }
            bu2.id-> {
                clikNum +="2"
            }
            bu3.id-> {
                clikNum+="3"
            }
            bu4.id-> {
                clikNum+="4"
            }
            bu5.id-> {
                clikNum+="5"
            }
            bu6.id-> {
                clikNum+="6"
            }
            bu7.id-> {
                clikNum+="7"
            }
            bu8.id-> {
                clikNum+="8"
            }
            bu9.id-> {
                clikNum+="9"
            }
            buDot.id-> {
                clikNum+="."
            }
            buMin.id-> {
                clikNum= "-" +clikNum
            }
            buac.id-> {
                edShowName.setText("")
                 isNewOp=true
            }
        }
        edShowName.setText(clikNum)
    }
    // make function to oparation
    var op="*"
    var oldNumber=""
    var isNewOp=true
    fun eventOp(view:View){
        var butSelect=view as Button
        when(butSelect.id) {
            budiv.id -> {
                op = "/"

            }
            bumul.id -> {
                op = "*"
            }
            busum.id -> {
                op = "+"

            }
            busub.id -> {
                op = "-"
            }
        }
        oldNumber=edShowName.text.toString()
        isNewOp=true
    }
    // عمل دالة التساوي
    fun eqlevent(view: View){
        var newNumber=edShowName.text.toString()
        var finalNumber :Double?=null
        when(op){
            "*"->{finalNumber=newNumber.toDouble()*oldNumber.toDouble()}
            "/"->{finalNumber=oldNumber.toDouble()/newNumber.toDouble()}
            "+"->{finalNumber=newNumber.toDouble()+oldNumber.toDouble()}
            "-"->{finalNumber=oldNumber.toDouble()-newNumber.toDouble()}
        }
        edShowName.setText(finalNumber.toString())
        isNewOp=true
    }
}