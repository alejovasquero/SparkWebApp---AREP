package edu.escuelaing.arep.Statistics;

import edu.escuelaing.arep.MediaHandlers.FileHandler;
import edu.escuelaing.arep.collections.LinkedList;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

/**
 * Paquete de funciones estadisticas con muestras poblacionales
 * @author Alejandro Vasquez
 */
public class StatisticsPackage {

    /**
     * Calcula la media muestral de la coleccion de datos que se entrega
     * @param list Coleccion de datos que de la muestra
     * @return Promedio de los datos entregados
     */
    public static Double calculateMean(Collection<Double> list){
        Double ans = 0d;
        int n = list.size();
        for(Double d: list) {
            ans += d;
        }
        return ans/n;
    }


    /**
     * Calcula la desviacion estandar de una muestra de datos
     * @param list Collection que contiene los valores obtenidos de la muestra
     * @param mean Promedio de la poblacion que se ha entregado en la lista
     * @return Desviacion estandar calculada a partir de ls muestra y promedio de los datos
     */
    public static Double calculateDeviation(Collection<Double> list, double mean){
        Double ans = 0d;
        int n = list.size();
        for(Double d: list){
            ans+=Math.pow(d-mean, 2);
        }
        ans = ans /(n-1);
        return Math.sqrt(ans);
    }

    /**
     * Calcula la desviacion estandar de una muestra de datos
     * @param list Collection que contiene los valores obtenidos de la muestra
     * @return Desviacion estandar calculada a partir de ls muestra y promedio calculado de la muestra
     */
    public static double calculateDeviation(Collection<Double> list){
        return calculateDeviation(list, calculateMean(list));
    }

    /**
     * Lee un archivo con muestra estadisticas para ser almacenadas en una coleccion
     * @param fileName Nombre del archivo a leer
     * @param collection Coleccion donde se van a guardar los datos
     */
    public static void readSamples(String fileName, Collection<Double> collection){
        FileHandler handler = new FileHandler(fileName);
        try {
            handler.getNumberLines(collection);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Especifique el nombre o ruta del archivo:  ");
        String file = scanner.nextLine();
        scanner.close();
        System.out.println(file);
        LinkedList<Double> col = new LinkedList<Double>() ;
        readSamples(file, col);
        System.out.printf("Promedio:   %.2f\n",calculateMean(col));
        System.out.printf("Desviacion estandar:   %.2f\n", calculateDeviation(col));
    }
}
