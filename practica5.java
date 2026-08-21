import java.util.Scanner;
import java.util.ArrayList;
//prueba de diff
public class practica5 {
    public static void mostrarMenu(){
            System.out.println("""
===== BIBLIOTECA DIGITAL =====
1) Agregar libro físico
2) Agregar libro digital
3) Listar todos los libros
4) Buscar por título
5) Eliminar libro
6) Salir.""");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();
        int opcion = 0;
        while (opcion != 6){
            mostrarMenu();
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(">>>LIBRO FISICO<<<");
                    System.out.print("Titulo: ");
                    String tituloLF = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorLF = sc.nextLine();
                    System.out.print("Paginas: ");
                    int paginasLF = sc.nextInt();
                    sc.nextLine();
                    libros.add(new LibroFisico(tituloLF, autorLF, paginasLF));
                    System.out.println("\nLibro fisico añadido correctamente :P");
                    break;
                case 2:
                    System.out.println(">>>LIBRO DIGITAL<<<");
                    System.out.print("Titulo: ");
                    String tituloLD = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorLD = sc.nextLine();
                    System.out.print("Tamaño (MB): ");
                    double tamanoLD = sc.nextDouble();
                    sc.nextLine();
                    libros.add(new LibroDigital(tituloLD, autorLD, tamanoLD));
                    System.out.println("\nLibro digital añadido correctamente");
                    break;
                case 3:
                    if (libros.isEmpty()){
                        System.out.println("No hay datos ingresados en el ArrayList");
                    }
                    else{
                        for (Libro libro : libros){
                            libro.mostrarInfo();
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el titulo del libro que desea buscar: ");
                    String tituloAbuscar = sc.nextLine();
                    boolean encontrado = false;
                    for (Libro l : libros){
                        if (l.getTitulo().toLowerCase().contains(tituloAbuscar.toLowerCase())){
                            l.mostrarInfo();
                            System.out.println("----------------------");
                            encontrado = true;
                        }}
                    if (!encontrado){
                        System.out.print("No se encontró ningun titulo que coincida con la busqueda");
                    }
                    break;
                case 5:
                    if (libros.isEmpty()){
                        System.out.println("No hay libros en el ArrayList para eliminar");
                    }
                    else{
                        System.out.print("ingrese el numero del libro que desea eliminar (del 1 al "+ libros.size() + "): ");
                        int indice = sc.nextInt() - 1;
                        sc.nextLine();
                        if (indice >= 0 && indice < libros.size()){
                            System.out.printf("Se ha removido el libro %s del ArrayList%n", libros.get(indice).getTitulo());
                            libros.remove(indice);
                        }
                        else{
                            System.out.println("ERROR: Numero invalido");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Hasta luego");
                    break;
            }
        }
        sc.close();

        
    }
}
class Libro{
    private String titulo;
    private String autor;

    Libro(String titulo, String autor){
        setTitulo(titulo);
        setAutor(autor);
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String tituloNuevo){
        if (tituloNuevo == null || tituloNuevo.trim().isEmpty()){
            throw new IllegalArgumentException("ERROR: no puede estar vacio");
        }
        else{
            titulo = tituloNuevo;
        }
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autorNuevo){
        if (autorNuevo == null || autorNuevo.isEmpty()){
            throw new IllegalArgumentException("ERROR: no puede estar vacio");
        }
        else{
            autor = autorNuevo;
        }
    }

    void mostrarInfo(){
        System.out.printf("Titulo: %s - Autor: %s%n",titulo,autor);
    }
}
class LibroFisico extends Libro{
    int numeroPaginas;
    LibroFisico(String titulo, String autor, int numeroPaginas){
        super(titulo,autor);
        this.numeroPaginas = numeroPaginas;
    }
    @Override
    void mostrarInfo(){
        super.mostrarInfo();
        System.out.printf("Numero de paginas: %d%n", numeroPaginas);
    }
}
class LibroDigital extends Libro{
    double tamanoMB;
    LibroDigital(String titulo, String autor, double tamanoMB){
        super(titulo,autor);
        this.tamanoMB = tamanoMB;
    }
    @Override
    void mostrarInfo(){
        super.mostrarInfo();
        System.out.printf("Tamaño en MB: %.2f MB%n", tamanoMB);
    }
}
