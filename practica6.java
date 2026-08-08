import java.util.Scanner;
import java.util.ArrayList;
public class practica6 {
    public static void menu(){
        System.out.println("""
====== CINE ======
1) Agregar película normal
2) Agregar película estreno
3) Ver cartelera
4) Ver duración total de la cartelera
5) Salir
                """);
    }
    public static int pedirOpcion(Scanner sc){
        while (true){
            menu();
            System.out.print("Ingrese una opcion: ");
            if (sc.hasNextInt()){
                int opcion = sc.nextInt();
                sc.nextLine();
                if (opcion >= 1 && opcion <= 5){
                    return opcion;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("ERROR: Ingrese solo numeros dentro del rango(1-5)");
        }
    }

    public static void main(String[] args){
        Sala sala = new Sala("Sala 1", 100);
        Scanner sc = new Scanner(System.in);

        while (true){
            int opcion = pedirOpcion(sc);
            switch (opcion) {
                case 1:
                    System.out.println(">>>>>PELICULA NORMAL<<<<<");
                    System.out.print("Ingrese el nombre de la pelicula: ");
                    String nombreP = sc.nextLine();
                    System.out.print("Ingrese la duracion de la pelicula en min: ");
                    int duracionP = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el genero de la pelicula: ");
                    String generoP = sc.nextLine();
                    Pelicula p = new Pelicula(nombreP, duracionP, generoP);
                    sala.agregarPelicula(p);
                    System.out.println("Se ha añadido la pelicula correctamente");
                    continue;
                case 2:
                    System.out.println(">>>>>PELICULA ESTRENO<<<<<");
                    System.out.print("Ingrese el nombre de la pelicula de estreno: ");
                    String nombrePE = sc.nextLine();
                    System.out.print("Ingrese la duracion de la pelicula en min: ");
                    int duracionPE = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el genero de la pelicula: ");
                    String generoPE = sc.nextLine();
                    System.out.print("Ingrese el precio extra a pagar: $");
                    int precioExtra = sc.nextInt();
                    sc.nextLine();
                    PeliculaEstreno PE = new PeliculaEstreno(nombrePE, duracionPE, generoPE, precioExtra);
                    sala.agregarPelicula(PE);
                    continue;
                case 3:
                    System.out.println(">>>>>CARTELERA<<<<<");
                    sala.mostrarCartelera();
                    continue;
                case 4:
                    System.out.println("\n>>>>>DURACION TOTAL DE CARTELERA<<<<<");
                    System.out.printf("Total de minutos: %d MIN%n%n", sala.totalMinutos());
                    continue;
                case 5:
                    System.out.println("Hasta luego");
                    sc.close();
                    return;
                default:
                    System.out.println("Ingrese una opcion dentro del rango (1-5)");
                    continue;
            }
        }
    }
}
class Pelicula{
    private String titulo;
    private int duracion;
    private String genero;
    public String getTitulo(){
        return titulo;
    }
    public int getDuracion(){
        return duracion;
    }
    public String getGenero(){
        return genero;
    }

    public Pelicula(String titulo, int duracion, String genero){
        setTitulo(titulo);
        setDuracion(duracion);
        setGenero(genero);
    }

    public void setTitulo(String tituloNuevo){
        if (tituloNuevo == null || tituloNuevo.trim().isEmpty()){
            throw new IllegalArgumentException("ERROR: este campo no puede estar vacio");
        }
        else{
            titulo = tituloNuevo;
        }
    }
    public void setDuracion(int duracionNueva){
        if (duracionNueva <= 0){
            System.out.println("ERROR: La duracion no puede ser menor o igual a 0");
        }else{
            duracion = duracionNueva;
        }
    }
    public void setGenero(String generoNuevo){
        if (generoNuevo == null || generoNuevo.trim().isEmpty()){
            throw new IllegalArgumentException("ERROR: este campo no puede estar vacio");
        }else{
            genero = generoNuevo;
        }
    }
    void mostrarInfo(){
        System.out.printf("Pelicula: %s | Duracion: %d | Genero: %s%n%n",titulo,duracion,genero);
    }
}
class PeliculaEstreno extends Pelicula{
    int precioExtra;
    PeliculaEstreno(String titulo, int duracion, String genero, int precioExtra){
        super(titulo,duracion,genero);
        this.precioExtra = precioExtra;
    }
    String etiqueta(){
        return "Estreno 🎬";
    }
    @Override
    void mostrarInfo(){
        String etiqueta = etiqueta();
        super.mostrarInfo();
        System.out.printf(" Precio extra: $%d | %s%n", precioExtra,etiqueta);
    }
}
class Sala{
    private String nombre;
    private int capacidad;
    ArrayList<Pelicula> cartelera = new ArrayList<>();
    Sala(String nombre, int capacidad){
        setNombre(nombre);
        setCapacidad(capacidad);
    }
    public String getNombre(){
        return nombre;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public void setNombre(String nombreNuevo){
        if (nombreNuevo == null || nombreNuevo.trim().isEmpty()){
            throw new IllegalArgumentException("ERROR: Aqui no puede estar vacio");
        }else{
            nombre = nombreNuevo;
        }
    }
    public void setCapacidad(int capacidadNueva){
        if (capacidadNueva <= 0){
            System.out.println("ERROR: La capacidad debe ser mayor a 0 ");
        }else{
            capacidad = capacidadNueva;
        }
    }
    void agregarPelicula(Pelicula p){
        cartelera.add(p);
    }
    void mostrarCartelera(){
        System.out.printf("Sala: %s%n",nombre);
        for (Pelicula p : cartelera){
            p.mostrarInfo();
        }
    }
    int totalMinutos(){
        int total = 0;
        for (Pelicula p : cartelera){
            total += p.getDuracion();
        }
        return total;
    }

    
}