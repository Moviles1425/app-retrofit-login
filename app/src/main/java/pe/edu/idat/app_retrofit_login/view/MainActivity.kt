package pe.edu.idat.app_retrofit_login.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.idat.app_retrofit_login.R
import pe.edu.idat.app_retrofit_login.databinding.ActivityMainBinding
import pe.edu.idat.app_retrofit_login.retrofit.ClienteRetrofit
import pe.edu.idat.app_retrofit_login.retrofit.request.LoginRequest
import pe.edu.idat.app_retrofit_login.retrofit.response.LoginResponse
import pe.edu.idat.app_retrofit_login.util.AppMensaje
import pe.edu.idat.app_retrofit_login.util.TipoMensaje
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnlogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        login()
    }
    private fun login(){
        if(binding.etusuario.text.toString().trim().isEmpty()){
            binding.etusuario.isFocusableInTouchMode = true
            binding.etusuario.requestFocus()
            AppMensaje.mensajeSnackBar(binding.root, "Ingrese su usuario", TipoMensaje.ERROR)
        } else if(binding.etpassword.text.toString().trim().isEmpty()){
            binding.etpassword.isFocusableInTouchMode = true
            binding.etpassword.requestFocus()
            AppMensaje.mensajeSnackBar(binding.root, "Ingrese su password", TipoMensaje.ERROR)
        } else{
            val request: Call<LoginResponse> = ClienteRetrofit.retrofitPatitasServicio.loginPatitas(
                LoginRequest(binding.etusuario.text.toString(), binding.etpassword.text.toString())
            )
            request.enqueue(object: Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse?>,
                    response: Response<LoginResponse?>
                ) {
                    val loginResponse = response.body()!!
                    if(loginResponse.rpta){
                        startActivity(Intent(applicationContext, HomeActivity::class.java))
                    }else{
                        AppMensaje.mensajeSnackBar(binding.root,
                            loginResponse.mensaje, TipoMensaje.ERROR)
                    }
                }
                override fun onFailure(
                    call: Call<LoginResponse?>,
                    t: Throwable
                ) {
                    Log.e("ErrorAPI", t.message.toString())
                }

            })
        }
    }
}