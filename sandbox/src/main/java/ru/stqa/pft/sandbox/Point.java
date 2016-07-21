package ru.stqa.pft.sandbox;
import java.lang.Math;


/**
 * Created by irener on 7/20/16.
 */
public class Point {

  public double x;
  public double y;nf

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }


  public double distance2(Point other){
  return Math.sqrt((this.x - x)*(this.x - x)+(this.y - y)*(this.y - y));
}
}
