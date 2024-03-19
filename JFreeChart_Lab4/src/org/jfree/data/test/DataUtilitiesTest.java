package org.jfree.data.test;
import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class DataUtilitiesTest extends DataUtilities {
    private Mockery mockingContext;
    private Mockery mockingContext_2;
    
    private Values2D values;
    private KeyedValues values_2;
    
   
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() {
        mockingContext = new Mockery();
        values = mockingContext.mock(Values2D.class);

        // Common expectations for values object
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getRowCount();
                will(returnValue(3));

                allowing(values).getColumnCount();
                will(returnValue(3));

                // Setting values for column 1 
                allowing(values).getValue(0, 0);
                will(returnValue(7.5));
                allowing(values).getValue(1, 0);
                will(returnValue(2.5));
                allowing(values).getValue(2, 0);
                will(returnValue(3.5));
                
                
               //Setting values for column 2
                allowing(values).getValue(0, 1);
                will(returnValue(1.5));
                allowing(values).getValue(1, 1);
                will(returnValue(2.4));
                allowing(values).getValue(2, 1);
                will(returnValue(3.4));

                // Setting values for column 3
                allowing(values).getValue(0, 2);
                will(returnValue(0.0));
                allowing(values).getValue(1, 2);
                will(returnValue(4.2));
                allowing(values).getValue(2, 2);
                will(returnValue(7.9));
            }
        });
        
        
        mockingContext_2 = new Mockery();
        values_2 = mockingContext_2.mock(KeyedValues.class);
	    	ArrayList<Integer> keys = new ArrayList<Integer>();  
			keys.add(0);
			keys.add(1);
			keys.add(2);
        // Common expectations for values object
        mockingContext_2.checking(new Expectations() {
            {
		        allowing(values_2).getItemCount();
			    will(returnValue(3));
			        	
		        allowing(values_2).getKeys();
				will(returnValue(keys));
						
				allowing(values_2).getIndex(0);
				will(returnValue(0));
				allowing(values_2).getIndex(1);
				will(returnValue(1));
				allowing(values_2).getIndex(2);
				will(returnValue(2));
		
				allowing(values_2).getValue(0);
				will(returnValue(5));
				allowing(values_2).getValue(1);
				will(returnValue(9));
				allowing(values_2).getValue(2);
				will(returnValue(2));
		
				allowing(values_2).getKey(0);
				will(returnValue(0));
				allowing(values_2).getKey(1);
				will(returnValue(1));
				allowing(values_2).getKey(2);
				will(returnValue(2));
 
            }
        });
        
        
    }

    
	
	 @Test
	 public void calculateColumnTotalForTwoValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     assertEquals(result, 10.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 //-----------------------------------------------------------------------------------------------------------------------------------------------------

	
	 //Tests for calculateRowTotal(Values2D data, int row)
		
	 @Test
	 public void calculateRowTotalNull() {
	     try {
	         DataUtilities.calculateRowTotal(null, 0);
	         fail("Expected InvalidParameterException!");
	     } catch (InvalidParameterException e) {
	         // Expected exception, do nothing
	     } catch (Exception e) {
	         fail("Unexpected exception occurred: " + e.getMessage());
	     }
	 }


	  
		 @Test
		 public void firstRowIndex() {
		     
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     // verify
		     assertEquals(9.0, result, .000000001d);
		 }
		
		
		 @Test
		 public void MiddleRowIndex() {
	
			
		     double result = DataUtilities.calculateRowTotal(values, 1);
		     // verify
		     assertEquals(9.1, result, .000000001d);
		 }
		
		
		 @Test
		 public void lastRowIndex() {

		     double result = DataUtilities.calculateRowTotal(values, 2);
		     // verify
		     assertEquals(14.8, result, .000000001d);
		 }
		
		
		
		 
		 @Test
		 public void outOfBoundsRowIndex() {
		     try {
		         // Attempting to calculate the total of an out-of-bounds column index
		         double result = DataUtilities.calculateRowTotal(values, 3);
		         // If the column index is out of bounds, the method should return 0
		         assertEquals("Sum of a column with an out of bounds index is", 0, result, .000000001d);
		     } catch (Error error) {
		         // Handle the case where an error occurs
		         fail("An error occurred: " + error.getMessage());
		     } catch (Exception e) {
		         // Handle the case where an exception occurs
		         fail("Exception occurred: " + e.getMessage());
		     }
		 }

		 
		 
		 @Test
		 public void calculateRowTotalPositive() {
		 	Mockery mockingContext = new Mockery();
		 	final Values2D values = mockingContext.mock(Values2D.class);

		 	mockingContext.checking(new Expectations() {
		 		{
		 			one(values).getColumnCount();
		 			will(returnValue(3));

		 			one(values).getValue(0, 0);
		 			will(returnValue(0.1));

		 			one(values).getValue(0, 1);
		 			will(returnValue(0.3));

		 			one(values).getValue(0, 2);
		 			will(returnValue(0.1));
		 		}
		 	});
		 
		 	double result = DataUtilities.calculateRowTotal(values, 0);
		 	assertEquals("The row total is adding up to 0.5", 0.5, result, .000000001d);
		 }
		 
		 
		 @Test
		 public void calculateRowTotalNegative() {
		 	Mockery mockingContext = new Mockery();
		 	final Values2D values = mockingContext.mock(Values2D.class);

		 	mockingContext.checking(new Expectations() {
		 		{
		 			one(values).getColumnCount();
		 			will(returnValue(3));

		 			one(values).getValue(0, 0);
		 			will(returnValue(-1));

		 			one(values).getValue(0, 1);
		 			will(returnValue(-2));
		 			
		 			one(values).getValue(0, 2);
		 			will(returnValue(-2));
		 		}
		 	});
		 	
		 	double result = DataUtilities.calculateRowTotal(values, 0);
		 	assertEquals("The row total is adding up to -5.0", -5.0, result, .000000001d);
		 }


		
		 @Test
		 public void calculateRow_emptyRow() {
		        Mockery mockingContext = new Mockery();
		        final Values2D values = mockingContext.mock(Values2D.class);
		        mockingContext.checking(new Expectations() {
		            {
		            	one(values).getRowCount();
		                will(returnValue(1));
		                one(values).getColumnCount();
		                will(returnValue(1));
		                
		                allowing(values).getValue(0, 0);
		                will(returnValue(null));
	  
		            }
		        });
			
		     double result = DataUtilities.calculateRowTotal(values, 0);
		     // verify
		     assertEquals(0, result, .000000001d);
		 }
		 
		 //-----------------------------------------------------------------------------------------------------------------------------------------------------

		 
		 //Tests for calculateColumnTotal(Values2D data, int column)
 
		 
		 @Test
		 public void calculateColumnTotalNull() {
		     try {
		         DataUtilities.calculateColumnTotal(null, 0);
		         fail("Expected InvalidParameterException!");
		     } catch (InvalidParameterException e) {
		         // Expected exception, do nothing
		     } catch (Exception e) {
		         fail("Unexpected exception occurred: " + e.getMessage());
		     }
		 }
		 
		 
		 @Test 
		 public void firstColumnIndex() {
			 
			 
		 double result= DataUtilities.calculateColumnTotal(values, 0);
		 assertEquals("Sum of the column at the first index is",  13.5, result, .000000001d);
		 }
		 
		
		 
		 @Test 
		 public void middleColumnIndex() {
			 	
		 double result= DataUtilities.calculateColumnTotal(values, 1);
		     	assertEquals("Sum of the column is",  7.3, result, .000000001d);
		 }
		 
		 
		 @Test 
		 public void lastColumnIndex() {

		 double result= DataUtilities.calculateColumnTotal(values, 2);
		     	assertEquals("Sum of the column is",  12.1, result, .000000001d);
		 }
		 
		 @Test
		 public void outOfBoundsColumnIndex() {
		     try {
		         // Attempting to calculate the total of an out-of-bounds column index
		         double result = DataUtilities.calculateColumnTotal(values, 3);
		         // If the column index is out of bounds, the method should return 0
		         assertEquals("Sum of a column with an out of bounds index is", 0, result, .000000001d);
		     } catch (Error error) {
		         // Handle the case where an error occurs
		         fail("An error occurred: " + error.getMessage());
		     } catch (Exception e) {
		         // Handle the case where an exception occurs
		         fail("Exception occurred: " + e.getMessage());
		     }
		 }


		 
		 @Test
		 public void calculateColumnTotalPositive() {
		 	Mockery mockingContext = new Mockery();
		 	final Values2D values = mockingContext.mock(Values2D.class);

		 	mockingContext.checking(new Expectations() {
		 		{
		 			one(values).getRowCount();
		 			will(returnValue(3));

		 			one(values).getValue(0, 1);
		 			will(returnValue(0.1));

		 			one(values).getValue(1, 1);
		 			will(returnValue(0.3));

		 			one(values).getValue(2, 1);
		 			will(returnValue(0.1));
		 		}
		 	});
		 	int columnNumber = 1;
		 	double result = DataUtilities.calculateColumnTotal(values, columnNumber);
		 	assertEquals("The column total is adding up to 0.5", 0.5, result, .000000001d);
		 }
		 
		 
		 @Test
		 public void calculateColumnTotalNegative() {
		 	Mockery mockingContext = new Mockery();
		 	final Values2D values = mockingContext.mock(Values2D.class);

		 	mockingContext.checking(new Expectations() {
		 		{
		 			one(values).getRowCount();
		 			will(returnValue(3));

		 			one(values).getValue(0, 1);
		 			will(returnValue(-1000));
		 			
		 			one(values).getValue(1, 1);
		 			will(returnValue(-1));
		 			
		 			one(values).getValue(2, 1);
		 			will(returnValue(-1));
		 			

		 		}
		 	});
		 	int columnNumber = 1;
		 	double result = DataUtilities.calculateColumnTotal(values, columnNumber);
		 	assertEquals("The row total is adding up to -1002.0", -1002.0, result, .000000001d);
		 }


		 

		 
		 @Test
		 public void calculateColumn_emptyColumn() {
		        Mockery mockingContext = new Mockery();
		        final Values2D values = mockingContext.mock(Values2D.class);
		        mockingContext.checking(new Expectations() {
		            {
		                one(values).getRowCount();
		                will(returnValue(1));
		                one(values).getColumnCount();
		                will(returnValue(1));
		                
		                allowing(values).getValue(0, 0);
		                will(returnValue(null));
	  
		            }
		        });
			
		     double result = DataUtilities.calculateColumnTotal(values, 0);
		     // verify
		     assertEquals(0, result, .000000001d);
		 }
		 
		 //-----------------------------------------------------------------------------------------------------------------------------------------------------

		 
		 // Tests for getCumulativePercentages(KeyedValues data)

		 
		 @Test (expected = IllegalArgumentException.class)
		 public void Null() {
		 	DataUtilities.getCumulativePercentages(null);
		 }
		 
		 @Test 
		 public void firstValue() {
		     	KeyedValues result = DataUtilities.getCumulativePercentages(values_2);
		 	assertEquals("Cumulative percentage (element 0)", 0.3125, result.getValue(result.getKey(0)));
		    }
		 
		 


		 @Test
		 public void lastValue() {
		     	KeyedValues result = DataUtilities.getCumulativePercentages(values_2);
		 	assertEquals("Cumulative percentage (element 0)", 1.0, result.getValue(result.getKey(result.getKeys().size()-1)));
		     }
		 
		 @Test 
		 public void checkKeys() {
		     	KeyedValues result = DataUtilities.getCumulativePercentages(values_2);
		     	assertEquals("Resulting keys", result.getKeys(), values_2.getKeys());
		 }
		 
		 //-----------------------------------------------------------------------------------------------------------------------------------------------------

		 // Tests for createNumberArray(double[] data)
		 @Test
		 public void createNumberArrayNull() {
		     try {
		         double[] arrayToPass = null;
		         DataUtilities.createNumberArray(arrayToPass);
		         fail("This method should throw an exception!");
		     } catch (Exception e) {
		         assertEquals("The exception thrown type is InvalidParameterException", InvalidParameterException.class, e.getClass());
		     }
		 }

		 @Test
		 public void createNumberArrayZero() {
		 	Number[] expectedArray = { 0.0 };
		 	double[] arrayToPass = { 0.0 };
		 	Number[] actualArray = DataUtilities.createNumberArray(arrayToPass);
		 	assertArrayEquals("The expected array should contain double values of {0.0}", expectedArray, actualArray);
		 }

		 
		 @Test
		 public void createNumberArrayEmpty() {
		 	Number[] expectedArray = {};
		 	double[] arrayToPass = {};
		 	Number[] actualArray = DataUtilities.createNumberArray(arrayToPass);
		 	assertArrayEquals("The expected array should contain double values of {}", expectedArray, actualArray);
		 }

		 
		 @Test
		 public void createNumberArrayNegative() {
		 	Number[] expectedArray = { -1.5, -2.5, -3.5 };
		 	double[] arrayToPass = { -1.5, -2.5, -3.5 };
		 	Number[] actualArray = DataUtilities.createNumberArray(arrayToPass);
		 	assertArrayEquals("The expected array should contain double values of {-1.5, -2.5, -3.5}", expectedArray,
		 	actualArray);
		 }

		 
		 @Test
		 public void createNumberArrayPositive() {
		 	Number[] expectedArray = { 1.5, 2.5, 3.5 };
		 	double[] arrayToPass = { 1.5, 2.5, 3.5 };
		 	Number[] actualArray = DataUtilities.createNumberArray(arrayToPass);
		 	assertArrayEquals("The expected array should contain double values of {1.5, 2.5, 3.5}", expectedArray,
		 	actualArray);
		 }
		 
		 @Test
		 public void createNumberArrayMixed() {
		 	Number[] expectedArray = { 1.5, -1.5 };
		 	double[] arrayToPass = { 1.5, -1.5 };
		 	Number[] actualArray = DataUtilities.createNumberArray(arrayToPass);
		 	assertArrayEquals("The expected array should contain double values of {1.5, -1.5};", expectedArray,
		 	actualArray);
		 }
		 
		 
		 @Test
		 public void createNumberArrayMinDouble() {
		 	Number[] expectedArray = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE,                                      Double.MIN_VALUE };
		 	double[] arrayToPass = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE };
		 	Number[] actualArray = DataUtilities.createNumberArray(arrayToPass);
		 	assertArrayEquals("The expected array should contain 4 elements of the min double value;", expectedArray, actualArray);
		 }

		 @Test
		 public void createNumberArrayMaxDouble() {
		 	Number[] expectedArray = { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE,   Double.MAX_VALUE };
		 	double[] arrayToPass = { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };
		 	Number[] actualArray = DataUtilities.createNumberArray(arrayToPass);
		 	assertArrayEquals("The expected array should contain 4 elements of the max double value;", expectedArray, actualArray);	
		 }


		 //-----------------------------------------------------------------------------------------------------------------------------------------------------
		 
		 // Tests for createNumberArray2D(double[][] data)
		 
		 @Test
		 public void createnumber2DEmpty() {
		 	Number[][] expectedArray = { { 30.0, 35.0 }, {} };
		 	double[][] arrayToPass = { { 30.0, 35.0 }, {} };
		 	Number[][] actualArray = DataUtilities.createNumberArray2D(arrayToPass);
		 	assertArrayEquals("createNumberArray failed the correct array values are.", expectedArray, actualArray);
		 }
		 
		 @Test
		 public void createNumber2DNull() {
		 	try {
		 		double[][] arrayToPass = null;
		 		DataUtilities.createNumberArray2D(arrayToPass);
		 		fail("This method should throw an exception!");
		 	} catch (Exception e) {
		 		assertEquals("The exception thrown type is IllegalArgumentException", IllegalArgumentException.class, e.getClass());
		 		}
		 }
		 
		 @Test
		 public void createNumberRegular2DArrayOfNegativeValues() {
		 	Number[][] expectedArray = { { -20.0 }, { -25.0 } };
		 		double[][] arrayToPass = { { -20.0 }, { -25.0 } };
		 		Number[][] actualArray = DataUtilities.createNumberArray2D(arrayToPass);
		 		assertArrayEquals("createNumberArray failed the correct array values are.", expectedArray, actualArray);
		 }



		 
		 //-----------------------------------------------------------------------------------------------------------------------------------------------------


		
		 @After
		    public void tearDown() throws Exception {
		    }
		 

		 @AfterClass
		    public static void tearDownAfterClass() throws Exception {
		    }
		
		
		
  
  
}
