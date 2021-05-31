package javaBasics4;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class LineTest {

    //Line(x0,y0,x1,y1)
    Line testLine = new Line(1,2,3,4);
    Line testLine2 = new Line(2,4,6,8);

    Line testLine3 = new Line(3,9,5,20);

    //testLine & testLine2 should be parallel

    //HP == happy path; Should return passing result
    //FP == fail path; Should return failing result

    //getSlope = y1-y0/x1-x0
    @Test
    public void getSlopeTestHP()
    {
        assertEquals(testLine.getSlope(), 1,.0001);
        assertNotEquals(testLine.getSlope(), 2, .0001);
    }
    @Test
    public void getSlopeTestFP()
    {
        assertEquals(testLine.getSlope(), 2, .0001);
        assertNotEquals(testLine.getSlope(), 1,.0001);
    }

    //getDistance = sqrt((x1-x0)^2 + (y1-y0)^2)
    @Test
    public void getDistanceHP()
    {
        assertEquals(testLine.getDistance(), Math.sqrt(8),.0001);
        assertNotEquals(testLine.getDistance(), Math.sqrt(6),.0001);
    }
    @Test
    public void getDistanceFP()
    {
        assertNotEquals(testLine.getDistance(), Math.sqrt(8),.0001);
        assertEquals(testLine.getDistance(), Math.sqrt(6),.0001);
    }

    //Slope line1 - slope line 2 = 0 (ish)
    //Slopes within 1/10000th of eachother qualify
    @Test
    public void parallelToHP()
    {
        assertTrue(testLine.parallelTo(testLine2));
    }
    @Test
    public void parallelToFP()
    {
        assertTrue(testLine.parallelTo(testLine3));
    }
}
