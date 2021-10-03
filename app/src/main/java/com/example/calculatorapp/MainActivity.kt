package com.example.calculatorapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.Array as Array

class MainActivity : AppCompatActivity() {
    lateinit var b0:Button
    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var b3:Button
    lateinit var b4:Button
    lateinit var b5:Button
    lateinit var b6:Button
    lateinit var b7:Button
    lateinit var b8:Button
    lateinit var b9:Button
    lateinit var bdot:Button
    lateinit var badd:Button
    lateinit var bsub:Button
    lateinit var bmulti:Button
    lateinit var bdev:Button
    lateinit var bc:Button
    lateinit var bdel:Button
    lateinit var bassign:Button
    lateinit var bpOrn:Button
    lateinit var textView:TextView
    var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b0 = findViewById(R.id.b0)
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        b9 = findViewById(R.id.b9)
        bdot = findViewById(R.id.bdot)
        badd = findViewById(R.id.badd)
        bsub = findViewById(R.id.bsub)
        bmulti = findViewById(R.id.bmulti)
        bdev = findViewById(R.id.bdev)
        bc = findViewById(R.id.bc)
        bdel = findViewById(R.id.bdel)
        bassign = findViewById(R.id.bassign)
        bpOrn = findViewById(R.id.bpOrn)
        textView = findViewById(R.id.textView)

        b0.setOnClickListener {
            textView.text = textView.text.toString() + "0"
        }
        b1.setOnClickListener {
            textView.text = textView.text.toString() + "1"
        }
        b2.setOnClickListener {
            textView.text = textView.text.toString() + "2"
        }
        b3.setOnClickListener {
            textView.text = textView.text.toString() + "3"
        }
        b4.setOnClickListener {
            textView.text = textView.text.toString() + "4"
        }
        b5.setOnClickListener {
            textView.text = textView.text.toString() + "5"
        }
        b6.setOnClickListener {
            textView.text = textView.text.toString() + "6"
        }
        b7.setOnClickListener {
            textView.text = textView.text.toString() + "7"
        }
        b8.setOnClickListener {
            textView.text = textView.text.toString() + "8"
        }
        b9.setOnClickListener {
            textView.text = textView.text.toString() + "9"
        }

        bdot.setOnClickListener {
            textView.text = textView.text.toString() + "."
        }
        bdel.setOnClickListener {
            //delete last item
            if(textView.text.length!=-0)
            textView.text = textView.text.toString().subSequence(0,textView.text.length-1)
            //textView.text = textView.text.toString().drop(textView.text.length)
        }
        bc.setOnClickListener {
            textView.text = ""
        }
        bpOrn.setOnClickListener {
            //positive or negative
            if (op != "") {
                var input = textView.text.toString()
                var num = input.split("${op}").toTypedArray()
                textView.text = num[0] + op + (num[1].toInt() * -1)
            } else {
                textView.text = (textView.text.toString().toInt() * -1).toString()
            }

        }
        badd.setOnClickListener {
            op = "+"
            textView.text = textView.text.toString() + "+"
        }
        bsub.setOnClickListener {
            op = "-"
            textView.text = textView.text.toString() + "-"
        }
        bmulti.setOnClickListener {
            op = "*"
            textView.text = textView.text.toString() + "*"
        }
        bdev.setOnClickListener {
            op = "/"
            textView.text = textView.text.toString() + "/"
        }

        bassign.setOnClickListener {
            var input = textView.text.toString()
            when {
             input.contains('+') -> {
                 var num =  input.split("+").toTypedArray()
                 textView.text = add(num[0].toDouble(),num[1].toDouble())
             }
                input.contains('-') -> {
                    var num =  input.split("-").toTypedArray()
                    textView.text = sub(num[0].toDouble(),num[1].toDouble())
                }
                input.contains('*') -> {
                    var num =  input.split("*").toTypedArray()
                    textView.text = multi(num[0].toDouble(),num[1].toDouble())
                }
                input.contains('/') -> {
                    var num =  input.split("/").toTypedArray()
                    textView.text = dev(num[0].toDouble(),num[1].toDouble())
                }
            }
        }

    }

    fun sub (num1 : Double , num2 : Double) : String {
        return "${(num1-num2)}"
    }
    fun add (num1 : Double , num2 : Double) : String {
        return "${(num1+num2)}"
    }
    fun multi (num1 : Double , num2 : Double) : String {
        return "${(num1*num2)}"
    }
    fun dev (num1 : Double , num2 : Double) : String {
        if(num2==0.0){
            return "0"
        }
        return "${(num1/num2)}"
    }

}