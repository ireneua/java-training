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

    //distance is positive value
    Assert.assertEquals(c.distance2(b) >= 0, true);

    //distance between c-b is equal to distance betweeb b-c
    Assert.assertEquals(c.distance2(b), b.distance2(c));

    //distance is calculated correctly
    Assert.assertEquals(c.distance2(b), 3.55, 2);

  }
}
