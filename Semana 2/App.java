import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // CalculadoraCientifica calc = new CalculadoraCientifica();
        
        // System.out.println("Ingrese el numero limite:");
        // int num = Integer.parseInt(br.readLine());
        // calc.fibonacci(num);

        // System.out.println("Ingrese el primer numero:");
        // int x = Integer.parseInt(br.readLine());

        // System.out.println("Ingrese el segundo numero:");
        // int y = Integer.parseInt(br.readLine());

        // System.out.println("Ingrese el tercer numero:");
        // int z = Integer.parseInt(br.readLine());

        // System.out.println(String.format("El resultado de sumar el numero %d, el numero %d y el numero %d es:", x, y, z));
        // System.out.println(calc.sumar(x, y, z));

        // Forma forma = new Forma();
        // Cuadrado cuadrado = new Cuadrado();
        // System.out.println(cuadrado.calcularArea());

        // Circulo circulo = new Circulo();
        // System.out.println(circulo.calcularArea());

        // Rectangulo rectangulo = new Rectangulo();
        // System.out.println(rectangulo.calcularArea());

        Alumno alumno = new Alumno();
        
        System.out.println("Ingrese el apellido paterno");
        alumno.setApellidoPaterno(br.readLine());

        System.out.println("Ingrese el apellido materno");
        alumno.setApellidoMaterno(br.readLine());

        System.out.println("Ingrese los nombres");
        alumno.setNombres(br.readLine());

        System.out.println("Ingrese el codigo universitario");
        alumno.setCodigoUniversitario(br.readLine());

        System.out.println("Ingrese el ciclo de ingreso");
        alumno.setCicloIngreso(br.readLine());

        System.out.println(String.format("Bienvenido %s %s %s, tu codigo es: %s y tu ciclo de ingreso es: %s", alumno.getApellidoPaterno(),alumno.getApellidoMaterno(),alumno.getNombres(),alumno.getCodigoUniversitario(),alumno.getCicloIngreso()));
    }

    public static void saludar(boolean mostrarNombre, String tipoSaludo){
        String saludo = "";

        switch(tipoSaludo) {
            case "B":
                saludo = "Bienvenido";
                break;
            case "H":
                saludo = "Hola";
                break;
            case "BT":
                saludo = "Buenas tardes";
                break;
        }

        if(mostrarNombre) {
            System.out.println(generarSaludo("Andy", saludo));
        } else {
            System.out.println(generarSaludo(saludo));
        }
    }

    public static void saludarRepetitivo(int x) {
        /* for(int i = 0; i < x; i++) {
            System.out.println(generarSaludo("Andy"));
        }*/ 

        int i = 1;
        while(i < x) {
            System.out.println(generarSaludo("Andy", "Hola"));
            i++;
        }
    }

    public static String generarSaludo(String nombre, String saludo) {
        return saludo + " " + nombre + "!";
    }

    public static String generarSaludo(String saludo) {
        return saludo + "!";
    }

    // DESARROLLAR LÓGICA DE LA FUNCIÓN PARA DETERMINAR SI UN NÚMERO ES PAR
    public static boolean esPar(int x) {
        return x % 2 == 0;
    }

    // DESARROLLAR LÓGICA DE LA FUNCIÓN PARA DETERMINAR SI UN NÚMERO ES PRIMO
    public static boolean esPrimo(int x) {
        for (int i = 2; i < x / 2; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// App.main(arr);

// App.saludar(arr); <- ERROR

// App obj = new App();
// obj.saludar(); <- OK