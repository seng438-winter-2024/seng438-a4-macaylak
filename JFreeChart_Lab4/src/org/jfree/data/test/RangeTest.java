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

        @Test
        public void testContainsPositiveNumber() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains a positive number
            assertTrue(range.contains(10.0));
        }

        @Test
        public void testContainsNegativeNumber() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains a negative number
            assertTrue(range.contains(-5.0));
        }

        @Test
        public void testContainsZero() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains zero
            assertTrue(range.contains(0.0));
        }

        @Test
        public void testContainsPositiveInfinity() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains positive infinity
            assertFalse(range.contains(Double.POSITIVE_INFINITY));
        }

        @Test
        public void testContainsNegativeInfinity() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains negative infinity
            assertFalse(range.contains(Double.NEGATIVE_INFINITY));
        }

        @Test
        public void testContainsNaN() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains NaN
            assertFalse(range.contains(Double.NaN));
        }

        @Test
        public void testContainsLowerBound() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains lower bound
            assertTrue(range.contains(-10.0));
        }

        @Test
        public void testContainsUpperBound() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains upper bound
            assertTrue(range.contains(20.0));
        }

        @Test
        public void testContainsLowerBoundMinusOne() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains lower bound minus one
            assertFalse(range.contains(-11.0));
        }

        @Test
        public void testContainsUpperBoundPlusOne() {
            Range range = new Range(-10.0, 20.0);
            // test case: contains upper bound plus one
            assertFalse(range.contains(21.0));
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

        @Test
        public void testCentralValuePositiveNumber() {
            Range range = new Range(10.0, 20.0);
            // test case: central value is a positive number
            assertEquals(15.0, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValueNegativeNumber() {
            Range range = new Range(-10.0, -5.0);
            // test case: central value is a negative number
            assertEquals(-7.5, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValueZero() {
            Range range = new Range(-5.0, 5.0);
            // test case: central value is zero
            assertEquals(0.0, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValuePositiveInfinity() {
            Range range = new Range(10.0, Double.POSITIVE_INFINITY);
            // test case: central value is positive infinity
            assertEquals(Double.POSITIVE_INFINITY, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValueNegativeInfinity() {
            Range range = new Range(Double.NEGATIVE_INFINITY, -5.0);
            // test case: central value is negative infinity
            assertEquals(Double.NEGATIVE_INFINITY, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValueNaN() {
            Range range = new Range(Double.NaN, 5.0);
            // test case: central value is NaN
            assertTrue(Double.isNaN(range.getCentralValue()));
        }

        @Test
        public void testCentralValueNaNLowerBound() {
            Range range = new Range(Double.NaN, 5.0);
            // test case: central value is NaN
            assertTrue(Double.isNaN(range.getCentralValue()));
        }

        @Test
        public void testCentralValueNaNUpperBound() {
            Range range = new Range(5.0, Double.NaN);
            // test case: central value is NaN
            assertTrue(Double.isNaN(range.getCentralValue()));
        }

        @Test
        public void testCentralValueNaNBothBounds() {
            Range range = new Range(Double.NaN, Double.NaN);
            // test case: central value is NaN
            assertTrue(Double.isNaN(range.getCentralValue()));
        }

        @Test
        public void testCentralValueNegativeInfinityUpperBound() {
            Range range = new Range(Double.NEGATIVE_INFINITY, 5.0);
            // test case: central value is negative infinity
            assertEquals(Double.NEGATIVE_INFINITY, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValuePositiveInfinityLowerBound() {
            Range range = new Range(5.0, Double.POSITIVE_INFINITY);
            // test case: central value is positive infinity
            assertEquals(Double.POSITIVE_INFINITY, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValueNegativeInfinityBothBounds() {
            Range range = new Range(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
            // test case: central value is negative infinity
            assertEquals(Double.NEGATIVE_INFINITY, range.getCentralValue(), 0.001);
        }

        @Test
        public void testCentralValuePositiveInfinityBothBounds() {
            Range range = new Range(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            // test case: central value is positive infinity
            assertEquals(Double.POSITIVE_INFINITY, range.getCentralValue(), 0.001);
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
        public void testExpandZeroRange() {
            Range range = new Range(2, 2);
            Range expandedRange1 = Range.expand(range, 0.25, 0.5);
            assertEquals(2, expandedRange1.getLowerBound(), .0000001);
            assertEquals(2, expandedRange1.getUpperBound(), .0000001);
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
        public void testExpandNullMargins() {
            Range range = new Range(2, 6);
            Range expandedRange1 = Range.expand(range, 0, 0);
            assertEquals(2, expandedRange1.getLowerBound(), .0000001);
            assertEquals(6, expandedRange1.getUpperBound(), .0000001);
        }

	    @Test
	    public void testExpandZeroMargins() {
	        Range range = new Range(2, 6);
	        Range expandedRange1 = Range.expand(range, 0, 0);
	        assertEquals(2, expandedRange1.getLowerBound(), .0000001);
	        assertEquals(6, expandedRange1.getUpperBound(), .0000001);
	    }

		@Test
		public void testExpandNegativeMargins() {
		    Range range = new Range(2, 6);
		    Range expandedRange1 = Range.expand(range, -0.25, -0.5);
		    assertEquals(3.0, expandedRange1.getLowerBound(), .0000001);
            assertEquals(4.0, expandedRange1.getUpperBound(), .0000001);
		}

        @Test
        public void testExpandNegativeMarginsZeroRange() {
            Range range = new Range(2, 2);
            Range expandedRange1 = Range.expand(range, -0.25, -0.5);
            assertEquals(2, expandedRange1.getLowerBound(), .0000001);
            assertEquals(2, expandedRange1.getUpperBound(), .0000001);
        }

        @Test
        public void testExpandNegativeMarginsZeroMargins() {
            Range range = new Range(2, 6);
            Range expandedRange1 = Range.expand(range, 0, 0);
            assertEquals(2, expandedRange1.getLowerBound(), .0000001);
            assertEquals(6, expandedRange1.getUpperBound(), .0000001);
        }

        @Test
        public void testExpandNegativeMarginsNullRange() {
            try {
                Range.expand(null, -0.25, -0.5);
                fail("Expected an IllegalArgumentException for null range");
            }
            catch (IllegalArgumentException e) {
                // expected
                
            }
        }

        @Test
        public void testExpandNegativeMarginsNullMargins() {
            Range range = new Range(2, 6);
            Range expandedRange1 = Range.expand(range, 0, 0);
            assertEquals(2, expandedRange1.getLowerBound(), .0000001);
            assertEquals(6, expandedRange1.getUpperBound(), .0000001);
        }

        @Test
        public void testExpandNegativeMarginsNullRangeNullMargins() {
            try {
                Range.expand(null, 0, 0);
                fail("Expected an IllegalArgumentException for null range");
            }
            catch (IllegalArgumentException e) {
                // expected
                
            }
        }

        @Test
        public void testExpandNegativeMarginsNullRangeZeroMargins() {
            try {
                Range.expand(null, 0, 0);
                fail("Expected an IllegalArgumentException for null range");
            }
            catch (IllegalArgumentException e) {
                // expected
                
            }
        }

        @Test
        public void testExpandNegativeMarginsZeroMarginsNullRange() {
            try {
                Range.expand(null, 0, 0);
                fail("Expected an IllegalArgumentException for null range");
            }
            catch (IllegalArgumentException e) {
                // expected
                
            }
        }

        @Test
        public void testExpandNegativeMarginsZeroMarginsZeroRange() {
            Range range = new Range(2, 2);
            Range expandedRange1 = Range.expand(range, 0, 0);
            assertEquals(2, expandedRange1.getLowerBound(), .0000001);
            assertEquals(2, expandedRange1.getUpperBound(), .0000001);
        }

    
//------------------------------------------------------------------------------------------------------------------
   
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

        @Test
        public void testShiftBoundaryNaNShift() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, Double.NaN);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()) && Double.isNaN(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryNegativeInfinity() {
            Range range = new Range(Double.NEGATIVE_INFINITY, 10);
            Range shiftedRange = Range.shift(range, 1);
            assertTrue(Double.isInfinite(shiftedRange.getLowerBound()));
        }

        @Test
        public void testShiftBoundaryPositiveInfinity() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, 1);
            assertTrue(Double.isInfinite(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryNegativeShift() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, -1);
            assertEquals(-1, shiftedRange.getLowerBound(), 0.001);
        }

        @Test
        public void testShiftBoundaryNegativeShiftNaN() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, Double.NaN);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()) && Double.isNaN(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryNegativeShiftNegativeInfinity() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, Double.NEGATIVE_INFINITY);
            assertTrue(Double.isInfinite(shiftedRange.getLowerBound()));
        }

        @Test
        public void testShiftBoundaryNegativeShiftPositiveInfinity() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, Double.POSITIVE_INFINITY);
            assertTrue(Double.isInfinite(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryPositiveInfinityShift() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, 1);
            assertTrue(Double.isInfinite(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryPositiveInfinityShiftNaN() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, Double.NaN);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()) && Double.isNaN(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryPositiveInfinityShiftNegativeInfinity() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, Double.NEGATIVE_INFINITY);
            assertTrue(Double.isInfinite(shiftedRange.getLowerBound()));
        }

        @Test
        public void testShiftBoundaryPositiveInfinityShiftPositiveInfinity() {
            Range range = new Range(0, Double.POSITIVE_INFINITY);
            Range shiftedRange = Range.shift(range, Double.POSITIVE_INFINITY);
            assertTrue(Double.isInfinite(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryZeroShift() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, 0);
            assertEquals(0, shiftedRange.getLowerBound(), 0.001);
        }

        @Test
        public void testShiftBoundaryZeroShiftNaN() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, Double.NaN);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()) && Double.isNaN(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryZeroShiftNegativeInfinity() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, Double.NEGATIVE_INFINITY);
            assertTrue(Double.isInfinite(shiftedRange.getLowerBound()));
        }

        @Test
        public void testShiftBoundaryZeroShiftPositiveInfinity() {
            Range range = new Range(0, 10);
            Range shiftedRange = Range.shift(range, Double.POSITIVE_INFINITY);
            assertTrue(Double.isInfinite(shiftedRange.getUpperBound()));
        }

        @Test
        public void testShiftBoundaryNaNShiftNaN() {
            Range range = new Range(Double.NaN, 10);
            Range shiftedRange = Range.shift(range, Double.NaN);
            assertTrue(Double.isNaN(shiftedRange.getLowerBound()) && Double.isNaN(shiftedRange.getUpperBound()));
        }

    @After
    public void tearDown() throws Exception {
    }


	@AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
