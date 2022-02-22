package com.example.listcomposemvvm

interface Repo {
    fun getUserList(): Result<List<User>>
}