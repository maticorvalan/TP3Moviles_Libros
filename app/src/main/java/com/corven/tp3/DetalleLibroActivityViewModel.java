package com.corven.tp3;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.corven.tp3.modelo.Libro;
import java.util.ArrayList;
import java.util.List;

public class DetalleLibroActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Libro>> librosMutables = new MutableLiveData<>();
    private MutableLiveData<String> mensajeDeError = new MutableLiveData<>();
    private List<Libro> libros;

    public DetalleLibroActivityViewModel(@NonNull Application application) {
        super(application);
        libros = new ArrayList<>();
        libros.add(new Libro("Avatar", "D.K Publishing", "Una aventura en el espacio", "2009", R.drawable.avatar));
        libros.add(new Libro("Aliens", "Jhon Acurdi", "Libro de accion basada en aliens", "1986", R.drawable.aliens));
        libros.add(new Libro("Harry Potter", "J.K Rowling", "Magia en la vida", "1997", R.drawable.harry_potter));
        libros.add(new Libro("Soy Leyenda", "Richard Mattenson", "Apocalipsis post infeccion", "2003", R.drawable.soy_leyenda));
        librosMutables.setValue(libros);
    }

    public LiveData<List<Libro>> getLibrosMutables() {
        return librosMutables;
    }

    public LiveData<String> getMensajeDeError() {
        return mensajeDeError;
    }

    public void listadoLibros(String query){
        if(query != null && !query.isEmpty()){
            List<Libro> librosFiltrados = new ArrayList<>();
            for(Libro l : libros){
                if(l.getTitulo().toLowerCase().contains(query.toLowerCase())){
                    librosFiltrados.add(l);
                }
            }
            
            if(librosFiltrados.isEmpty()){
                mensajeDeError.setValue("No se encontró el libro: " + query);
                librosMutables.setValue(libros);
            } else {
                librosMutables.setValue(librosFiltrados);
            }
        } else {
            librosMutables.setValue(libros);
        }
    }
}
