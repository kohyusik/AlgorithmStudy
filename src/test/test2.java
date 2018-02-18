package test;

import java.util.HashSet;
import java.util.Set;

public class test2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      //Set<Object> object1 = new Set
      Set<Object> a = new HashSet<Object>();
      Set<Object> b = new HashSet<Object>();
      Set<Object> c = new HashSet<Object>();
      a.add("a");
       a.add("b");
       a.add("c");
       a.add("d");
       a.add(1);
       
       b.add("c");
       b.add("d");
       b.add("e");
       b.add("f");
       b.add(1);
      
      c = getIntersection(a,b);
      
      for(Object obj :c){
         System.out.println(obj.toString());
      }
      
      System.out.println((new Integer(1)).equals(new Integer(1)));

   }

   public static Set<Object> getIntersection(Set<Object> a, Set<Object> b) {
       Set<Object> intersection = new HashSet<Object>();
       
      for (Object obj : a) {
         
         if (b.contains(obj)) {
            intersection.add(obj);
         }
//         for (Object obj2 : b) {
//            if (obj.equals(obj2)) {
//               intersection.add(obj);
//            }
//         }
      }       
       return intersection;
   }
   
   
}