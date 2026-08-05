import java.util.Scanner;
import java.util.ArrayList;
class practica2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = input.nextLine();
        System.out.print("Ingrese el sueldo del empleado: $");
        int sueldo = input.nextInt();

        input.nextLine();

        System.out.print("Ingrese el nombre del Garzon: ");
        String nombreG = input.nextLine();
        System.out.print("Ingrese el sueldo: $");
        int sueldoG = input.nextInt();
        
        input.nextLine();

        System.out.print("Ingrese la cantidad de mesas asignadas: ");
        int mesasAsignadas = input.nextInt();

        input.nextLine();

        System.out.print("Ingrese el nombre del Chef: ");
        String nombreCH = input.nextLine();
        System.out.print("Ingrese el sueldo del Chef: $");
        int sueldoCH = input.nextInt();
        
        input.nextLine();

        System.out.print("Ingrese la especialidad del Chef: ");
        String especialidad = input.nextLine();


        empleados.add(new Empleado(nombre,sueldo));
        empleados.add(new Garzon(nombreG, sueldoG, mesasAsignadas));
        empleados.add(new Chef(nombreCH, sueldoCH, especialidad));

        for (Empleado emp : empleados){
            emp.presentarse();
        }
        input.close();
    }
}
class Empleado{
    private String nombre;
    private int sueldo;

    Empleado(String nombre, int sueldo){
        setNombre(nombre);
        setSueldo(sueldo);
    }


    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombreNuevo){
        if (nombreNuevo.isEmpty()){
            System.out.println("Invalido, el nombre no puede estar vacio");
        }
        else {
            nombre = nombreNuevo;
        }
    }
    public int getSueldo(){
        return sueldo;
    }
    public void setSueldo(int nuevoSueldo){
        if (nuevoSueldo <= 0){
            System.out.println("El Sueldo no puede ser menor o igual a 0");
        }
        else{
            sueldo = nuevoSueldo;
        }
    }
    void presentarse(){
        System.out.println("Hola, soy " + nombre + " y gano: $"+ sueldo );
    } 
}
class Garzon extends Empleado {
    int mesasAsignadas;
    
    Garzon(String nombre, int sueldo, int mesasAsignadas){
        super(nombre, sueldo);
        this.mesasAsignadas = mesasAsignadas;
    }
    @Override
    void presentarse(){
        super.presentarse();
        System.out.println("Mesas asignadas: "+ mesasAsignadas);
    }
}
class Chef extends Empleado {
    String especialidad;

    Chef(String nombre, int sueldo, String especialidad){
        super(nombre,sueldo);
        this.especialidad = especialidad;
    }
    @Override
    void presentarse(){
        super.presentarse();
        System.out.println("Especialidad: "+ especialidad);
    }
}