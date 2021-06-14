import java.util.Scanner;

public class Practica2 {

    /*
    INICIANDO PROGRAMA
     */
    public static void main(String[] args) {
        Practica2 p2 = new Practica2();
    }

    int clientesLenght = 3;
    int pelisLength = 9;

    /**
     * Declarando arreglos para los datos de clientes (Lo se, quiza sea mas facil usar objetos)
     */
    String[] nombreCliente = new String[clientesLenght];
    int[] idCliente = new int[clientesLenght];
    double[] telefonoCliente = new double[clientesLenght];
    boolean[] prestamoCliente = new boolean[clientesLenght];

    /**
     * Declarando arreglos para los datos de PELICULAS(Lo se, seria mas facil usar objetos)
     */
    int[] idPelicula = new int[pelisLength];
    String[] nombrePelicula = new String[pelisLength];
    int[] anyoPelicula = new int[pelisLength];
    String[] categoriaPelicula = new String[pelisLength];
    boolean[] disponibilidadPelicula = new boolean[pelisLength];

    /**
     * Declarando arreglos para los datos de PRESTAMOS(Lo se, seria mas facil usar objetos)
     */
    int[] idPrestaPelicula = new int[pelisLength];
    String[] nombrePrestaPelicula = new String[pelisLength];
    int[] anyoPrestaPelicula = new int[pelisLength];
    String[] categoriaPrestaPelicula = new String[pelisLength];
    boolean[] disponibilidadPrestaPelicula = new boolean[pelisLength];



    public Practica2(){
        /*
        OBTENIENDO DATOS INICIALES DE CLIENTE
         */
        nombreCliente[0] = "Osvaldo"; nombreCliente[1] = "Manuel"; nombreCliente[2] = "Miguel";
        idCliente[0] = 1; idCliente[1] = 2; idCliente[2] = 3;
        telefonoCliente[0] = 12345678; telefonoCliente[1] = 87654321; telefonoCliente[2] = 76549012;
        prestamoCliente[0] = false; prestamoCliente[1] = false; prestamoCliente[2] = false;

        /*
        OBTENIENDO DATOS INICIALES DE PELICULAS
         */
        idPelicula[0] = 1; idPelicula[1] = 2; idPelicula[2] = 3;
        idPelicula[3] = 4; idPelicula[4] = 5; idPelicula[5] = 6;
        idPelicula[6] = 7; idPelicula[7] = 8; idPelicula[8] = 9;

        nombrePelicula[0] = "The pianist"; nombrePelicula[1] = "Forrest Gump"; nombrePelicula[2] = "Up";
        nombrePelicula[3] = "Fight Club"; nombrePelicula[4] = "Gladiator"; nombrePelicula[5] = "Kill Bill";
        nombrePelicula[6] = "300"; nombrePelicula[7] = "The Matrix"; nombrePelicula[8] = "Avatar";

        anyoPelicula [0] = 2002; anyoPelicula [1] = 1994; anyoPelicula [2] = 2009;
        anyoPelicula [3] = 1999; anyoPelicula [4] = 2000; anyoPelicula [5] = 2003;
        anyoPelicula [6] = 2006; anyoPelicula [7] = 1999; anyoPelicula [8] = 2009;

        categoriaPelicula [0] = "Biography,Drama,Music"; categoriaPelicula [1] = "Drama,Romance"; categoriaPelicula [2] = "Drama";
        categoriaPelicula [3] = "Action,Adventure,Drama"; categoriaPelicula [4] = "Action,Drama"; categoriaPelicula [5] = "Action,Drama";
        categoriaPelicula [6] = "Action"; categoriaPelicula [7] = "Action"; categoriaPelicula [8] = "Action,Fantasy,Adventure";

        disponibilidadPelicula[0] = true; disponibilidadPelicula[1] = true; disponibilidadPelicula[2] = true;
        disponibilidadPelicula[3] = true; disponibilidadPelicula[4] = true; disponibilidadPelicula[5] = true;
        disponibilidadPelicula[6] = true; disponibilidadPelicula[7] = true; disponibilidadPelicula[8] = true;

        menu();
    }

    Scanner entrada = new Scanner(System.in);

