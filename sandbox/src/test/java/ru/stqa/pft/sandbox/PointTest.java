package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by irener on 7/21/16.
 */
public class PointTest {

  @Test
  public void testDistance(){

    Point c = new Point(3.1, 0.0);
    Point b = new Point(1.2, 3.0);

    Assert.assertEquals(c.distance2(b), 3.55, 2);

  }

  @Test
  public void testDistance2(){

    Point c = new Point(3.1, 0.0);
    Point b = new Point(1.2, 3.0);

    //distance is positive value
    Assert.assertEquals(c.distance2(b) >= 0, true);

    //distance between c-b is equal to distance betweeb b-c
    Assert.assertEquals(c.distance2(b), b.distance2(c));

  }

  @Test
  public void testDistance3(){

    Point c = new Point(3.1, 0.0);
    Point b = new Point(1.2, 3.0);

    //distance between c-b is equal to distance between b-c
    Assert.assertEquals(c.distance2(b), b.distance2(c));

  }

}
