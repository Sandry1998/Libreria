import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Crear un proyecto usando la clase libro.
 * Atributos:
 * id
 * Titulo
 * Autor
 * Paginas
 * ISBN
 * Año de publicación
 * Editorial
 */

public class Main {
    public static void main(String[] args) {

     menu();
    }
    //Creamos la coleccion de forma global para que todos los metodos puedan acceder a ellas
    static ArrayList<Libro> coleccionLibros= new ArrayList();

    public static void menu(){
       int opcion=0;
       String opcionString= JOptionPane.showInputDialog(null,"Ingrese una opcion:\n1.Alta Ficha \n2. Baja Ficha \n3. Modificar Ficha \n4. Mostrar Ficha \n5. Salir");
        try{
        opcion=Integer.parseInt(opcionString);
        switch(opcion){
            case 1,3-> altaModificacionLibro(opcion);
            case 2-> eliminarLibro();
            case 4-> mostrar();
            case 5-> JOptionPane.showMessageDialog(null,"Saliendo del programa");
            default -> JOptionPane.showMessageDialog(null,"Opcion incorrecta");
        }
        }catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Ingrese un numero valido");
        }

    }
    public static void altaModificacionLibro(int opcion){
        String titulo;
        String autor="";
        String isbn="";
        String editorial="";
        int paginas=0;
        int anioPublicacion=0;
        if(opcion==1){
           titulo=JOptionPane.showInputDialog(null,"Ingrese el titulo");
           autor=JOptionPane.showInputDialog(null,"Ingrese el autor");
           paginas= leerPaginas();
           isbn=JOptionPane.showInputDialog(null,"Ingrese el isbn");
           anioPublicacion= leerAnioPublicacion();
           editorial=JOptionPane.showInputDialog(null,"Ingrese la editorial");
           Libro nuevo = new Libro(titulo,autor,isbn,editorial,paginas,anioPublicacion);
           if(nuevo!=null){
               coleccionLibros.add(nuevo);
               menu();
           }
        }
        if(opcion==3){
            String salida=mostrarLibros();
            String modificarId= JOptionPane.showInputDialog(null,salida+"\nIngrese el id del libro");
            String queModificar=JOptionPane.showInputDialog(null,"\n1->Titulo\n2->Autor\n3->ISBN\n4->Editorial\n5->Pagina\n6->AnioPublicacion");
            int opcionModificar= 0;
            int idLibroModificar=0;
            try{
                opcionModificar= Integer.parseInt(queModificar);
                idLibroModificar= Integer.parseInt(modificarId);
                Iterator<Libro> it=coleccionLibros.iterator();
                while(it.hasNext()){
                    Libro libro=it.next();
                    if(libro.getIdLibro()==idLibroModificar){
                        switch (opcionModificar){
                            case 1->{
                                titulo=JOptionPane.showInputDialog(null,"Ingrese el titulo");
                                libro.setTitulo(titulo);
                            }
                            case 2->{
                                autor=JOptionPane.showInputDialog(null,"Ingrese el autor");
                                libro.setAutor(autor);
                            }
                            case 3->{
                                isbn=JOptionPane.showInputDialog(null,"Ingrese el isbn");
                                libro.setIsbn(isbn);
                            }
                            case 4->{
                                editorial=JOptionPane.showInputDialog(null,"Ingrese la editorial");
                                libro.setEditorial(editorial);
                            }
                            case 5->{
                                paginas=leerPaginas();
                                libro.setPaginas(paginas);
                            }
                            case 6->{
                                anioPublicacion=leerAnioPublicacion();
                                libro.setAnioPublicacion(anioPublicacion);
                            }
                        }
                    }
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingrese un numero valido");
            }
            mostrar();
        }
    }
    public static void eliminarLibro(){

    }
    public static void mostrar(){
        String salida=mostrarLibros();
        JOptionPane.showMessageDialog(null,salida);
        menu();
    }
    public static String mostrarLibros(){
        String salida="";
        if(!coleccionLibros.isEmpty()){
            for(Libro libro:coleccionLibros){
                salida+=libro.toString()+"\n";
            }
        }else{
            salida="No hay libros";
        }
        return salida;
    }
    public static int leerPaginas(){
        boolean paginasCorrectas=false;
        int paginas=0;
        do{
            String paginasString=JOptionPane.showInputDialog(null,"Ingrese el numero de paginas");
            try{
                paginas=Integer.parseInt(paginasString);
                paginasCorrectas=true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingrese el numero de paginas");
            }
        }while(!paginasCorrectas);
        return paginas;
    }
    public static int leerAnioPublicacion(){
        boolean anioPublicacionCorrectas=false;
        int anioPublicacion=0;
        do{
            String anioPublicacionString=JOptionPane.showInputDialog(null,"Ingrese el año");
            try{
                anioPublicacion=Integer.parseInt(anioPublicacionString);
                anioPublicacionCorrectas=true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Ingrese el año");
            }
        }while(!anioPublicacionCorrectas);
        return anioPublicacion;
    }
}