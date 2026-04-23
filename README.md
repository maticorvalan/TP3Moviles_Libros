# TP3 Busqueda Libros
Alumno: Corvalan Matias

Es una aplicación para buscar libros. Cuenta con una clase modelo llamada Libro, dos Activities con sus respectivos ViewModel y un LibroAdapter, el cual define cómo debe cargarse la vista de cada ítem que se agrega a la ListView.

La Activity DetalleLibro, junto con su ViewModel, se encarga de seleccionar qué elementos se van a mostrar en la lista. Por otro lado, la MainActivity recibe el nombre del libro a buscar a través de un PlainText (EditText) y envía esa información mediante un Intent a la DetalleActivity.

En ambas Activities, se utilizó ViewBinding para obtener y manejar los elementos de las vistas.

Libros: Soy Leyenda, Avatar, Aliens, Harry Potter
