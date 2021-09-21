package com.test.rahmasameh

import android.util.Log
import com.test.rahmasameh.mvvm.model.PageDTO
import com.test.rahmasameh.pure.network.ResteasyClient
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun ResteasyClient() {
        val hashMap = HashMap<String, String>()
        hashMap["page"] = "1"
        ResteasyClient.getInstance().appService.tPage(hashMap).enqueue(object : Callback<PageDTO?> {
            override fun onResponse(call: Call<PageDTO?>, response: Response<PageDTO?>) {
                if (response.body() != null) {
                    val data= response.body()!!.data
                    assertNull(data)
                    assertEquals(data[0],"George")
                    assertEquals(data.size,6)
                 }
            }

            override fun onFailure(call: Call<PageDTO?>, t: Throwable) {}
        })

    }
}