package com.example.sharingsession.Presenter

import com.example.sharingsession.Contract.ContractInterface
import com.example.sharingsession.Model.MainActivityModel

class MainActivityPresenter( _view : ContractInterface.View) : ContractInterface.Presenter {

    private var view : ContractInterface.View = _view
    private var model : ContractInterface.Model = MainActivityModel()

    init {
//        view.initView()
    }

    override fun incrementalValue() {
        model.incrementCounter()
        view.updateViewData()
    }

    override fun getCounter() = model.getCounter().toString()

}