/**
 *
 */
package test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yusik
 */
public class TestMain2 {
    
    public TestMain2() {
        System.out.println("TestMain2 const");
    }
    
    public static void main(String[] args) throws IOException {
    
        Class clazz = Object.class;
        Class supClazz =clazz.getSuperclass();
        System.out.println(clazz);
        System.out.println(clazz == Object.class);
        System.out.println(supClazz);
    
        TestMain2 innerInnerClass = InnerTestClass.getInstance();
        System.out.println(innerInnerClass);
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf.getTimeZone());
        
    
        /*
        String renamedFileName = "ABC_123_15";
    
        //        File file = File.createTempFile("0javaTest", ".txt");
        File file = new File("C:\\git\\AlgorithmStudy\\src\\main\\webapp\\study\\reactjs\\react004.js");
    
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
    
        System.out.println(file.toURI());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.length());
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.getAlgorithm());
    
        String EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z0-9]*[.][a-zA-Z]*$";
        String MOBILE = "(01[012679])(d{3,4})(d{4})";
    
        String EMAIL_PATTERN = "^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$";
        String PHONE_PATTERN = "(01[016789])(\\d{3,4})(\\d{4})";
    
        Matcher m = Pattern.compile(EMAIL).matcher("@aa.a");
        System.out.println(m.matches());
        Matcher m2 = Pattern.compile(MOBILE).matcher("0101223450123");
        System.out.println(m2.matches());
        Matcher m3 = Pattern.compile(EMAIL_PATTERN).matcher("new090AA@aa.a");
        System.out.println(m3.matches());
        Matcher m4 = Pattern.compile(PHONE_PATTERN).matcher("01063757314");
        System.out.println(m4.matches());
   *//*
        try {
            String serverIP = "127.0.0.1"; // 127.0.0.1 & localhost 본인
            System.out.println("서버에 연결중입니다. 서버 IP : " + serverIP);
        
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIP, 61613);
        
            // 소켓의 입력스트림을 얻는다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);  // 기본형 단위로 처리하는 보조스트림
        
            // 소켓으로 부터 받은 데이터를 출력한다.
            System.out.println("서버로부터 받은 메세지 : " + dis.readUTF());
            System.out.println("연결을 종료합니다.");
        
            // 스트림과 소켓을 닫는다.
            dis.close();
            socket.close();
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }*//*
    
    
    
        try {
            Class clazz = TestMain.class;
            System.out.println(clazz.getDeclaredMethods());
            Method method = clazz.getDeclaredMethod("refTest", String.class);
            Method method2 = clazz.getDeclaredMethod("refTest", Integer.class);
            Object ret = method.invoke(clazz.newInstance(), "TEST22");
        
            System.out.println(ret);
        
        
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    */
    }
    
    public static class InnerTestClass extends TestMain2{
        
        public static InnerTestClass getInstance(){
            InnerInnerClass in = new InnerInnerClass();
            System.out.println(in);
            return new InnerTestClass();
        }
    
        public InnerTestClass() {
            System.out.println("InnerTestClass const");
        }
    
        public static class InnerInnerClass {
            public InnerInnerClass() {
                System.out.println("InnerInnerClass const");
            }
        }
    }
    
}

