package com.musicPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.core.view.isVisible
import com.google.gson.JsonObject
import com.musicPlayer.databinding.ActivityYtmApiBinding
import org.json.JSONObject
import java.io.IOException
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class ytmApi : AppCompatActivity() {
    private lateinit var binding: ActivityYtmApiBinding

    companion object {
        val PLAYLIST_ID: String = "PLUsWL6PZZ1um2KOVqe7bcNEk-Txn5ACNt"
        val YOUTUBE_API_KEY: String = "AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYtmApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val executorService: ExecutorService = Executors.newSingleThreadExecutor()
        val mainObject = JSONObject("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLUsWL6PZZ1um2KOVqe7bcNEk-Txn5ACNt&key=AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc&fields=items(snippet(title,position,videoOwnerChannelTitle))")
        val list = parseSongs(mainObject)

    //val objectInfo =  executorService.submit(Callable {
        //    httpsRequest("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLUsWL6PZZ1um2KOVqe7bcNEk-Txn5ACNt&key=AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc&fields=items(snippet(title,position,videoOwnerChannelTitle))")
        //}).get()
    }

    private fun parseSongs(mainObject: JSONObject): List<ApiInfo>{
        val list = ArrayList<ApiInfo>()
        val songsArray = mainObject.getJSONArray("items")
        for (i in 0 until songsArray.length()){
            val song = songsArray[i] as JSONObject
            val item = ApiInfo(
                song.getJSONObject("snippet").getString("title"),
                song.getJSONObject("snippet").getString("position"),
                song.getJSONObject("snippet").getString("videoOwnerChannelTitle")
            )
            list.add(item)
        }
        return list
    }

//    @Throws(IOException::class)
//    fun httpsRequest(urlString: String): ApiInfo {
//        val url = URL(urlString)
//        val connection = url.openConnection() as HttpsURLConnection
//        connection.requestMethod = "GET"
//        var data: Int = connection.inputStream.read()
//        var str = ""
//        while (data != -1) {
//            str += data.toChar()
//            data = connection.inputStream.read()
//        }
//        var jsonResponse = JSONObject(str)
//        var jsonArray = jsonResponse.getJSONArray("items");
//        var audioInfo = jsonArray.getJSONObject(0)
//        val item = ApiInfo(
//            audioInfo.getString("title"),
//            audioInfo.getString("position"),
//            audioInfo.getString("videoOwnerChannelTitle")
//        )
//        return item
//    }

//    @Throws(IOException::class)
//    fun httpsRequest(urlString: String): ApiInfo {
//        val url = URL(urlString)
//        val connection = url.openConnection() as HttpsURLConnection
//        connection.requestMethod = "GET"
//        var data: Int = connection.inputStream.read()
//        var str = ""
//        while (data != -1) {
//            str += data.toChar()
//            data = connection.inputStream.read()
//        }
//        val mainObject = JSONObject(str)
//        val item = ApiInfo(
//            mainObject.getString("title"),
//            mainObject.getString("position"),
//            mainObject.getString("videoOwnerChannelTitle")
//        )
//        return item
//    }
}