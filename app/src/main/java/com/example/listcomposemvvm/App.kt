package com.example.listcomposemvvm

import android.app.Application

class App: Application() {

    val users = MainDataSource()
}