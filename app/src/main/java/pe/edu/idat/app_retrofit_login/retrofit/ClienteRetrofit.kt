package pe.edu.idat.app_retrofit_login.retrofit

import okhttp3.OkHttpClient
import pe.edu.idat.app_retrofit_login.retrofit.api.PatitasService
import pe.edu.idat.app_retrofit_login.util.Constantes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ClienteRetrofit {
    //Configuramos el tiempo de integración a la API REST
    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
    //Creamos el objeto Retrofit
    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(Constantes.URL_BASE_API)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //Enlazando el objeto retrofit con los recursos de la API Rest
    val retrofitPatitasServicio : PatitasService by lazy {
        buildRetrofit().create(PatitasService::class.java)
    }
}