    public void menu(){
        int checkDeseo;
        do{
            System.out.println("\n**-------------MENU PRINCIPAL--------**");
            System.out.println("1. Prestamo de Peliculas");
            System.out.println("2. Devolucion de Peliculas");
            System.out.println("3. Mostrar Peliculas Disponibles");
            System.out.println("4. Ingreso de Peliuclas");
            System.out.println("5. Ingresar Clientes Nuevos");
            System.out.println("6. Mostrar Clientes");
            System.out.println("7. Ver Reportes");
            System.out.println("8. Salir\n");
            System.out.println("**-----------------------------------**\n");

            System.out.println("Ingresa una Opcion:");
            checkDeseo = entrada.nextInt();

            switch (checkDeseo){
                case 1:
                    prestamoPelis();
                    break;
                case 2:
                    devolucionPelis();
                    break;
                case 3:
                    mostrarPeliculas();
                    break;
                case 4:
                    resgistrarPelicula();
                    break;
                case 5:
                    registrarCliente();
                    break;
                case 6:
                    mostrarCliente();
                    break;
                case 7:
                    mostrarReportes();
                    break;
                case 8:
                    System.out.println("Adios");
                    break;
            }

        } while (checkDeseo != 8);
    }

    /**
     * OPCION 1 DEL MENU
     */
    public void prestamoPelis(){
        int option;
        int checkId;

        do {
            System.out.println("\n Escribe el numero de la pelicula que deseas Prestar");
            //IMPRIMIENDO LISTA DE PELICULAS DISPONIBLES
            for (int i = 0; i < pelisLength ; i++) {
                if (disponibilidadPelicula[i] == false){
                    System.out.println("\n" + idPelicula[i] + "No Disponible");
                } else {
                    System.out.println("\n" + idPelicula[i] + nombrePelicula[i]);
                }
            }
            option = entrada.nextInt();
            System.out.println("\n A quien se lo prestarás? (Escribe su ID)");
            checkId = entrada.nextInt();
            for (int i = 0; i < clientesLenght; i++) {
                if (checkId == idCliente[i]){
                    prestamoCliente[i] = true;
                } else {
                    System.out.println("");
                }
            }

        } while (option !=0);
    }
    /**
     * OPCION 2 DEL MENU
     */
    public void devolucionPelis(){

    }

    /**
     * OPCION 3 DEL MENU
     */
    public void mostrarPeliculas(){
        //AGREGAR OPCION PARA MOSTRAR EN ORDEN ALFABETICO (ASCENDENTE Y DESCENDENTE)
        int option;
        do {
            System.out.println("Las peliculas que se encuentran disponibles son: ");
            for (int i = 0; i < pelisLength ; i++) {
                if (disponibilidadPelicula[i]){
                    System.out.println("\n" + idPelicula[i] + "----" + nombrePelicula[i] + "----" + anyoPelicula[i] + "----" +
                            categoriaPelicula[i] + "----" + "Disponible en Bodega");
                } else {
                    System.out.println("\n" + idPelicula[i] + "----" + nombrePelicula[i] + "----" + anyoPelicula[i] + "----" +
                            categoriaPelicula[i] + "----" + "No Disponible en Bodega");
                }
            }
            System.out.println("1. Regresar");
            option = entrada.nextInt();
        } while (option != 1);
    }

    /**
     * OPCION 4 DEL MENU
     */
    public void resgistrarPelicula(){

    }

    /**
     * OPCION 5 DEL MENU
     */

    public void registrarCliente(){

    }

    /**
     * OPCION 6 DEL MENU
     */

    public void mostrarCliente(){
        //AGREGAR OPCION PARA MOSTRAR EN ORDEN ALFABETICO (ASCENDENTE Y DESCENDENTE)
        int option;
        do {
            System.out.println("\n**-------------CLIENTES REGISTRADOS--------**\n");
            for (int i = 0; i < clientesLenght ; i++) {
                if (prestamoCliente[i]){
                    System.out.println("\n" + idCliente[i] + ".----" + nombreCliente[i] + "----" + telefonoCliente[i] + "----" +
                            "No Apto para Alquiler");
                } else {
                    System.out.println("\n" + idCliente[i] + ".----" + nombreCliente[i] + "----" + telefonoCliente[i] + "----" +
                            "Apto para Alquiler");
                }
            }

            System.out.println("\n---OPCIONES---");
            System.out.println("1. Regresar");
            System.out.println("\n**-----------------------------------------**\n");
            System.out.println("Ingresa una Opcion:");
            option = entrada.nextInt();
        } while (option != 1);

    }

    /**
     * OPCION 7 DEL MENU
     */

    public void mostrarReportes(){

    }


}