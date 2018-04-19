package step001.singleton;

import step001.singleton.s00.EagerInitialization;
import step001.singleton.s01.StaticBlockInitalization;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-04-19
 * @description :
 */
public class SingletonTest {
    
    public static void main(String[] args) {
//        try {
//            Class.forName("step001.singleton.s00.EagerInitialization2");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    
         EagerInitialization.getInstance().print();
         EagerInitialization.getInstance().print();
        StaticBlockInitalization.getInstance();
    
    }
    
}
