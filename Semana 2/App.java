import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class App {
    public static void main(String[] args) throws IOException {
        // saludarRepetitivo(5);
        // System.out.println(esPar(4));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // System.out.println("Ingrese un valor numérico:");
        // int valorIngresado = Integer.parseInt(br.readLine());

        // if(esPar(valorIngresado)) {
        //     System.out.println("El número ingresado es par");
        // } else {
        //     System.out.println("El número ingresado es inpar");
        // }
        
        Calculadora calc = new Calculadora();

        // System.out.println("Ingrese el primer valor:");
        // int x = Integer.parseInt(br.readLine());
        
        // System.out.println("Ingrese el segundo valor:");
        // int y = Integer.parseInt(br.readLine());

        // System.out.println("Ingrese el tercer valor:");
        // int z = Integer.parseInt(br.readLine());

        // System.out.println("El maximo valor ingresado es: " + calc.numMax(x, y, z));

        // saludar(true, "BT");












        // 1. Crear 4 métodos en la clase Calculadora:
        // - sumar
        // - restar
        // - multiplicar
        // - dividir

        // 2. Solicitar por consola la operación a realizar:
        // - s: sumar
        // - r: restar
        // - m: multiplicar
        // - d: dividir

        // System.out.println("Ingrese el tipo de operacion:");
        // char operacion = br.readLine().charAt(0);

        // // 3. Solicitar 2 números para realizar la operación
        // int x = 0, y = 0;

        // System.out.println("Ingrese el primer valor:");
        // x = Integer.parseInt(br.readLine());

        // System.out.println("Ingrese el segundo valor:");
        // y = Integer.parseInt(br.readLine());
        
        // // 4. Mostrar el resultado de la operación
        // int resultado = 0;
        // String nombreOperacion = "";
        //  switch(operacion) {
        //     case 's':
        //         resultado = calc.sumar(x, y);
        //         nombreOperacion = "sumar";
        //         break;
        //     case 'r':
        //         resultado = calc.restar(x, y);
        //         nombreOperacion = "restar";
        //         break;
        //     case 'm':
        //         resultado = calc.multiplicar(x, y);
        //         nombreOperacion = "multiplicar";
        //         break;
        //     case 'd':
        //         resultado = calc.dividir(x, y);
        //         nombreOperacion = "dividir";
        //         break;
        // }

        // System.out.println(String.format("El resultado de %s el numero %d y el numero %d es igual a %d", nombreOperacion, x, y, resultado));
        //     // Ejm:  "El resultado de restar el número 5 y el número 2 es igual a 3"

        System.out.println("Ingrese el numero limite:");
        int num = Integer.parseInt(br.readLine());
        calc.fibonacci(num);
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