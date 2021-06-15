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
    int prestamoLength = 1;

    /**
     * Declarando arreglos para los datos de clientes (Lo se, quiza sea mas facil usar objetos)
     */
    String[] nombreCliente = new String[100];
    int[] idCliente = new int[100];
    int[] telefonoCliente = new int[100];
    boolean[] prestamoCliente = new boolean[100];

    /**
     * Declarando arreglos para los datos de PELICULAS(Lo se, seria mas facil usar objetos)
     */
    int[] idPelicula = new int[100];
    String[] nombrePelicula = new String[100];
    int[] anyoPelicula = new int[100];
    String[] categoriaPelicula = new String[100];
    boolean[] disponibilidadPelicula = new boolean[100];

    /**
     * Declarando arreglos para los datos de PRESTAMOS(Lo se, seria mas facil usar objetos)
     */
    int[] idPrestaPelicula = new int[prestamoLength];
    int [] idClientePrestaPelicula = new int[prestamoLength];
    int[] cantDiasPrestaPelicula = new int[prestamoLength];

    public Practica2(){
        /*
        OBTENIENDO DATOS INICIALES DE CLIENTE
         */
        nombreCliente[0] = "Osvaldo"; nombreCliente[1] = "Manuel"; nombreCliente[2] = "Miguel";
        idCliente[0] = 1; idCliente[1] = 2; idCliente[2] = 3;
        telefonoCliente[0] = 12345678; telefonoCliente[1] = 87654321; telefonoCliente[2] = 76549012;
        prestamoCliente[0] = true; prestamoCliente[1] = false; prestamoCliente[2] = false;

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
        disponibilidadPelicula[6] = true; disponibilidadPelicula[7] = true; disponibilidadPelicula[8] = false;

        /*
        OBTENIENDO DATOS INICIALES DE PRESTAMOS
         */
        idPrestaPelicula[0] = 9; idClientePrestaPelicula[0] = 1; cantDiasPrestaPelicula[0] = 5;

        menu();
    }

    Scanner entrada = new Scanner(System.in);

    public void menu(){
        int checkDeseo;
        do{
            System.out.println("\n**-------------MENU PRINCIPAL--------**");
            System.out.println("1. Prestamo de Peliculas");
            System.out.println("\n2. Devolucion de Peliculas");
            System.out.println("\n3. Mostrar Peliculas Disponibles");
            System.out.println("\n4. Ingreso de Peliuclas");
            System.out.println("\n5. Ingresar Clientes Nuevos");
            System.out.println("\n6. Mostrar Clientes");
            System.out.println("\n7. Ver Reportes");
            System.out.println("\n8. Salir");
            System.out.println("**-----------------------------------**\n");

            System.out.println("Ingresa una Opcion:");
            checkDeseo = entrada.nextInt();
            entrada.nextLine();

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
                    ingresarPeliculas();
                    break;
                case 5:
                    ingresarClientes();
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
        int optionMenu;
        int checkIdCliente;
        int checkIdPelicula;
        boolean procesoTransaccion = false;

        do {
            System.out.println("\n ¿A QUIEN LE ALQUILARÁS?(Escribe su ID)");
            for (int i = 0; i < clientesLenght; i++) {
                //IMPRIMIENDO NOMBRES DE CLIENTES
                if (prestamoCliente[i] == false) {
                    System.out.println("\n" + idCliente[i] + "----" + nombreCliente[i] + "----" + " Apto para Alquiler");
                } else {
                    System.out.println("\n" + idCliente[i] + "----" + nombreCliente[i] + "----" + " No Apto para Alquiler");
                }
            }
            System.out.println("-----Ingresa un ID-----");
            checkIdCliente = entrada.nextInt();
            entrada.nextLine();

            do {
                //VERIFICANDO DISPONIBILIDAD DE PRESTAMO
                for (int i = 0 ; i < clientesLenght; i++) {
                    if (checkIdCliente == idCliente[i]) {
                        if (!prestamoCliente[i]) {
                            System.out.println("Prestamo exitoso");
                            prestamoCliente[i] = true;
                            procesoTransaccion = true;

                            //break;
                        } else {
                            procesoTransaccion = false;
                            System.out.println("NO APTO PARA ALQUILER");
                        }
                    }
                }
                //} while (proceso1Transaccion != true);

                System.out.println("\n Escribe el numero de la pelicula que deseas Prestar");

                //IMPRIMIENDO LISTA DE PELICULAS DISPONIBLES
                for (int i = 0; i < pelisLength ; i++) {
                    if (disponibilidadPelicula[i] == false){
                        System.out.println("\n" + idPelicula[i] + ". No Disponible");
                    } else {
                        System.out.println("\n" + idPelicula[i] + ". " + nombrePelicula[i]);
                    }
                }
                System.out.println("Ingresa un Id de Pelicula");

                //do {
                checkIdPelicula = entrada.nextInt();

                for (int i = 0; i < pelisLength; i++) {
                    if (checkIdPelicula == idPelicula[i]) {
                        if (disponibilidadPelicula[i]){
                            disponibilidadPelicula[i] = false;
                            System.out.println("\n Transaccion Exitosa");
                            procesoTransaccion = false;
                            break;
                            //proceso2Transaccion = true;
                        }else {
                            System.out.println("ERROR: No se puede Alquilar esta pelicula \n" +
                                    "Ingresa Id de Pelicula Nuevamente");
                            procesoTransaccion = true;
                        }
                    }
                }
            } while (procesoTransaccion != false);

            System.out.println("Quieres Realizar otra transaccion? (1 = SI /0 = NO)");
            optionMenu = entrada.nextInt();
        } while (optionMenu != 0);
    }


    /**
     * OPCION 2 DEL MENU
     */
    public void devolucionPelis(){
        int vinyeta = 1;
        int optionMenu;
        int checkIdOption;

        do {
        /*
        IMPRIMIENDO DATOS DE CLIENTES QUE PRESTARON
         */
            for (int i = 0; i < prestamoLength; i++) {
                for (int j = 0; j < clientesLenght; j++) {
                    if (idClientePrestaPelicula[i] == idCliente[j]) {
                        for (int k = 0; k < pelisLength; k++) {
                            if (idPrestaPelicula[i] == idPelicula[k]) {
                                System.out.println(vinyeta + ". El cliente: " + nombreCliente[j] + " Debe: " + nombrePelicula[k] + "\n");
                                vinyeta++;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("\n----OPCIONES---- " +
                    "1. Regresar 2. Registrar Devolucion");
            optionMenu = entrada.nextInt();

            if (optionMenu == 2){
                System.out.println("\nESCRIBE EL ID DE LA PERSONA QUE HARÁ LA DEVOLUCION");
                checkIdOption = entrada.nextInt();
                for (int i = 0; i < prestamoLength; i++) {
                    if(checkIdOption == idClientePrestaPelicula[i]) {
                        for (int j = 0; j < clientesLenght; j++) {
                            if (idClientePrestaPelicula[i] == idCliente[j]) {
                                for (int k = 0; k < pelisLength; k++) {
                                    if (idPrestaPelicula[i] == idPelicula[k]) {
                                        prestamoCliente[j] = false;
                                        disponibilidadPelicula[k] = true;

                                        prestamoLength = prestamoLength - 1;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println("Escribe un ID Valido");
            } else {
                System.out.println("");
            }

        } while (optionMenu != 1);

    }

    /**
     * OPCION 3 DEL MENU
     *///
    public void mostrarPeliculas(){
        int option;
        do {
            System.out.println("Las peliculas que se encuentran disponibles son: ");
            for (int i = 0; i < pelisLength ; i++) {
                if (disponibilidadPelicula[i]){
                    System.out.println("\n" + idPelicula[i] + "----" + nombrePelicula[i] + "----" + anyoPelicula[i] + "----" +
                            categoriaPelicula[i] + "----" + "DISPONIBLE en Bodega");
                } else {
                    System.out.println("\n" + idPelicula[i] + "----" + nombrePelicula[i] + "----" + anyoPelicula[i] + "----" +
                            categoriaPelicula[i] + "----" + "NO DISPONIBLE en Bodega");
                }
            }
            System.out.println("\n1. Regresar -- 2. Ordenar Id Ascendente -- 3. Ordenar Id Descendente");
            option = entrada.nextInt();

            switch (option){
                case 1:
                    System.out.println("");
                    break;
                case 2:
                    ordenarAscendente();
                    break;
                case 3:
                    ordenarDescendente();
                    break;
                default:
                    System.out.println("");
                    break;
            }
        } while (option != 1);
    }

    /**
     * OPCION 4 DEL MENU
     */
    public void ingresarPeliculas(){
        String name;
        int id;
        int year;
        String category;

        boolean hallado = false;
        //pelisLength++;

        System.out.println("Ingresa el nombre de la película");
        name =  entrada.nextLine();

        System.out.println("Ingresa el id de la película");
        id = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingresa el año de la película");
        year = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingresa la categoría de la película");
        category = entrada.nextLine();
        for (int i = 0; i < pelisLength; i++) {
            if(idPelicula[i] == id){
                hallado = true;
                break;
            }
        }
        if(!hallado){
            nombrePelicula[pelisLength] = name;
            idPelicula[pelisLength] = id;
            anyoPelicula[pelisLength] = year;
            categoriaPelicula[pelisLength] = category;
            disponibilidadPelicula[pelisLength] = true;
            System.out.println("Se guardó la peli ");
            pelisLength++;
        }
        else{
            //pelisLength--;
            System.out.println("No se pudo guardar la peli, verifique que los datos esten bien escritos y el id no coincida con uno anteriormente creado");
        }


    }

    /**
     * OPCION 5 DEL MENU
     */

    public void ingresarClientes(){
        String name;
        int id;
        int phone;

        boolean hallado = false;
        //clientesLenght++;

        System.out.println("Ingresa el nombre del cliente");
        name =  entrada.nextLine();

        System.out.println("Ingresa el id del cliente");
        id = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Ingresa el telefono del cliente");
        phone = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < clientesLenght; i++) {
            if(idCliente[i] == id){
                hallado = true;
                break;
            }
        }
        if(!hallado){
            nombreCliente[clientesLenght] = name;
            idCliente[clientesLenght] = id;
            telefonoCliente[clientesLenght] = phone;
            prestamoCliente[clientesLenght] = false;
            System.out.println("Se guardó el cliente ");
            clientesLenght++;
        }
        else{
            //clientesLenght--;
            System.out.println("No se pudo guardar el cliente, verifique que los datos esten bien escritos y el id no coincida con uno anteriormente creado");
        }

    }

    /**
     * OPCION 6 DEL MENU
     */

    public void mostrarCliente(){
        /*
            AGREGAR OPCION PARA MOSTRAR EN ORDEN ALFABETICO (ASCENDENTE Y DESCENDENTE)
         */
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

    public void ordenarAscendente(){
        int auxID;
        String auxNomber;
        int auxAnyo;
        String auxCategoria;
        boolean auxDisponibilidad;

        for (int i = 0; i < pelisLength - 1; i++) {
            for (int j = 0; j < pelisLength - 1; j++) {
                if (nombrePelicula[j].compareTo(nombrePelicula[j+1]) > 0){

                    auxNomber=nombrePelicula[j];
                    nombrePelicula[j] = nombrePelicula[j+1];
                    nombrePelicula[j+1] = auxNomber;

                    auxID = idPelicula[j];
                    idPelicula[j] = idPelicula[j+1];
                    idPelicula[j+1] = auxID;

                    auxAnyo = anyoPelicula[j];
                    anyoPelicula[j] = anyoPelicula[j+1];
                    anyoPelicula[j+1] = auxAnyo;

                    auxCategoria = categoriaPelicula[j];
                    categoriaPelicula[j] = categoriaPelicula[j+1];
                    categoriaPelicula[j+1] = auxCategoria;

                    auxDisponibilidad = disponibilidadPelicula[j];
                    disponibilidadPelicula[j] = disponibilidadPelicula[j+1];
                    disponibilidadPelicula[j+1] = auxDisponibilidad;
                }
            }
        }
    }

    public void ordenarDescendente(){
        int auxID;
        String auxNomber;
        int auxAnyo;
        String auxCategoria;
        boolean auxDisponibilidad;

        for (int i = 0; i < pelisLength - 1; i++) {
            for (int j = 0; j < pelisLength - 1; j++) {
                if (nombrePelicula[j].compareTo(nombrePelicula[j+1]) < 0){

                    auxNomber=nombrePelicula[j];
                    nombrePelicula[j] = nombrePelicula[j+1];
                    nombrePelicula[j+1] = auxNomber;

                    auxID = idPelicula[j];
                    idPelicula[j] = idPelicula[j+1];
                    idPelicula[j+1] = auxID;

                    auxAnyo = anyoPelicula[j];
                    anyoPelicula[j] = anyoPelicula[j+1];
                    anyoPelicula[j+1] = auxAnyo;

                    auxCategoria = categoriaPelicula[j];
                    categoriaPelicula[j] = categoriaPelicula[j+1];
                    categoriaPelicula[j+1] = auxCategoria;

                    auxDisponibilidad = disponibilidadPelicula[j];
                    disponibilidadPelicula[j] = disponibilidadPelicula[j+1];
                    disponibilidadPelicula[j+1] = auxDisponibilidad;
                }
            }
        }
    }
}