import java.util.Scanner;
import java.util.ArrayList;

public class practica4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto: ");
        String nombreP = sc.nextLine().trim();
        System.out.print("Ingrese el precio del producto: $");
        int precioP = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el stock del producto: ");
        int stockP = sc.nextInt();
        sc.nextLine();

        System.out.print("ingrese el nombre del juego fisico: ");
        String nombreJF = sc.nextLine().trim();
        System.out.print("Ingrese el precio del juego fisico: $");
        int precioJF = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el stock del juego fisico: ");
        int stockJF = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el tamaño en gramos del juego fisico: ");
        int pesoJF = sc.nextInt();
        sc.nextLine();

        System.out.print("ingrese el nombre del juego digital: ");
        String nombreJD = sc.nextLine().trim();
        System.out.print("Ingrese el precio del juego digital: $");
        int precioJD = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el stock del juego digital: ");
        int stockJD = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el tamaño en GB del juego digital: ");
        double pesoJD  = sc.nextDouble();
        sc.nextLine();

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(nombreP, precioP, stockP));
        productos.add(new JuegoFisico(nombreJF,precioJF,stockJF,pesoJF));
        productos.add(new JuegoDigital(nombreJD, precioJD, stockJD, pesoJD));

        for (Producto p : productos){
            p.mostrarInfo();
            if (p.estaDisponible()){
                System.out.println("☑️ En stock");
            }
            else{
                System.out.println("❌ Sin stock");
            }

            if (p instanceof JuegoFisico){
                JuegoFisico jf = (JuegoFisico) p;
                System.out.println("Envio " + jf.calcularEnvio());
            }

            if (p instanceof JuegoDigital){
                JuegoDigital jd = (JuegoDigital) p;
                System.out.println("Descarga:  "+ jd.tipoDescarga());
            }
        }
        sc.close();



    }
}
class Producto{
    private String nombre;
    private int precio;
    private int stock;

    Producto(String nombre, int precio, int stock){
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombreNuevo){
        if (nombreNuevo == null || nombreNuevo.trim().isEmpty()){
            throw new IllegalArgumentException("ERROR: El nombre no puede estar vacio");
        }
        else{
            nombre = nombreNuevo;
        }
    }

    public int getPrecio(){
        return precio;
    }
    public void setPrecio(int precioNuevo){
        if (precioNuevo <= 0){
            throw new IllegalArgumentException("ERROR: El precio no puede ser menor o igual a 0");
        }
        else{
            precio = precioNuevo;
        }
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stockNuevo){
        if (stockNuevo < 0){
            throw new IllegalArgumentException("ERROR: El stock no puede ser menor a 0");
        }
        else{
            stock = stockNuevo;
        }
    }
    public boolean estaDisponible(){
        return stock > 0;
    }
    void mostrarInfo(){
        System.out.println("");
        System.out.printf("Nombre producto: %s%nPrecio: $%d%nStock: %d%n",nombre,precio,stock);
    }
} 
class JuegoFisico extends Producto{
    int pesoGramo;
    JuegoFisico(String nombre,int precio, int stock, int pesoGramo){
        super(nombre,precio,stock);
        this.pesoGramo = pesoGramo;
    }
    String calcularEnvio(){
        return pesoGramo < 500 ? "gratis" : "con costo";
    }
    @Override
    void mostrarInfo(){
        super.mostrarInfo();
        System.out.printf("Peso: %d gramos%n",pesoGramo);
    }

}
class JuegoDigital extends Producto{
    double pesoGB;
    JuegoDigital(String nombre,int precio,int stock,double pesoGB){
        super(nombre,precio,stock);
        this.pesoGB = pesoGB;
    }
    String tipoDescarga(){
        return pesoGB < 10 ? "descarga rapida" : "descarga pesada";
    }
    @Override
    void mostrarInfo(){
        super.mostrarInfo();
        System.out.printf("Peso: %.2f GB%n",pesoGB);
    }
}