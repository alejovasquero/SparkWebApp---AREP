package edu.escuelaing.arep;

import edu.escuelaing.arep.MediaHandlers.HTMLHandler;
import edu.escuelaing.arep.collections.LinkedList;
import javafx.print.Collation;
import junit.framework.TestCase;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import jdk.internal.jline.internal.TestAccessible;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;


public class HTMLHandlerTest  {
    private static Double TOLERANCE=0.1d;

    /**
     * Rigourous Test :-)
     */
    @Test
    public void openTest(){
        HTMLHandler h = new HTMLHandler("src/test/resources/HTMLHandler/Test1.txt");
        assertEquals(h.getData(), "Este es un mensaje de prueba.");

        h = new HTMLHandler("src/test/resources/HTMLHandler/Test2.txt");
        assertEquals(h.getData(), "Hello, testing.");

        h = new HTMLHandler("src/test/resources/HTMLHandler/Test3.txt");
        assertEquals(h.getData(), "Palabra abc abc eee abc");
    }

    @Test
    public void replaceTest(){
        HTMLHandler h = new HTMLHandler("src/test/resources/HTMLHandler/Test1.txt");
        h.replace("Este", "PESTE");
        assertEquals(h.getData(), "PESTE es un mensaje de prueba.");

        h = new HTMLHandler("src/test/resources/HTMLHandler/Test2.txt");
        h.replace("testing", "success");
        assertEquals(h.getData(), "Hello, success.");

        h = new HTMLHandler("src/test/resources/HTMLHandler/Test3.txt");
        h.replace("abc", "dfg");
        assertEquals(h.getData(), "Palabra dfg dfg eee dfg");
    }




}
