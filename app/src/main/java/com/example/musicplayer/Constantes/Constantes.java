package com.example.musicplayer.Constantes;

/**
 *
 * Descripcion: Clase con las constante que representran los campos o registro de las tablas de la base de datos
 *
 */
public class Constantes {

    //Constantes campos tabla USUARIOS (7)

    public static final String NOMBRE_TABLA_USUARIO_SISTEMA = "Usuario";

    public static final String CAMPO_USUARIO_NOMBRE_USUARIO = "NombreUsuario";
    public static final String CAMPO_USUARIO_NOMBRE = "Nombre";
    public static final String CAMPO_USUSARIO_PASSWORD = "Password";
    public static final String CAMPO_USUARIO_TELEFONO = "Telefono";
    public static final String CAMPO_USUARIO_CORREO = "CorreoElectronico";
    public static final String CAMPO_USUARIO_FECHA_NACIMIENTO = "FechaNacimiento";
    public static final String CAMPO_USUARIO_NOMBRE_IMAGEN = "ImagenPerfil";

    //Constantes campos tabla Imagen (2)

    public static final String NOMBRE_TABLA_IMAGEN = "Imagen";

    public static final String CAMPO_PERFIL_NOMBRE_IMAGEN = "NombreImagen";
    public static final String CAMPO_PERFIL_IMAGEN = "ContenidoImagen";


    //Constantes TABLAS
    public static final String CREAR_TABLA_USUARIO_SISTEMA =
            "CREATE TABLE "+NOMBRE_TABLA_USUARIO_SISTEMA+" ("+CAMPO_USUARIO_NOMBRE_USUARIO+" TEXT, "+CAMPO_USUARIO_NOMBRE+" TEXT, "+CAMPO_USUSARIO_PASSWORD+
                    " TEXT, "+CAMPO_USUARIO_TELEFONO+" TEXT, "+CAMPO_USUARIO_CORREO+" TEXT, "+CAMPO_USUARIO_FECHA_NACIMIENTO+" TEXT, "+
                    CAMPO_USUARIO_NOMBRE_IMAGEN+" BLOB)";

    public static final String CREAR_TABLA_IMAGEN =
            "CREATE TABLE "+NOMBRE_TABLA_IMAGEN+" ("+CAMPO_PERFIL_NOMBRE_IMAGEN+" TEXT, "+CAMPO_PERFIL_IMAGEN+" BLOB)";

}
