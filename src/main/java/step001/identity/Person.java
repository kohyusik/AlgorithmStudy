package step001.identity;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Person that = (Person) obj;
        if (this.name == null && that.name != null) {
            return false;
        }
        if (this.id == that.id && this.name.equals(that.name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        return result;
    }


    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Sam");
        Person p2 = new Person();
        p2.setId(1);
        p2.setName("Sam");
        System.out.println(p1.equals(p2)); // false

        Map<Person, Integer> map = new HashMap<Person, Integer>();
        map.put(p1, 1);
        map.put(p2, 1);
        System.out.println(map.size()); // 2


    }
}
