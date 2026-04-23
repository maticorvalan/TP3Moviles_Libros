package com.corven.tp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.corven.tp3.databinding.ItemBinding;
import com.corven.tp3.modelo.Libro;

import java.util.List;

public class LibroAdapter extends ArrayAdapter<Libro> {

    private List<Libro> libros;
    private LayoutInflater inflater;
    private Context context;
    private int itemMostrar;

    public LibroAdapter(@NonNull Context context, int resource, @NonNull List<Libro> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.libros = objects;
        this.inflater = inflater;
        this.context = context;
        this.itemMostrar = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ItemBinding binding;
        if (item == null) {
            binding = ItemBinding.inflate(inflater, parent, false);
            item = binding.getRoot();
            item.setTag(binding);
        } else {
            binding = (ItemBinding) item.getTag();
        }
        Libro libro = libros.get(position);
        binding.tvTitulo.setText(libro.getTitulo());
        binding.tvAutor.setText(libro.getAutor());
        binding.tvAO.setText(libro.getAño());
        binding.tvDescripcion.setText(libro.getDescripcion());
        binding.imagen.setImageResource(libro.getImagen());
        return item;
    }
}
