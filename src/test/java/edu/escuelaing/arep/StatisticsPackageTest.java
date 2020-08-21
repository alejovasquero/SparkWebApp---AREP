package edu.escuelaing.arep;

import edu.escuelaing.arep.Statistics.StatisticsPackage;
import edu.escuelaing.arep.collections.LinkedList;
import junit.framework.TestCase;



import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
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


public class StatisticsPackageTest  {
    private static Double TOLERANCE=0.1d;

    @Test
    public void shouldCalculateMean(){
        String file = "src/test/resources/Statistics/Test1.txt";
        LinkedList<Double> l = new LinkedList<Double>();
        StatisticsPackage.readSamples(file, l);
        assertTrue(Math.abs(StatisticsPackage.calculateMean(l)- 550.6)< TOLERANCE);

        file = "src/test/resources/Statistics/Test2.txt";
        l = new LinkedList<Double>();
        StatisticsPackage.readSamples(file, l);
        assertTrue(Math.abs(StatisticsPackage.calculateMean(l)- 60.32)< TOLERANCE);


        file = "src/test/resources/Statistics/Test3.txt";
        l = new LinkedList<Double>();
        StatisticsPackage.readSamples(file, l);
        assertTrue(Math.abs(StatisticsPackage.calculateMean(l)- 638.9)< TOLERANCE);
    }


    @Test
    public void shouldCalculateDeviation(){
        String file = "src/test/resources/Statistics/Test1.txt";
        LinkedList<Double> l = new LinkedList<Double>();
        StatisticsPackage.readSamples(file, l);
        assertTrue(Math.abs(StatisticsPackage.calculateDeviation(l)- 572.03)< TOLERANCE);

        file = "src/test/resources/Statistics/Test2.txt";
        l = new LinkedList<Double>();
        StatisticsPackage.readSamples(file, l);
        assertTrue(Math.abs(StatisticsPackage.calculateDeviation(l)- 62.26)< TOLERANCE);

        file = "src/test/resources/Statistics/Test3.txt";
        l = new LinkedList<Double>();
        StatisticsPackage.readSamples(file, l);
        assertTrue(Math.abs(StatisticsPackage.calculateDeviation(l)- 625.633981)< TOLERANCE);
    }
}
