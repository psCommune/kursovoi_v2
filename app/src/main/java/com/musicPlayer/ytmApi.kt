package com.musicPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.musicPlayer.databinding.ActivityYtmApiBinding
import org.json.JSONObject

class ytmApi : AppCompatActivity() {
    private lateinit var binding: ActivityYtmApiBinding
    //private val model: songApiViewModel by activityViewModels()

    companion object {
        val PLAYLIST_ID: String = "PLUsWL6PZZ1um2KOVqe7bcNEk-Txn5ACNt"
        val YOUTUBE_API_KEY: String = "AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYtmApiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mainObject = JSONObject("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLUsWL6PZZ1um2KOVqe7bcNEk-Txn5ACNt&key=AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc&fields=items(snippet(title,position,videoOwnerChannelTitle))")
        val list = parseSongs(mainObject)
    //val executorService: ExecutorService = Executors.newSingleThreadExecutor()
    //val objectInfo =  executorService.submit(Callable {
        //    httpsRequest("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLUsWL6PZZ1um2KOVqe7bcNEk-Txn5ACNt&key=AIzaSyCKLUO5xpWeCgdXa_lwWuSVBgq0MYkvQPc&fields=items(snippet(title,position,videoOwnerChannelTitle))")
        //}).get()
    }

    private fun parseSongs(mainObject: JSONObject): List<ApiSongModel>{
        val list = ArrayList<ApiSongModel>()
        val songsArray = mainObject.getJSONArray("items")
        for (i in 0 until songsArray.length()){
            val song = songsArray[i] as JSONObject
            val item = ApiSongModel(
                song.getJSONObject("snippet").getString("title"),
                song.getJSONObject("snippet").getString("position"),
                song.getJSONObject("snippet").getString("videoOwnerChannelTitle")
            )
            list.add(item)
        }
        return list
    }

//    private fun updateInfo(){
//        model.liveDataCurrent.observe(viewLifecycleOwner){
//            binding.testInfo.text = it.title
//            Picasso.get().load(it.imageUrl).into //library for download arts
//        }
//    }

//    @Throws(IOException::class)
//    fun httpsRequest(urlString: String): ApiSongModel {
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
//        val item = ApiSongModel(
//            audioInfo.getString("title"),
//            audioInfo.getString("position"),
//            audioInfo.getString("videoOwnerChannelTitle")
//        )
//        return item
//    }

//    @Throws(IOException::class)
//    fun httpsRequest(urlString: String): ApiSongModel {
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
//        val item = ApiSongModel(
//            mainObject.getString("title"),
//            mainObject.getString("position"),
//            mainObject.getString("videoOwnerChannelTitle")
//        )
//        return item
//    }
}