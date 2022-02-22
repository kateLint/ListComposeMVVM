package com.example.listcomposemvvm

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue


@Composable
private fun UserRow(user: User, onUserClick:(User) ->Unit){
    Row(modifier = Modifier
        .clickable(onClick = { onUserClick(user) })
        .fillMaxWidth()
        .padding(8.dp)) {
        val imageModifier = Modifier
            .size(46.dp)
            .clip(shape = CircleShape)
        val image = painterResource(id = R.drawable.ic_launcher_foreground)

        Image(image,"",modifier = imageModifier,contentScale = ContentScale.Crop)

        Column(modifier = Modifier.padding(start = 8.dp), verticalArrangement = Arrangement.Center) {
            Text(text = user.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = user.bio,style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Composable
private fun UserList(userList:List<User>){
    val context = LocalContext.current

    LazyColumn(modifier = Modifier.fillMaxHeight()){
        items(items = userList){ user->
            UserRow(user = user, onUserClick = {
                Toast.makeText(
                    context,"You clicked ${user.name}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        }
    }
    Divider()
}

@Composable
fun UserScreen(userViewModel: UserViewModel) {
   val currentUser =  userViewModel.userList
    val items: List<User> by userViewModel.userList.observeAsState(listOf())//userViewModel.userList.observeAsState(mutableListOf<User>())
    UserList(userList = items)
}