package pe.edu.idat.app_retrofit_login.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import pe.edu.idat.app_retrofit_login.R
import pe.edu.idat.app_retrofit_login.databinding.ActivityHomeBinding
import pe.edu.idat.app_retrofit_login.db.PersonaRoomDatabase

class HomeActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    var id : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btncerrarsesion.setOnClickListener(this)
        obtenerDatosPersona()
    }
    private fun obtenerDatosPersona(){
        val db = PersonaRoomDatabase.getDatabase(applicationContext)
        db.personaDao().obtener().observe(this, Observer{
            persona ->
            if(persona != null){
                binding.tvid.text = persona.id.toString()
                //id = persona.id
                binding.tvnombres.text = "${persona.nombres} ${persona.apellidos}"
            }
        })
    }

    override fun onClick(p0: View?) {

    }
}