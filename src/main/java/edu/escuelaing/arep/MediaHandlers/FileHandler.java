package edu.escuelaing.arep.MediaHandlers;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

/**
 * Manejador para lectura y escritura de archivos
 * @author Alejandro Vasquez
 */
public class FileHandler {
    private File file;
    public FileHandler(String file){
        this.file=openFile(file);
    }

    /**
     * Retorna el archivo con el nombre seleccionado
     * @param name Nombre o ruta del archivo
     * @return Objeto archivo
     */
    public static File openFile(String name){
        File file = new File(name);
        return file;
    }

    /**
     * Retorna una coleccion que contiene todas las lineas del archivo especificado
     * @param collection Coleccion donde se vana guardar las lineas
     * @throws IOException
     */
    public void getNumberLines(Collection<Double> collection) throws IOException {
        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = br.readLine()) != null) {
            collection.add(Double.parseDouble(line));
        }
        in.close();
        br.close();
    }

    /**
     * Cambia el archivo especificado para hacer lectura o escritura
      * @param name Nombre del archivo
     */
    public void changeFile(String name){
        this.file=openFile(name);
    }


}
