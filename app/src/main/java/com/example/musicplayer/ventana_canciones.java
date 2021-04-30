package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.example.musicplayer.Adaptadores.AdaptadorListaCancion;
import com.example.musicplayer.Dominio.Cancion;
import com.example.musicplayer.Persistencia.AlbumDAO;
import com.example.musicplayer.Persistencia.CancionDAO;

import java.util.ArrayList;

public class ventana_canciones extends AppCompatActivity {

    private ArrayList<Cancion> canciones;
    private RecyclerView lstCanciones;
    private AdaptadorListaCancion adaptador_canciones;

    private String identificador_album;
    private Toast notification;

    private CancionDAO gestor_cancion = new CancionDAO();
    private AlbumDAO gestor_album = new AlbumDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_canciones);

        Bundle bundle = getIntent().getExtras();
        this.identificador_album = bundle.getString("identificador_album");

        //IMPORTANTE
        /**
        Log.d("Debug_Excepcion", "INTEGER"+R.raw.avicii);

        String codigo = gestor_cancion.buscarDatosCancion(ventana_canciones.this, "111","AudioCancion");
        int codigo_bueno = Integer.parseInt(codigo);
        MediaPlayer mp = MediaPlayer.create(this, codigo_bueno);
        mp.start();
            */
        /**IMPORTANTE
         *
        MediaPlayer mp = MediaPlayer.create(this, R.raw.avicii);
        mp.start();

        */

        // Obtenemos una referencia a la lista grafica
        lstCanciones = findViewById(R.id.lstPlayList);

        // Crear la lista de contactos y anadir algunos datos de prueba
        canciones = new ArrayList<Cancion>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        lstCanciones.setLayoutManager(mLayoutManager);

        adaptador_canciones = new AdaptadorListaCancion(canciones);
        lstCanciones.setAdapter(adaptador_canciones);

        lstCanciones.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // Metodo que rellena el array con datos de prueba
        rellenarDatos();
    }

    private void rellenarDatos(){

        int max = gestor_cancion.getProfilesCount(ventana_canciones.this);

        if(this.identificador_album.equals("")){

            if(max != 0){

                for(int i = 1; i<= max; i++){

                    String id_cancion = i+"";

                    String parametro_id_album = gestor_cancion.buscarDatosCancion(ventana_canciones.this, id_cancion,
                            "IdAlbumCancion");

                    String parametro_id_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, id_cancion,
                            "IdArtistaCancion");

                    String parametro_nombre_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, id_cancion,
                            "NombreCancion");

                    String parametro_duracion_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, id_cancion,
                            "DuracioCancion");

                    String parametro_audio_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, id_cancion,
                            "AudioCancion");

                    Bitmap bitmap = gestor_cancion.buscarImagenCancion(ventana_canciones.this, id_cancion,
                            "ImagenCancion");

                    canciones.add(new Cancion(id_cancion, parametro_id_album, parametro_id_cancion, parametro_nombre_cancion,
                            parametro_duracion_cancion, parametro_audio_cancion, bitmap));

                }
            }
            else{
                canciones.add(new Cancion("No disponible","No disponible", "No disponible",
                        "No disponible","No disponible","No disponible",
                        null));
            }
        }

        else{

            notification = Toast.makeText(this, "Album seleccionado: "
                        + gestor_album.buscarDatosArtista(ventana_canciones.this, this.identificador_album,
                        "NombreAlbum"), Toast.LENGTH_LONG);

            notification.show();

            String id_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, identificador_album,
                        "IdCancion");

            int c = gestor_cancion.getNumeroCanciones(ventana_canciones.this, identificador_album);

            if(c != 0){

                String [] lista_id = gestor_cancion.getListaCanciones(ventana_canciones.this, identificador_album, c);

                //if lista_id !null

                for(int i = 0; i< lista_id.length; i++){

                    String parametro_id_album = gestor_cancion.buscarDatosCancion(ventana_canciones.this, lista_id[i],
                            "IdAlbumCancion");

                    String parametro_id_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, lista_id[i],
                            "IdArtistaCancion");

                    String parametro_nombre_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, lista_id[i],
                            "NombreCancion");

                    String parametro_duracion_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, lista_id[i],
                            "DuracioCancion");

                    String parametro_audio_cancion = gestor_cancion.buscarDatosCancion(ventana_canciones.this, lista_id[i],
                            "AudioCancion");

                    Bitmap bitmap = gestor_cancion.buscarImagenCancion(ventana_canciones.this, lista_id[i],
                            "ImagenCancion");

                    canciones.add(new Cancion(lista_id[i], parametro_id_album, parametro_id_cancion, parametro_nombre_cancion,
                            parametro_duracion_cancion, parametro_audio_cancion, bitmap));

                }

            }
            else{
                canciones.add(new Cancion("No disponible","No disponible", "No disponible",
                        "No disponible","No disponible","No disponible",
                        null));
            }

        }

    }

}
