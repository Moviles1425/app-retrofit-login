package pe.edu.idat.app_retrofit_login.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pe.edu.idat.app_retrofit_login.db.entity.PersonaEntity

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertar(personaEntity: PersonaEntity)

    @Update
    fun actualizar(personaEntity: PersonaEntity)

    @Query("DELETE FROM persona")
    fun eliminarTodo()

    @Query("SELECT * FROM persona LIMIT 1")
    fun obtener(): LiveData<PersonaEntity>



}