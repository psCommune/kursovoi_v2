//package com.musicPlayer
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface Dao {
//    @Insert
//    fun insertItem(item: PlaylistsDb)
//    @Query("SELECT * FROM LocalPlaylists")
//    fun getAllItems(): Flow<List<PlaylistsDb>>
//}