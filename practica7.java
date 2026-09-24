import java.util.Scanner; //importo un scanner para utilizarlo como un input
public class practica7{
    public static int pedir_y_validarN(Scanner s,String mensaje){ //creo un metodo estatico fuera del main en el que valido numeros
        while (true){
            try{
                System.out.print(mensaje);//muestro el mensaje colocado en el mismo main, en main se veria asi pedir_y_vallidarN(numingresado, "texto ingresado")
                if (s.hasNext()){ //utilizo hasNext para saber si existe en algun lugar un Scanner
                    String numstr = s.nextLine();//se le pide al principio un texto
                    int num = Integer.parseInt(numstr);// aqui convierto el texto en numero si es que no hay ningun problema
                    return num;
                }}
            catch (NumberFormatException e){System.out.println("ERROR: Porfavor solo ingrese numeros");//esto detecta automaticamente si falla al convertir en numeros, por ej al ingresar un texto
            }

            }}
    public static String validarSTR(Scanner s, String mensaje){
        System.out.print(mensaje);
        while (true){
            String str = s.nextLine();
            if (str.matches("[a-zA-Z ]+")) {return str;} 
            System.out.println("Ingresa solo letras");
            System.out.print(mensaje);
        }
        
                
    }
    public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    String titulo = validarSTR(s, "Ingrese el titulo: ");
    int duracion = pedir_y_validarN(s, "Ingrese la duracion de la pelicula: ");
    String autor = validarSTR(s, "Ingrese el nombre del autor: ");
    int costo = pedir_y_validarN(s, "Ingrese el valor de la entrada: $");

    System.out.printf("Titulo: %s | Duracion: %d minutos | Autor: %s | Costo de entrada: $%d%n",titulo,duracion,autor,costo);
    
    s.close();
    }
}
class Pelicula{
    private String tituloP;
    private int duracionP;
    private String autorP;
    private int costoP;

    Pelicula(String titulo,int duracion,String autor,int costo){
        setAutor(autor);
        setCosto(costo);
        setDuracion(duracion);
        setTitulo(titulo);
    }


    public String getTitulo(){return this.tituloP;}
    public int getDuracion(){return this.duracionP;}
    public String getAutor(){return this.autorP;}
    public int getCosto(){return this.costoP;}

    public void setTitulo(String titulonew){
        if (titulonew==null || titulonew.isEmpty()){throw new IllegalArgumentException("ERROR:Aqui no puede estar vacio");}
        tituloP = titulonew;}

    public void setDuracion(int duracionew){
        if (duracionP <= 0){System.out.println("La duracion no puede ser ni menor o igual a 0");}
        else{duracionP = duracionew;}
    }
    public void setAutor(String autornew){
    if (autornew == null || autornew.trim().isEmpty()){throw new IllegalArgumentException("ERROR: Aqui no puede estar vacio");}
    else{autorP = autornew;}
    }
    public void setCosto(int costonew){
        if(costonew <= 0){System.out.println("El costo no puede ser menor o igual a 0");}
        else{costoP = costonew;}
    }
    void mostrarInfo(){System.out.printf("");}
        

}