
package tabla.de.frecuencia;

import java.util.LinkedList;
import java.util.Scanner;


public class TablaDeFrecuencia {

    
    public static void main(String[] args) {
        LinkedList<Double> datos = new LinkedList();
        Scanner leer = new Scanner(System.in);
        Double dato,C = 1.0;
        // *** Descomente estas líneas para probar el programa ***
//        Double[] num = {44.0,45.0,49.0,50.0,52.0,53.0,53.0,54.0,54.0,56.0,57.0,57.0,57.0,58.0,61.0,62.0,62.0,63.0,64.0,67.0,68.0,69.0,70.0,71.0,71.0,72.0,73.0,74.0,74.0,75.0,76.0,76.0,78.0,79.0,80.0,81.0,83.0,85.0};
//        Double[] num2 = {2.6,3.2,4.8,2.9,5.3,4.7,7.9,3.2,4.5,6.8,2.5,4.5,6.2,6.3,8.0,7.2,4.0,5.2,2.6,3.9,3.9,5.0,4.8,3.8,4.8,3.9,3.1,6.9,3.6,6.2,6.1,3.6,5.7,4.1,4.5,2.8,5.7,3.4,8.2,5.6,3.4,3.7,6.1,
//          2.5,4.6,4.6,4.5,5.2,3.6,5.9,4.5,4.6,6.3,4.1,3.2,6.0,3.6,4.3,3.8,5.0};

        //*** Comentar de la línea 21 hasta la 30 para usar el programa manualmente***
        int n;
        System.out.print("\n Ingrese el valor de C: ");
        C = leer.nextDouble();
        System.out.print("\n Numero de datos: ");
        n = leer.nextInt();
        for(int i = 0;i<n;i++){
            System.out.print(" Dato "+(i+1)+" : ");
            dato = leer.nextDouble();
            datos.add(dato);
        }

        //*** Descomentar una de estas dos para probar con la lita que desee***
        //vaciar(num2,datos);
        //vaciar(num, datos);
        
        //ordena los datos ingresados por el método burbuja
        utilidades.burbuja(datos);
        
//        for(int i = 0;i<datos.size();i++){
//            System.out.print(" | "+datos.get(i) +" | ");
//        }

        utilidades.TablaFrecuencia(datos,C);
    }
    public static void vaciar(Double[] arreglo,LinkedList<Double> datos){
        for (Double arreglo1 : arreglo) {
            datos.offer(arreglo1);
        }
    }
}
