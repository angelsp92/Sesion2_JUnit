/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* UtilsJUnit3Test: setUp() method");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* UtilsJUnit3Test: tearDown() method");
    }

    /**
     * Test of concatWords method, of class Utils.
     */
    
    /*
    //Eliminamos el codigo por defecto
    @Test
    public void testConcatWords() {
        System.out.println("concatWords");
        String[] words = null;
        String expResult = "";
        String result = Utils.concatWords(words);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    @Test
    public void testHelloWorld() {
        System.out.println("* UtilsJUnit3Test: test method 1 - testHelloWorld()");
        assertEquals("Hello, world!", Utils.concatWords("Hello", ", ", "world", "!"));
    }

    /**
     * Test of computeFactorial method, of class Utils.
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.TimeoutException
     */
    
    /*
    //Eliminamos el codigo por defecto
    @Test
    public void testComputeFactorial() {
        System.out.println("computeFactorial");
        int number = 0;
        String expResult = "";
        String result = Utils.computeFactorial(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype."); 
    }
    */
    
    @Ignore
    @Test
    public void testWithTimeout() throws InterruptedException, TimeoutException {
        System.out.println("* UtilsJUnit3Test: test method 2 - testWithTimeout()");
        final long factorialOf = 1 + (long) (30000 * Math.random());
        System.out.println("computing " + factorialOf + '!');

        Thread testThread = new Thread() {
            @Override
            public void run() {
                System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
            }
        };
        
        testThread.start();
        Thread.sleep(1000);
        testThread.interrupt();

        if (testThread.isInterrupted()) {
            throw new TimeoutException("the test took too long to complete");
        }
    }
    
    @Test
    public void testExpectedException() {
        System.out.println("* UtilsJUnit3Test: test method 3 - testExpectedException()");
        try {
            final int factorialOf = -5;
            System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
            fail("IllegalArgumentException was expected");
        } catch (IllegalArgumentException ex) {
        }
    }

    /**
     * Test of normalizeWord method, of class Utils.
     */
    
    /*
    //Eliminamos el codigo por defecto
    @Test
    public void testNormalizeWord() {
        System.out.println("normalizeWord");
        String word = "";
        String expResult = "";
        String result = Utils.normalizeWord(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    @Ignore
    @Test
    public void testTemporarilyDisabled() throws Exception {
        System.out.println("* UtilsJUnit3Test: test method 4 - checkExpectedException()");
        assertEquals("Malm\u00f6", Utils.normalizeWord("Malmo\u0308"));
    }
    
}
