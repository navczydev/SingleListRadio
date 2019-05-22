package com.example.singlelistradio

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.widget.FrameLayout
import android.widget.RadioButton
import kotlinx.android.synthetic.main.dyanmic_radio_group.*
import android.widget.LinearLayout
import android.R.attr.checked






class DynamicRadioGroup: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dyanmic_radio_group)
        val member1 = RadioButton(this)
        val member2 = RadioButton(this)
        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48F, resources.displayMetrics).toInt()
        var memberNames = listOf("Nav","Adam","Marry","Skander","Alek","Cheryl","Bouchra")
        memberNames= memberNames.sortedWith(Comparator{ a, b ->
            when {
                a > b -> 1
                a < b -> -1
                else -> 0
            }
        })
       // val textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16F, resources.displayMetrics).toInt()
        for(i in memberNames.indices){
            val button = RadioButton(this)
            //button.height = px
            val lp = LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,px)
            //button.width = FrameLayout.LayoutParams.WRAP_CONTENT
            button.layoutParams = lp
            button.typeface = Typeface.create(Typeface.SANS_SERIF,Typeface.NORMAL)
            button.text = memberNames[i]
            button.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
            button.textSize = 16F
            button.id = 1 + i
            button.setPadding(32,0,0,0)
            rg_member_list.addView(button)
        }

        rg_member_list.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                for (i in 0 until rg_service.childCount) {
                    (rg_service.getChildAt(i) as RadioButton).isEnabled = true
                }
            }


        }
//        member1.height = px
//        member1.typeface = Typeface.create(Typeface.SANS_SERIF,Typeface.NORMAL)
//        member1.text = getString(R.string.member_name)
//        member1.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
//        member1.textSize = 16F
//        member1.id = 1 + 1000
//        member1.setPadding(32,0,0,0)
        //member1.sty


//        member2.text = getString(R.string.member2_name)
//        member2.id = 2 + 1000
//        member2.height = px
//        //member2.textSize = textSize.toFloat()
//        member2.setTextSize(TypedValue.COMPLEX_UNIT_SP,16F)
//        member2.setTextColor(ContextCompat.getColor(this,R.color.colorAccent))
//        member2.setPadding(32,0,0,0)
//
//        members_list.addView(member1)
//        members_list.addView(member2)

        if(rg_member_list.childCount==1){
            rg_member_list.check(rg_member_list.getChildAt(0).id)
        }
    }
}