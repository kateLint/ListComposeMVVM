package com.example.listcomposemvvm

class RepoImpl(private val dataSource: MainDataSource):Repo {
    override fun getUserList(): Result<List<User>> = dataSource.dummyUserList
}