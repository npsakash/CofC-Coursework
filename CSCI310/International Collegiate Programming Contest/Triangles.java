
package pkg310lab9;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author jasmine smallwood
 */
public class Main {

   
    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);
        int num = Integer.parseInt(kb.nextLine());
        Point points[] = new Point[num];
        for(int i =0; i<num; i++){
            points[i] = new Point(kb.nextInt(),kb.nextInt());
        }
        double area1 = triArea(points[0],points[1],points[2]);
        double area2 =0.0;
        
        for(int i = 0; i<num;i++){
            for(int j=i+1; j<num; j++){
                for(int k = j+1; k<num; k++){
                    double tri = triArea(points[i],points[j],points[k]);
                    if(tri >area2)
                        area2=tri;
                    if(tri< area1)
                        area1 = tri;
                }
            }
        }
        System.out.println(area1 + " " + area2);
    }
    
    public static double triArea(Point a, Point b, Point c){
        return Math.abs(a.x*b.y+c.x*a.y+b.x*c.y-c.x*b.y-b.x*a.y-a.x*c.y)/2.0;
    }
}