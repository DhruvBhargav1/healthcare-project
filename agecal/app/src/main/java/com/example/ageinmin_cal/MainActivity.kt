package com.example.ageinmin_cal

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
     private var tvSelectDate : TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//create the varisble btndatapicker to show the button in the code to perform the task in the button
        val btnDatapicker: Button = findViewById(R.id.btnDatepicker)
        tvSelectDate=findViewById(R.id.tvSelectDate)
btnDatapicker.setOnClickListener{view->view
    clickdatepicker()

    }
    }
//creating a function
fun clickdatepicker(){
//create a object mycalendar
    var mycalendar=Calendar.getInstance()
    var year=mycalendar.get(Calendar.YEAR)
    var month=mycalendar.get(Calendar.MONTH)
    var day=mycalendar.get(Calendar.DAY_OF_MONTH)
//datepickerdialog here to show  calendar and select the date
    DatePickerDialog(this,
        {view,selectedyear,selectedmonth,selecteddayofmonth ->
//pop up the text written in text or to check the button is working
            Toast.makeText(this,
                "year is $selectedyear and month is ${selectedmonth+1},day of month was $selecteddayofmonth", Toast.LENGTH_SHORT).show()


            val selectedDate = "$selecteddayofmonth/${selectedmonth+1}/$selectedyear"
             tvSelectDate?.setText(selectedDate)

        },
        year,
        month,
        day
    ).show()
}
}