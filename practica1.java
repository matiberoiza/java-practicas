public class practica1 {
    public static void main(String[] args) {
        Libro L1 = new Libro("El muelle",400);

        L1.mostrarInfo();
        L1.setTitulo("El muelle 2.0");
        L1.mostrarInfo();
        L1.evaluarTamano();

        LibroDigital ld = new LibroDigital("El muelle digital", 500, 30);
        ld.mostrarInfo();

        LibroAudio la = new LibroAudio("El muelle audiolibro", 400, 300);
        la.mostrarInfo();
    }
}

class Libro {
    private String titulo;
    private int paginas;

    Libro(String titulo, int paginas) {
        setTitulo(titulo);
        setPaginas(paginas);
    }
    public String getTitulo(){
        return titulo;
    }
    void mostrarInfo() {
        System.out.println(titulo + " - " + paginas + " paginas");
    }
    public void setTitulo(String nuevoTitulo){
        if (nuevoTitulo.isEmpty()){
            System.out.println("Invalido, el titulo debe contener algo");
        }
        else{
            cambiarTitulo(nuevoTitulo);
        }
    }
    void cambiarTitulo(String nuevoTitulo){
        titulo = nuevoTitulo;
    }

    public int getPaginas(){
        return paginas;
    }
    public void setPaginas(int paginasNuevas){
        if (paginasNuevas <= 0){
            System.out.println("Invalido, aqui no puede ser menor o igual a 0");
        }
        else {
            paginas = paginasNuevas;
        }
    }
    void evaluarTamano() {
        if (this.esLargo()) {
            System.out.println("El numero de paginas es mayor a 300");
        } else {
            System.out.println("El numero de paginas es menor o igual a 300");
        }
    }

    boolean esLargo() {
        return paginas > 300;
    }
}
class LibroDigital extends Libro{
    double tamanoMB;

    LibroDigital(String titulo, int paginas, double tamanoMB){
        super(titulo,paginas);
        this.tamanoMB = tamanoMB;
    }
    @Override
    void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Tamaño: "+ tamanoMB + " MB");
    }
}
class LibroAudio extends Libro{
    int minutos;

    LibroAudio(String titulo, int paginas, int minutos){
        super(titulo,paginas);
        this.minutos = minutos;
    }
    @Override
    void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Duracion: "+ minutos + " minutos");
    }
}