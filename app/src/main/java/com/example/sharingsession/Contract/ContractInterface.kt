package com.example.sharingsession.Contract

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun incrementalValue()
        fun getCounter(): String
    }

    interface Model {
        fun getCounter(): Int
        fun incrementCounter()
    }
}