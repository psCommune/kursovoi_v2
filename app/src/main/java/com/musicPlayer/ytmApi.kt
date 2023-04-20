package com.musicPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val PLAYLIST_ID: String = "PLUsWL6PZZ1uklUFkzKxUbxJG2otXfML5B"
        val YOUTUBE_API_KEY: String = "AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYtmApiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val executorService: ExecutorService = Executors.newSingleThreadExecutor()
        val objectInfo =  executorService.submit(Callable {
            httpsRequest("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLUsWL6PZZ1uklUFkzKxUbxJG2otXfML5B&key=AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc&fields=items(id,snippet(title,position,videoOwnerChannelTitle))")
        }).get()

        binding.apiText.text = objectInfo.title
    }

    @Throws(IOException::class)
    fun httpsRequest(urlString: String): ApiInfo {
        val url = URL(urlString)
        val connection = url.openConnection() as HttpsURLConnection
        connection.requestMethod = "GET"
        var data: Int = connection.inputStream.read()
        var str = ""
        while (data != -1) {
            str += data.toChar()
            data = connection.inputStream.read()
        }
        val mainObject = JSONObject(str)
        val item = ApiInfo(
            mainObject.getString("id"),
            mainObject.getString("title"),
            mainObject.getString("position"),
            mainObject.getString("videoOwnerChannelTitle")
        )
        return item
    }

}