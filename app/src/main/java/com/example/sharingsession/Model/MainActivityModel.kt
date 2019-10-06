package com.example.sharingsession.Model

import com.example.sharingsession.Contract.ContractInterface

class MainActivityModel: ContractInterface.Model {

    private var mCounter = 0

    override fun getCounter() = mCounter
    override fun incrementCounter() {
        mCounter++
    }
}