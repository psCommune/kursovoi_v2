package com.musicPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject
import java.io.IOException
import java.net.URL
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class ytmApi : AppCompatActivity() {

    companion object {
        val PLAYLIST_ID: String = "PLB03EA9545DD188C"
        val YOUTUBE_API_KEY: String = "AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc"
        val channelId: String = "UCBkNpeyvBO2TdPGVC_PsPUA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ytm_api)

//        val executorService: ExecutorService = Executors.newSingleThreadExecutor()
//        val objectMogeIfo =  executorService.submit(Callable {
//            httpsRequest("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=$PLAYLIST_ID&key=/$YOUTUBE_API_KEY")
//        }).get()
        //https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLB03EA9545DD188C3&key=AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc
    }

//    @Throws(IOException::class)
//    fun httpsRequest(urlString: String): MoreInfoForIp {
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
//        val item = MoreInfoForIp(
//            mainObject.getString("i")
//
//        )
//        return item
//    }

}