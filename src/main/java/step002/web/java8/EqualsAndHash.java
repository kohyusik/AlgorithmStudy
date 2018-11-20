package step002.web.java8;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-11-21
 * @description :
 */
public class EqualsAndHash {
    
    public static void main(String[] args) {

        User user1 = new User(1, "k");
        User user2 = new User(1, "k");

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));

        Map<User, Integer> map = new HashMap<>();
        map.put(user1, 1);
        map.put(user2, 1);
        System.out.println(map);
    }

    public static class User {
        private long id;
        private String name;

        public User(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return getId() == user.getId() &&
                    Objects.equals(getName(), user.getName());
        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(getId(), getName());
//        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    
}
