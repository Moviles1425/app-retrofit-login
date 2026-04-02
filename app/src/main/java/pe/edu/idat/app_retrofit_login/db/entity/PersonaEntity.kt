package pe.edu.idat.app_retrofit_login.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persona")
data class PersonaEntity(
    @PrimaryKey
    var id: Int,
    var nombres: String,
    var apellidos: String,
    var email: String,
    var usuario: String,
    var celular: String,
)
