package edu.escuelaing.arep;

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


public class LinkedListTest  {
    private static Double TOLERANCE=0.1d;

    /**
     * Rigourous Test :-)
     */
    @Test
    public void sizeTest(){
        LinkedList<String> list = new LinkedList<String>();
        assertEquals(0, list.size());

        list.add("Hello");
        assertEquals(1, list.size());
        list.add("Val");
        assertEquals(2, list.size());
        list.add("Pis");
        assertEquals(3, list.size());
        list.remove("Val");
        assertEquals(2, list.size());
    }

    @Test
    public void addTest(){
        LinkedList<String> list = new LinkedList<String>();
        String[] originalList = {"1", "2", "3", "4", "-1", "6"};
        for(String a : originalList){
            list.add(a);
        }
        assertEquals(list.toArray(), originalList);


        LinkedList<Boolean> list1 = new LinkedList<Boolean>();
        Boolean[] originalList1 = {true, true, false, true, false, true, true, true, false};
        for(boolean a : originalList1){
            list1.add(a);
        }
        assertEquals(list1.toArray(), originalList1);


        LinkedList<Float> list2 = new LinkedList<Float>();
        Float[] originalList2 = {1.4f, 1.55f, 4f, 55.6f};
        for(Float a : originalList2){
            list2.add(a);
        }
        assertEquals(list2.toArray(), originalList2);
    }


    @Test
    public void shouldNotRemoveTest(){
        LinkedList<String> list = new LinkedList<String>();
        assertFalse(list.remove("e"));
        list.add("Hello");
        list.add("HHH");
        assertFalse(list.remove("e"));



        LinkedList<Boolean> list1 = new LinkedList<Boolean>();
        list1.add(true);
        list1.add(true);
        assertFalse(list.remove(false));
    }

    @Test
    public void shouldRemoveTest(){
        LinkedList<String> list = new LinkedList<String>();
        list.add("Hello");
        list.add("Add");
        list.add("Man");
        assertTrue(list.remove("Hello"));
        assertEquals(list.toArray(), new String[]{"Add", "Man"});


        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("Hello");
        list1.add("Add");
        list1.add("Tee");
        list1.add("Man");

        assertTrue(list1.remove("Add"));
        assertEquals(list1.toArray(), new String[]{"Hello", "Tee","Man"});
    }


    @Test
    public void shouldInsertAll(){
        ArrayList places = new ArrayList();
        places.add(true);
        places.add("Hello");
        places.add("e");
        places.add(1);
        LinkedList<String> list= new LinkedList<String>();
        list.addAll(places);

        assertEquals(new Object[]{true, "Hello", "e", 1}, list.toArray());
    }

    
}
