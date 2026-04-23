package com.corven.tp3;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.corven.tp3.databinding.ActivityDetalleLibroBinding;
import com.corven.tp3.modelo.Libro;
import java.util.List;

public class DetalleLibroActivity extends AppCompatActivity {

    private DetalleLibroActivityViewModel vm;
    private ActivityDetalleLibroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleLibroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleLibroActivityViewModel.class);
        String query = getIntent().getStringExtra("libro");
        vm.listadoLibros(query);
        vm.getLibrosMutables().observe(this, new Observer<List<Libro>>() {
            @Override
            public void onChanged(List<Libro> libros) {
                LibroAdapter la= new LibroAdapter(DetalleLibroActivity.this, R.layout.item, libros, getLayoutInflater());
                binding.lvLista.setAdapter(la);
            }
        });

        vm.getMensajeDeError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mensaje) {
                Toast.makeText(DetalleLibroActivity.this, mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        binding.btVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
