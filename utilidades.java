
package tabla.de.frecuencia;
import java.util.LinkedList;


public class utilidades {
    
    public static void TablaFrecuencia(LinkedList<Double> datos,Double C){
         LinkedList<LinkedList<Integer>> TyH = new LinkedList();
         LinkedList<Double> intervalo = new LinkedList();
         Double[] frecuencia,frecuenciaA,frecuenciaR,frecuenciaAR;
         int j = 1;
         Double rango = datos.get(0),total = 0.0,ar = 0.0,MC;
         TalloRama(datos, TyH);
        
         do{
             intervalo.offer(rango);
             rango += C;
         }while(rango < datos.get(datos.size()-1));
         intervalo.offer(rango);
         
         System.out.println("\n -- Rango --");
         for(int i = 0;i < intervalo.size();i++){
             System.out.print(" "+intervalo.get(i)+" ");
         }
         
         frecuencia = new Double[intervalo.size()-1];
         frecuenciaA = new Double[intervalo.size()-1];
         frecuenciaAR = new Double[intervalo.size()-1];
         frecuenciaR = new Double[intervalo.size()-1];
         inicializar(frecuencia);
         inicializar(frecuenciaA);
         inicializar(frecuenciaR);
         inicializar(frecuenciaAR);
         
         for(int i = 0;i < datos.size();i++){
             if(datos.get(i) >= intervalo.get(j-1) && datos.get(i) <= intervalo.get(j) && (j-1) == 0){
                 frecuencia[j-1] +=1;
             }else if(datos.get(i) > intervalo.get(j-1) && datos.get(i) <= intervalo.get(j)){
                 frecuencia[j-1] +=1;
             }else{
                 j += 1;
                 i -=1;
             }
         }
        j = 0; 
        System.out.println("\n-- Frecuencia -- ");
        for (Double frecuencia1 : frecuencia) {
            System.out.print(" "+frecuencia1+" ");
            total += frecuencia1;
            frecuenciaA[j] = total;
            frecuenciaR[j] = (frecuencia1/datos.size());
            j++;
        }
        j = 0;
        for(Double f:frecuenciaR){
            ar += f;
            frecuenciaAR[j] = ar;
            j++;
        }
         j = 1;
         System.out.println("\n\nTotal: "+total+"\n");
         System.out.println(" Intervalo de Clase \t Frecuencia \t Marca de Clase    F.A.\t     F.R.    F.A.R");
         for(int i = 0;i < frecuencia.length;i++){
             MC = (intervalo.get(j-1)+intervalo.get(j))/2;
             if(i == 0)
                 System.out.printf("%.2f <= x <= %.2f \t    %.2f \t      %.2f \t   %.2f    %.4f   %.4f %n",intervalo.get(j-1),intervalo.get(j),frecuencia[i],MC,frecuenciaA[i],frecuenciaR[i],frecuenciaAR[i]);
             else
                 System.out.printf("%.2f  < x <= %.2f \t    %.2f \t      %.2f \t   %.2f    %.4f   %.4f %n",intervalo.get(j-1),intervalo.get(j),frecuencia[i],MC,frecuenciaA[i],frecuenciaR[i],frecuenciaAR[i]);
             
             j++;
         }
         System.out.println("");
    }
    
    public static LinkedList<LinkedList<Integer>> TalloRama(LinkedList<Double> datos,LinkedList<LinkedList<Integer>> TyH){
       
        int entero,max,min;
        double decimal;
        //Verifica si hay numero decimales o enteros
        if(!isDecimal(datos)){
            max = (int)(datos.get(datos.size()-1)/10);
            min = (int)(datos.get(0)/10);
        }else{
            max = datos.get(datos.size()-1).intValue();
            min = datos.get(0).intValue();
        }
        //crea las listas dependiendo los valores que haya
        for(int i = min;i <= max;i++){
            TyH.add(new LinkedList());
        }
//        System.out.println("TyM size(): "+TyH.size());
        //** Verifica que si en los datos ingresados hay número enteros o hay números con decimales (se trabajaran diferentes con cada uno de ellos) **
        if(!isDecimal(datos)){
//            System.out.println("Todos son enteros");
              for(int i = 0;i < datos.size();i++){
                  //** Obtiene la decena dividiendo entre 10 y sacando la parte entera**
                  entero = (int)(datos.get(i)/10);
                  //** Obtiene la unidad restando la decena obtenida anteriormente por 10**
                  decimal = (datos.get(i)-(entero*10));
                  //** Lo guarda el la lista**
                  TyH.get(entero-min).offer((int)decimal);
              }

        }else{
//            System.out.println("Hay algun decimal");
            for(int i = 0;i<datos.size();i++){
                //obtiene el valor entero del numero
                entero = datos.get(i).intValue();
                //** Obtiene el valor decimal del número **
                decimal = (datos.get(i)- (double)entero);
//                System.out.println("decimal = "+datos.get(i)+" - "+(double)entero+" = "+(datos.get(i)-(double)entero));
//                System.out.println("redondeando: "+(Math.round(decimal*100.0)/100.0));
                //** Redondea ese número para no tener fallos y lo convierte a entero **
                decimal = ((Math.round(decimal*100.0)/100.0)*10);
//                System.out.println(" entero: "+(double)entero+" decimal: "+decimal);
                // ** Lo guarda en la Lista dependiendo la unidad con la que empieza **
                TyH.get(entero-min).offer((int)decimal);
            }
        }
//        for(int i = 0;i < TyH.size();i++){
//            for(int j = 0;j < TyH.get(i).size();j++){
//                System.out.println("TyM("+i+") size(): "+TyH.get(i).size());
//            }
//        }
//        for(int i = 0;i < TyH.size();i++){
//            System.out.print("i = "+(i+min)+" j size() = "+TyH.get(i).size());
//            for(int j = 0;j < TyH.get(i).size();j++){
//                System.out.print(" -> ");
//                System.out.print(" | "+TyH.get(i).get(j)+" | ");
//            }
//            System.out.println("");
//        }
        System.out.println(" Talla \t     Hoja");
        for(int i = min;i <= max;i++){
            System.out.print("   "+i+"\t   ");
            for(int j = 0;j < TyH.get(i-min).size();j++){
                System.out.print(TyH.get(i-min).get(j)+"  ");
            }
            System.out.println("");
        }
        return TyH;
    }
    public static void burbuja(LinkedList<Double> datos)
    {
      Double auxiliar;
      int tam = datos.size();
      Double[] arregloOrdenado = new Double[tam];
      
      for(int i = 0;i<tam;i++){
          arregloOrdenado[i] = datos.poll();
      }
      
      for(int i = 1; i < arregloOrdenado.length; i++)
      {
        for(int j = 0;j < arregloOrdenado.length-i;j++)
        {
          if(arregloOrdenado[j] > arregloOrdenado[j+1])
          {
            auxiliar = arregloOrdenado[j];
            arregloOrdenado[j] = arregloOrdenado[j+1];
            arregloOrdenado[j+1] = auxiliar;
          }   
        }
      }
      
      for(int i = 0;i<tam;i++){
          datos.offer(arregloOrdenado[i]);
      }
    }
    public static void inicializar(Double[] arreglo){
        for (int i = 0;i < arreglo.length;i++){
            arreglo[i] = 0.0;
        }
    } 
    public static boolean isDecimal(LinkedList<Double> datos){
        
        for(int i = 0;i<datos.size();i++){
            if(datos.get(i) != datos.get(i).intValue()){
                return true;
            }
        }
        return false;
    }
}
