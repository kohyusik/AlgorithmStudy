package step001.kao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Temp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        long a = getJaccard("FRANCE", "french");
        long b = getJaccard("handshake", "shake hands");
        long c = getJaccard("aa1+aa2", "AAAA12");
        long d = getJaccard("E=M*C^2", "e=m*c^2");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

// FRANCE  french   16384
// handshake shake hands  65536
// aa1+aa2  AAAA12   43690
// E=M*C^2  e=m*c^2   65536

    public static long getJaccard(String str1, String str2){

        List<String> listA = new ArrayList<String>();
        List<String> listB = new ArrayList<String>();

        str1 = str1.toUpperCase();
        for(int i = 0; i< str1.length()-1;i++){
            if(Pattern.matches("^[A-Z]*$",str1.substring(i,i+2))){
                listA.add(str1.substring(i,i+2));
            }
        }

        str2 = str2.toUpperCase();
        for(int i = 0; i< str2.length()-1;i++){
            if(Pattern.matches("^[A-Z]*$",str2.substring(i,i+2))){
                listB.add(str2.substring(i,i+2));
            }
        }

        List<String> intersection = new Temp().intersection(listA, listB);
        List<String> union = new Temp().union(listA, listB);

        double intersectionSize = intersection.size();
        double unionSize = union.size();
        if (intersectionSize == 0){
            return 1 * 65536;
        }else{
            return (long)(intersectionSize/unionSize * 65536);
        }

    }

    public <T> List<T> union(List<T> list1, List<T> list2) {
//        Set<T> set = new HashSet<T>();
//
//        set.addAll(list1);
//        set.addAll(list2);
        //  return new ArrayList<T>(set);
        List listA = new ArrayList<T>();

        for(int i = 0; i<list1.size();i++){
            listA.add(list1.get(i));
        }
        for(int i = 0; i<list2.size();i++){
            listA.add(list2.get(i));
        }
        List intersection = intersection(list1, list2);
        for(int i = 0; i<intersection.size();i++){
            listA.remove(intersection.get(i));
        }
        return listA;
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
}