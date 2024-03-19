package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range; import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleRange1;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	exampleRange1 = new Range(1, 2);
    }
    
            
        @Test
        public void testUpperBoundPositiveNumber() {
            Range range = new Range(-10.0, 20.0);
            // test case: upper bound is a positive number
            assertEquals(20.0, range.getUpperBound(), 0.001);
        }


        @Test
        public void testUpperBoundNegativeNumber() {
            Range range = new Range(-30.0, -5.0);
            // test case: upper bound is a negative number
            assertEquals(-5.0, range.getUpperBound(), 0.001);
        }


        @Test
        public void testUpperBoundZero() {
            Range range = new Range(-5.0, 0.0);
            // test case: upper bound is zero
            assertEquals(0.0, range.getUpperBound(), 0.001);
        }


        @Test
        public void testUpperBoundPositiveInfinity() {
            Range range = new Range(-10.0, Double.POSITIVE_INFINITY);
            // test case: upper bound is positive infinity
            assertEquals(Double.POSITIVE_INFINITY, range.getUpperBound(), 0.001);
        }


        @Test
        public void testUpperBoundNegativeInfinity() {
            Range range = new Range(Double.NEGATIVE_INFINITY, -5.0);
            // test case: upper bound is negative infinity
            assertEquals(-5.0, range.getUpperBound(), 0.001);
        }
        
        //---------------------------------------------------------------------------------------------------------------
        
        @Test
        public void testLowerBoundPositiveNumber() {
            Range range = new Range(-10.0, 20.0);
            // test case: lower bound is a positive number
            assertEquals(-10.0, range.getLowerBound(), 0.001);
        }


        @Test
        public void testLowerBoundNegativeNumber() {
            Range range = new Range(-30.0, -5.0);
            // test case: lower bound is a negative number
            assertEquals(-30.0, range.getLowerBound(), 0.001);
        }


        @Test
        public void testLowerBoundZero() {
        	Range range = new Range(0.0, 5.0);
            // test case: lower bound is zero
            assertEquals(0.0, range.getLowerBound(), 0.001);
        }


        @Test
        public void testLowerBoundPositiveInfinity() {
            Range range = new Range(10.0, Double.POSITIVE_INFINITY);
            // test case: lower bound is positive infinity, expected lower bound should be 10.0
            assertEquals(10.0, range.getLowerBound(), 0.001);
        }


        @Test
        public void testLowerBoundNegativeInfinity() {
            Range range = new Range(Double.NEGATIVE_INFINITY, -5.0);
            // test case: lower bound is negative infinity
            assertEquals(Double.NEGATIVE_INFINITY, range.getLowerBound(), 0.001);
        }

    //------------------------------------------------------------------------------------------------------------------
        
        @Test
        public void testLengthPositiveNumber() {
            Range range = new Range(10.0, 20.0);
            // test case: length is a positive number
            assertEquals(10.0, range.getLength(), 0.001);
        }


        @Test
        public void testLengthZero() {
            Range range = new Range(10.0, 10.0);
            // test case: length is zero
            assertEquals(0.0, range.getLength(), 0.001);
        }


        @Test
        public void testLengthPositiveInfinity() {
            Range range = new Range(10.0, Double.POSITIVE_INFINITY);
            // test case: length is positive infinity
            assertEquals(Double.POSITIVE_INFINITY, range.getLength(), 0.001);
        }


        @Test
        public void testLengthNegativeInfinity() {
            Range range = new Range(Double.NEGATIVE_INFINITY, 10.0);
            // test case: length is positive infinity
            assertEquals(Double.POSITIVE_INFINITY, range.getLength(), 0.001);
        }

    
	    @Test
	    public void centralValueShouldBeZero() {
	        assertEquals("The central value of -1 and 1 should be 0",
	        0, exampleRange.getCentralValue(), .000000001d);
	    }
	    

	    @Test
	    public void testNull() {
	        assertFalse("Test for null (should return false)", exampleRange1.equals(null));
	    }

	    @Test
	    public void testDifferentObject() {
	        assertFalse("Test for a different object type (should return false)", exampleRange1.equals(new Object()));
	    }

	    @Test
	    public void testDifferentRange() {
	        assertFalse("Test for a different range (should return false)", exampleRange1.equals(new Range(2, 3)));
	    }

	    @Test
	    public void testSameRange() {
	        assertTrue("Test for the same range (should return true)", exampleRange1.equals(new Range(1, 2)));
	    }

	    @Test
	    public void testExpand() {
	        Range range = new Range(2, 6);
	        Range expandedRange1 = Range.expand(range, 0.25, 0.5);
	        assertEquals(1, expandedRange1.getLowerBound(), .0000001);
	        assertEquals(8, expandedRange1.getUpperBound(), .0000001);
	    }

	    @Test
	    public void testExpandNullRange() {
	        try {
                Range.expand(null, 0.25, 0.5);
                fail("Expected an IllegalArgumentException for null range");
            }
            catch (IllegalArgumentException e) {
                // expected
                
            }
        }

	    @Test
	    public void testExpandZeroMargins() {
	        Range range = new Range(2, 6);
	        Range expandedRange1 = Range.expand(range, 0, 0);
	        assertEquals(2, expandedRange1.getLowerBound(), .0000001);
	        assertEquals(6, expandedRange1.getUpperBound(), .0000001);
	    }

	    @Test
	    public void testExpandZeroRange() {
	        Range range = new Range(2, 2);
	        Range expandedRange1 = Range.expand(range, 0.25, 0.5);
	        assertEquals(2, expandedRange1.getLowerBound(), .0000001);
	        assertEquals(2, expandedRange1.getUpperBound(), .0000001);
	    }
    
        // Tests to increase mutation coverage
	    @Test
	    public void testCombineIgnoringNaN() {
	        Range range1 = new Range(0, Double.NaN);
	        Range range2 = new Range(Double.NaN, 10);
	        Range combinedRange = Range.combineIgnoringNaN(range1, range2);
	        assertNotNull(combinedRange);  // Ensure combined range is not null
	        assertTrue(combinedRange.getLowerBound() == 0 && combinedRange.getUpperBound() == 10);
	    }

        @Test
        public void testCombineIgnoringNaNNull() {
            Range range1 = new Range(0, 10);
            Range range2 = new Range(10, 20);
            Range combinedRange = Range.combineIgnoringNaN(range1, range2);
            assertNotNull(combinedRange);  // Ensure combined range is not null
            assertTrue(combinedRange.getLowerBound() == 0 && combinedRange.getUpperBound() == 20);
        }

        @Test
        public void testCombineIgnoringNaNNullLowerBound() {
            Range range1 = null;
            Range range2 = new Range(10, 20);
            Range combinedRange = Range.combineIgnoringNaN(range1, range2);
            assertNotNull(combinedRange);  // Ensure combined range is not null
            assertTrue(combinedRange.getLowerBound() == 10 && combinedRange.getUpperBound() == 20);
        }

        @Test
        public void testCombineIgnoringNaNNullUpperBound() {
            Range range1 = new Range(0, 10);
            Range range2 = null;
            Range combinedRange = Range.combineIgnoringNaN(range1, range2);
            assertNotNull(combinedRange);  // Ensure combined range is not null
            assertTrue(combinedRange.getLowerBound() == 0 && combinedRange.getUpperBound() == 10);
        }

        @Test
        public void testCombineIgnoringNaNNullBothBounds() {
            Range range1 = null;
            Range range2 = null;
            Range combinedRange = Range.combineIgnoringNaN(range1, range2);
            assertNull(combinedRange);  // Ensure combined range is null
        }

        @Test
        public void testCombineIgnoringNaNNullRange() {
            Range range1 = new Range(0, 10);
            Range range2 = null;
            Range combinedRange = Range.combineIgnoringNaN(range1, range2);
            assertNotNull(combinedRange);  // Ensure combined range is not null
            assertTrue(combinedRange.getLowerBound() == 0 && combinedRange.getUpperBound() == 10);
        }
    
        @Test
        public void testEqualsAndHashCode() {
            Range range1 = new Range(1, 5);
            Range range2 = new Range(1, 5);
            assertTrue(range1.equals(range2));
            assertEquals(range1.hashCode(), range2.hashCode());
        }

        @Test
        public void testEqualsAndHashCodeNull() {
            Range range1 = new Range(1, 5);
            Range range2 = null;
            assertFalse(range1.equals(range2));
        }
    
        @Test
        public void testScaleBoundary() {
            Range range = new Range(10, 20);
            Range scaledRange = Range.scale(range, 0);
            assertEquals(0, scaledRange.getLength(), 0.001);
        }
    
        @Test
        public void testShiftBoundary() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, Double.MAX_VALUE);
            assertTrue(Double.isInfinite(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryZero() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, 0);
            assertTrue(Double.isInfinite(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryNaN() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, Double.NaN);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()));
        }

        @Test
        public void testShiftBoundaryNaNUpperBound() {
            Range range = new Range(0, Double.NaN);
            Range shiftedRange = Range.shift(range, 1);
            assertTrue(Double.isNaN(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryNaNLowerBound() {
            Range range = new Range(Double.NaN, 10);
            Range shiftedRange = Range.shift(range, 1);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()));
        }

        @Test
        public void testShiftBoundaryNaNBothBounds() {
            Range range = new Range(Double.NaN, Double.NaN);
            Range shiftedRange = Range.shift(range, 1);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()) && Double.isNaN(shiftedRange.getUpperBound()));
        }


    @After
    public void tearDown() throws Exception {
    }


	@AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
