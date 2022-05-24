package com.example.reposearchbystars

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.reposearchbystars.data.remote.RetrofitApi
import com.example.reposearchbystars.data.repository.RepoRepositoryImpl
import com.example.reposearchbystars.domain.repository.RepoRepository
import com.example.reposearchbystars.util.MockResponseFileReader
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@RunWith(JUnit4::class)
class RetrofitApiTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    //fake server to test api
    private val server = MockWebServer()
    private lateinit var repository: RepoRepositoryImpl
    private lateinit var mockedResponse: String

    private val gson = GsonBuilder()
                          .setLenient()
                          .create()

    @Before
    fun init() {

        server.start()

        var BASE_URL = server.url("/").toString()

        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(RetrofitApi::class.java)

        repository = RepoRepositoryImpl(service)
    }

    @Test
    fun testApiSuccess() {

        //read local json file
        mockedResponse = MockResponseFileReader("api_response.json").content

        //fake server api call
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )

        //getting data from fake repository
        val response = runBlocking { repository.getTopRepos("") }


        //converting list to json data
        val json = gson.toJson(response)


        //converting json to string
        val resultResponse = JsonParser.parseString(json)

        //converting json to string
        val expectedResponse = JsonParser.parseString(mockedResponse)


        //checking if response is not null
        Assert.assertNotNull(response)
        //check if response is same as expected
        //what is expected response, its a sample data we have amd we are expecting api response should match to this data
        //so we will verify by comparing sample data with api response data
        Assert.assertTrue(resultResponse.equals(expectedResponse))
    }




    @After
    fun tearDown() {
        server.shutdown()
    }
}