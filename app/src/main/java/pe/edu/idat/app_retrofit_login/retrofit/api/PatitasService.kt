package pe.edu.idat.app_retrofit_login.retrofit.api

import pe.edu.idat.app_retrofit_login.retrofit.request.LoginRequest
import pe.edu.idat.app_retrofit_login.retrofit.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PatitasService {

    @POST("login.php")
    fun loginPatitas(@Body loginRequest: LoginRequest) : Call<LoginResponse>
    //localhost:8080/libros?busqueda=dasdasdas&stock=10
    @GET("libros")
    fun getLibros(@Query("busqueda") busqueda:String,
                  @Query("stock") stock: Int) : LoginResponse
}