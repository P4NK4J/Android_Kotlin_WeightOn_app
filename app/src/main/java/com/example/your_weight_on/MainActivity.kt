package com.example.your_weight_on

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    val marsGravity = 0.38
    val venusGravity = 0.91
    val jupiterGravity = 2.34

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // get our button
        ShowWeight.setOnClickListener {

            //show our calculations to get weight on mars
            //var result = calculateWeight(weight.toString().toDouble())
            //resultId.text = "You Weigh " + result.toString() +  "Kg on Mars.....you are not heavy..!! you are just on a wrong planet...!!"
        }
        marsCheckBox.setOnClickListener(this) // registering our click listener inside main activity where interface of same is used
        venusCheckBox.setOnClickListener(this)
        jupiterCheckBox.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
         v as CheckBox                                              //typecasting view type into checkbox type
        var ischecked:  Boolean = v.isChecked                      //boolean variable to ensure what is checked
        var weight = enterWeightId.text

        when(v.id){
            R.id.marsCheckBox -> if(ischecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
                                    {
                                        calculateWeight(weight.toString().toDouble(), v)
                                        venusCheckBox.isChecked = false
                                        jupiterCheckBox.isChecked = false
                                    }
            R.id.venusCheckBox -> if(ischecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
                                    {
                                        calculateWeight(weight.toString().toDouble(), v)
                                        jupiterCheckBox.isChecked = false
                                        marsCheckBox.isChecked = false
                                    }
            R.id.jupiterCheckBox -> if(ischecked && !TextUtils.isEmpty(enterWeightId.text.toString()))
                                    {
                                        calculateWeight(weight.toString().toDouble(), v)
                                        venusCheckBox.isChecked = false
                                        marsCheckBox.isChecked = false
                                    }
        }


    }
    fun calculateWeight(userweight: Double, checkBox: CheckBox){
        var result: Double?
        when(checkBox.id) {
            R.id.marsCheckBox -> {
                        result = userweight * marsGravity
                        resultId.text = "Weight is " + result + " Kg on Mars.....You are not heavy, but are on a WRONG planet...!!"
            }

            R.id.venusCheckBox -> {
                result = userweight * venusGravity
                resultId.text = "Weight is " + result + " Kg on Venus.....You are not heavy, but are on a WRONG planet...!!"
            }
            R.id.jupiterCheckBox -> {
                result = userweight * jupiterGravity
                resultId.text = "Weight is " + result + " Kg on Jupiter.....You are not heavy, but are on a WRONG planet...!!"
            }
            else -> result = 00.00
        }
    }
}
