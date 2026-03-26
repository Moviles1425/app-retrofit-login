package pe.edu.idat.app_retrofit_login.retrofit.response

data class LoginResponse(
    var rpta: Boolean,
    var idpersona:String,
    var nombres:String,
    var apellidos:String,
    var email: String,
    var celular:String,
    var usuario:String,
    var mensaje:String
)
