package com.bignerdranch.android.autoprom.ui.home

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.autoprom.R
import com.bignerdranch.android.autoprom.ui.Models.AdsModel
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.layoutManager = LinearLayoutManager(null)

        GetAdsTask(recyclerView).execute();
        return view
//        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
    }

    class GetAdsTask(recyclerView: RecyclerView) : AsyncTask<Unit, Unit, String>() {
        val innerRecyclerView: RecyclerView = recyclerView;
        override fun doInBackground(vararg params: Unit?): String? {
            val url = URL("https://autoprom.tj/api/get")
            val httpClient = url.openConnection() as HttpURLConnection
            if (httpClient.responseCode == HttpURLConnection.HTTP_OK) {
                try {
                    val stream = BufferedInputStream(httpClient.inputStream)
                    val data: String = readStream(inputStream = stream)
                    return data
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    httpClient.disconnect()
                }
            } else {
                println("ERROR ${httpClient.responseCode}")
            }
            return null
        }

        fun readStream(inputStream: BufferedInputStream): String {
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            bufferedReader.forEachLine { stringBuilder.append(it) }
            return stringBuilder.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result);

            val adsModels: MutableList<AdsModel> = ArrayList()
            val jsonArray: JSONArray = JSONArray(result);

            for (i in 0 until jsonArray.length()) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(i);
                adsModels.add(
                    AdsModel(
                        jsonObject.getString("name"),
                        jsonObject.getString("price"),
                        jsonObject.getString("color"),
                        jsonObject.getInt("year"),
                        jsonObject.getString("city"),
                        jsonObject.getString("date")
                    )
                );
            }

            innerRecyclerView.adapter = AdsAdapter(adsModels);
        }
    }

}