package com.example.listcomposemvvm


import androidx.lifecycle.*
import kotlinx.coroutines.delay
import java.lang.IllegalStateException

class UserViewModel() : ViewModel() {

    private val _userList: MutableLiveData<List<User>> = MutableLiveData()
    val userList: LiveData<List<User>> = _userList

    fun setUserList(userList: List<User>){
        _userList.value = userList
    }
}

/*class UserViewModelFactory(private val repoImpl: RepoImpl) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repoImpl)
    }
}*/

/*class UserViewModelFactory(private val repo: Repo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}*/


/*
class ViewModelFactory (
    private val app: App
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass)
        {
            UserListViewModel::class.java ->{
                UserListViewModel(app.usersService)
            }
            UserDetailsViewModel::class.java->{
                UserDetailsViewModel(app.usersService)
            }
            else->{
                throw IllegalStateException("Unknown view model class")
            }
        }
        return viewModel as T
    }
}*/
