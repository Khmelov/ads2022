package by.it.group151002.bobrik.lesson11;


import by.it.HomeWork;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_11 extends HomeWork {

    @Test
    public void testTaskA() throws Exception {
        TaskA g = new TaskA();
        int v = 9;
        g.v = v;
        g.adj = new int[v][v];
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1,2);
        g.addEdge(1,4);;
        g.addEdge(2,5);
        g.addEdge(4, 5);
        g.addEdge(5, 8);
        g.addEdge(3,6);
        g.addEdge(3,7);
        g.addEdge(6,7);
        g.initDFS();
        String actual = g.res;
        String expected = "0 1 2 5 4 8 3 6 7 ";
        assertTrue("DFS incorrect", expected.equals(actual));
        String actualPre = Arrays.toString(g.pre);
        int[] expectedPreArr = {0, 1, 2, 12, 4, 3, 13, 14, 6};
        String expectedPre = Arrays.toString(expectedPreArr);
        assertTrue("PRE Values are incorrect", expectedPre.equals(actualPre));
        String actualPost = Arrays.toString(g.post);
        int[] expectedPostArr = {11, 10, 9, 17, 5, 8, 16, 15, 7};
        String expectedPost = Arrays.toString(expectedPostArr);
        assertTrue("POST Values are Incorrect", expectedPost.equals(actualPost));
    }




}