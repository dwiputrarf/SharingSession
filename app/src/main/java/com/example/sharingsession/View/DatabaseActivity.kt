package com.example.sharingsession.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharingsession.Contract.ContractInterface
import com.example.sharingsession.Presenter.MainActivityPresenter
import com.example.sharingsession.R
import kotlinx.android.synthetic.main.activity_main.*

class DatabaseActivity : AppCompatActivity(), ContractInterface.View {

    private var presenter: MainActivityPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this)
    }

        override fun initView() {
            counterTextView.text = presenter?.getCounter()
            incrementBtn.setOnClickListener { presenter?.incrementalValue() }
        }

        override fun updateViewData() {
            counterTextView.text = presenter?.getCounter()
        }

//        val listener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//            btnTimePick.text = "$hourOfDay : $minute"
//        }
//        val timePicker = TimePickerDialog(this@DatabaseActivity, listener, 0, 0, false)
//        val listener2 = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
//            btnDatePick.text = "$dayOfMonth / $month / $year"
//        }
//        val datePicker = DatePickerDialog(this, listener2, 2019, 4, 5)
//
//
//        ibLauncher.setOnClickListener {
//            loginButtonClick(it)
//        }
//        btnTimePick.setOnClickListener {
//            timePicker.show()
//        }
//
//        btnDatePick.setOnClickListener {
//            datePicker.show()
//        }
//    }
//
//    fun loginButtonClick(view: View) {
//        val email: String = etEmail.text.toString()
//        val pass: String = etPass.text.toString()
//        val messege: String = email + pass
//        Log.d("LoginReq: ", messege)
//        var txGender: String
//
//        if (cbMale.isChecked == true) {
//            txGender = cbMale.text.toString()
//            cbFemale.isChecked = false
//        } else if (cbFemale.isChecked == true) {
//            txGender = cbFemale.text.toString()
//            cbMale.isChecked = false
//        }
//    }

}
