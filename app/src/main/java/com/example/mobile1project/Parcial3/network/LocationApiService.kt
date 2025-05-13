import com.example.mobile1project.Parcial3.model.Location

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.collections.List

interface LocationApiService {
    @GET("locations")
    suspend fun getLocations(): List<Location>

    companion object {
        private const val BASE_URL = "https://eleventenbackend.onrender.com/api/"

        fun create(): LocationApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LocationApiService::class.java)
        }
    }
}
