import java.util.Scanner;
import java.util.ArrayList;

public class practica3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Animal> animales = new ArrayList<>();

        System.out.print("ingrese el nombre del Animal: ");
        String nombreAnimal = sc.nextLine().trim();
        System.out.print("ingrese la edad del Animal: ");
        int edadAnimal = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el nombre del Animal con raza: ");
        String nombreAnimalRaza = sc.nextLine().trim();
        System.out.print("ingrese la edad del Animal con raza: ");
        int edadAnimalRaza = sc.nextInt();
        sc.nextLine();
        System.out.print("ingrese el nombre de la raza: ");
        String raza = sc.nextLine();

        System.out.print("Ingrese el nombre del Gato: ");
        String nombreGato = sc.nextLine().trim();
        System.out.print("ingrese la edad del Gato: ");
        int edadGato = sc.nextInt();
        sc.nextLine();
        boolean esIndoor = false;
        while (true){
            System.out.print("El gato vive dentro o afuera?: ");
            String respuesta = sc.nextLine().toLowerCase();
            if (respuesta.equals("dentro")){
                esIndoor = true;
                break;
            }
            else if (respuesta.equals("fuera")){
                esIndoor = false;
                break;
            }
            else{
                System.out.println("Porfavor solo diga 'dentro' o 'fuera' ");
            }
        }
        animales.add(new Animal(nombreAnimal, edadAnimal));
        animales.add(new Raza(nombreAnimalRaza, edadAnimalRaza, raza));
        animales.add(new Gato(nombreGato, edadGato, esIndoor));
        System.out.println("\nANIMALES: ");
        for (Animal animal : animales){
            animal.describir();
            System.out.print("\n");
        }
        sc.close();
    }
}
class Animal{
    private String nombre;
    private int edad;

    public String getNombre(){
        return nombre;
    }
    Animal(String nombre, int edad){
        setNombre(nombre);
        setEdad(edad);

    }
    public void setNombre(String nombreModificado){
        if (nombreModificado.isEmpty()){
            System.out.print("ERROR: El nombre no puede estar vacio");
        }
        else{
            nombre = nombreModificado;
        }
    }

    public int getEdad(){
        return edad;
    }
    public void setEdad(int edadModificada){
        if (edadModificada <= 0){
            System.out.print("ERROR: la edad no puede ser igual o menor a 0");
        }
        else{
            edad = edadModificada;
        }
    }
    void describir(){
        System.out.printf("> Hola soy %s y tengo %d años%n",nombre, edad);
    }
} 
class Raza extends Animal{
    String raza;
    Raza(String nombre, int edad, String raza){
        super(nombre,edad);
        this.raza = raza;
    }
    @Override
    void describir(){
        super.describir();
        System.out.printf("> raza: %s%n", raza);
    }
}
class Gato extends Animal{
    boolean indoor;
    Gato(String nombre, int edad, boolean indoor){
        super(nombre,edad);
        this.indoor = indoor;
    }
    @Override
    void describir(){
        super.describir();
        String estado = (indoor) ? "dentro" : "fuera";
        System.out.printf("> Vivo %s de la casa%n", estado);
    }
}
