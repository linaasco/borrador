import java.util.Scanner;
import java.util.HashMap;
public class borrador {


    static HashMap<String, String> nombre_laboral = new HashMap<>();

    static HashMap<String, String> horarios = new HashMap<>();
    static HashMap<String, String> cedula = new HashMap<>();
    static HashMap<String, String> mensajes = new HashMap<>();
    static HashMap<String, String> roles = new HashMap<>();
    static String nombre;
    static String codigo;
    static String rol;
    static String CC;
    static String chat;
    static String horario = "";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de administracion de horarios.");
        while (true) {

            System.out.println("1. Ingresar Usuario");
            System.out.println("2. Crear Usuario");


            System.out.println("Ingrese el numero de la opcion deseada :");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    IngresarUsuario(scanner);
                    break;

                case 2:
                    RegistrarUsuario(scanner);
                    break;

            }
        }
    }

    public static void IngresarUsuario(Scanner scanner) {
        System.out.println("Ingrese el código de usuario");
        codigo = scanner.next();
        if (nombre_laboral.containsKey(codigo)) {
            nombre = nombre_laboral.get(codigo);


            System.out.println("Los datos del usuario con código: " + codigo);
            System.out.println("Nombre: " + nombre);
            System.out.println("Rol :" + rol);
            System.out.println("Cedula: " + CC);

        } else
            System.out.println("NO existe un usuario con el código " + codigo);

    }

    public static void RegistrarUsuario(Scanner scanner) {

        System.out.println("Ingrese el código de usuario");
        codigo = scanner.next();
        if (!nombre_laboral.containsKey(codigo)) {
            scanner.nextLine();

            System.out.println("Ingrese el nombre de usuario");
            nombre = scanner.nextLine();

            System.out.println("Ingrese el rol de usuario");
            rol = scanner.nextLine();

            System.out.println("Ingrese su cedula ");
            CC = scanner.nextLine();


            nombre_laboral.put(codigo, nombre);
            roles.put(codigo, rol);
            cedula.put(codigo, CC);

        }
    }

    public static void administrarHorarios(String nombre, String rol) {
        System.out.println("Usuario: " + nombre);
        System.out.println("Rol: " + rol);

        switch (rol.toLowerCase()) {
            case "administrador":
                administradorOpciones();
                break;
            case "gerente":
                gerenteOpciones();
                break;
            case "empleado":
                empleadoOpciones();
                break;
            default:
                usuarioNoValido();
                break;
        }
    }

    public static void administradorOpciones() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones disponibles para administradores:");
            System.out.println("1. Ver Horario");
            System.out.println("2. Crear Horario");
            System.out.println("3. Modificar horario");
            System.out.println("4. Eliminar horario");
            System.out.println("5. Enviar mensaje a un gerente");
            System.out.println("6. Salir");

            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (horario.isEmpty()) {
                        System.out.println("No se ha creado ningun horario.");
                    } else {
                        System.out.print("Ingrese el codigo del empleado : ");
                        codigo = scanner.next();
                        if (nombre_laboral.containsKey(codigo)) {
                            nombre = nombre_laboral.get(codigo);
                            horario = horarios.get(codigo);
                            System.out.println("Los datos del usuario con código: " + codigo);
                            System.out.println("Nombre: " + nombre);
                            System.out.println("El horario actual es: " + horario);

                        }
                        break;
                        case 2:
                            System.out.print("Ingrese el codigo del empleado : ");
                            codigo = scanner.next();
                            if (nombre_laboral.containsKey(codigo)) {

                                System.out.println("Registre el horario");
                                horario = scanner.next();

                                horarios.put(codigo, horario);
                            }

                            System.out.println("Se ha creado el horario exitosamente.");

                            break;
                        case 3:
                            if (horario.isEmpty()) {
                                System.out.println("No se ha creado ningún horario.");
                            } else {
                                System.out.println("Ingrese el código del usuario");
                                codigo = scanner.next();
                                if (horarios.containsKey(codigo)) {
                                    scanner.nextLine();
                                    System.out.println("Ingresa el nuevo horario del usuario");
                                    horario = scanner.nextLine();
                                    horarios.put(codigo, horario);
                                } else {
                                    System.out.println("NO existe un estudiante con el código " + codigo);
                                }
                                break;
                                case 4:
                                    System.out.println("Ingrese el código del usuario");
                                    codigo = scanner.next();
                                    horarios.remove(codigo);
                                    break;
                                case 5:
                                    System.out.print("Ingrese el codigo del gerente : ");
                                    codigo = scanner.next();
                                    if (nombre_laboral.containsKey(codigo)) {

                                        System.out.println("Ingrese el mensaje a enviar");
                                        chat = scanner.nextLine();
                                        mensajes.put(codigo, chat);
                                    }

                                    System.out.println("Se ha enviado el mensaje satisfactoriamente a " + codigo + ".");

                                    break;

                                case 6:
                                    return;
                                default:
                                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                                    break;
                            }
                    }
            }

            public static void gerenteOpciones() {
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("\nOpciones disponibles para gerentes:");
                    System.out.println("1. Ver horario");
                    System.out.println("2. Solicitar cambios en el horario");
                    System.out.println("3. Enviar mensaje a un empleado");
                    System.out.println("4. Salir");

                    System.out.print("Ingrese el numero de la opcion deseada: ");
                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese el codigo del empleado : ");
                            codigo = scanner.next();
                            if (nombre_laboral.containsKey(codigo)) {
                                nombre = nombre_laboral.get(codigo);
                                horario = horarios.get(codigo);
                                System.out.println("Los datos del usuario con código: " + codigo);
                                System.out.println("Nombre: " + nombre);
                                System.out.println("El horario actual es: " + horario);

                            }
                            break;
                        case 2:
                            System.out.print("Ingrese el codigo del administrador : ");
                            codigo = scanner.next();
                            if (nombre_laboral.containsKey(codigo)) {

                                System.out.println("Ingrese el mensaje a enviar");
                                chat = scanner.nextLine();
                                mensajes.put(codigo, chat);
                                System.out.println("El mensaje se envio con exito a " + codigo);
                                break;
                            }
                                case 3:
                                    System.out.print("Ingrese el codigo del empleado : ");
                                    codigo = scanner.next();
                                    if (nombre_laboral.containsKey(codigo)) {

                                        System.out.println("Ingrese el mensaje a enviar");
                                        chat = scanner.nextLine();
                                        mensajes.put(codigo, chat);
                                        System.out.println("El mensaje se envio con exito a " + codigo);
                                    }
                                    break;
                                        case 4:
                                            return;
                                        default:
                                            System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                                            break;
                                    }
                            }
                    }

                    public static void empleadoOpciones() {
                        Scanner scanner = new Scanner(System.in);

                        while (true) {
                            System.out.println("\nOpciones disponibles para empleados:");
                            System.out.println("1. Ver horario");
                            System.out.println("2. Salir");

                            System.out.print("Ingrese el numero de la opcion deseada: ");
                            int opcion = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcion) {
                                case 1:
                                    System.out.print("Ingrese su codigo : ");
                                    codigo = scanner.next();
                                    if (nombre_laboral.containsKey(codigo)) {
                                        nombre = nombre_laboral.get(codigo);
                                        horario = horarios.get(codigo);
                                        if (horario.isEmpty()) {
                                            System.out.println("No se ha creado ningun horario.");
                                        } else {
                                            System.out.println("Los datos del usuario con código: " + codigo);
                                            System.out.println("Nombre: " + nombre);
                                            System.out.println("El horario actual es: " + horario);
                                        }

                                        break;
                                        case 2:
                                            return;
                                        default:
                                            System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                                            break;
                                    }
                            }
                        }


                        public static void usuarioNoValido() {
                            System.out.println("...");
                            System.out.println("Usuario no valido.");
                            System.out.println("Por favor revise que el rol este bien escrito o contacte al administrador del sistema.");
                        }
                    }
                }
            }
        }



