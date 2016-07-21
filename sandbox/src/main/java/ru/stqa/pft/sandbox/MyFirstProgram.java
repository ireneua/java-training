package ru.stqa.pft.sandbox;


public class MyFirstProgram {

	public static void main (String[] args) {
		System.out.println("Hello,World!");

    Point p1 = new Point(0.0, 0.0);
    Point p2 = new Point(0.0, 0.0);

    p1.x = 2.0;
    p2.x = 1.0;
    p1.y = 3.0;
    p2.y = 7.1;

    System.out.println("Point 1 has coodrinate: " + p1.x + " " + p1.y);
    System.out.println("Point 2 has coodrinate: " + p2.x + " " + p2.y);
    System.out.println("Distance is:" + distance(p1,p2));


    //lesson1.task #4

    System.out.println("Point 1 has coodrinate: " + p1.x + " " + p1.y);
    System.out.println("Point 2 has coodrinate: " + p2.x + " " + p2.y);
    System.out.println("Distance is: " + p1.distance2(p2));
    System.out.println("Distance is: " + p2.distance2(p1));
  }


  public static double distance(Point p1, Point p2){
    return  Math.sqrt((p2.x - p1.x)*(p2.x - p1.x)+(p2.y - p1.y)*(p2.y - p1.y));
  }


}