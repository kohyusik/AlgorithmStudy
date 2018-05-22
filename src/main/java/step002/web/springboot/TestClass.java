package step002.web.springboot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude()
public class TestClass<T> {

    String api1;


    @JsonProperty("api2")
    T api3;

    @Override
    public String toString() {
        return "TestClass{" +
                "api1='" + api1 + '\'' +
                ", api3=" + api3 +
                '}';
    }

    public String getApi1() {
        return api1;
    }

    public void setApi1(String api1) {
        this.api1 = api1;
    }

    public T getApi3() {
        return api3;
    }

    public void setApi3(T api3) {
        this.api3 = api3;
    }

    public class TestInnerClass {

        String api1;
        String api2;

        public String getApi1() {
            return api1;
        }

        public void setApi1(String api1) {
            this.api1 = api1;
        }

        public String getApi2() {
            return api2;
        }

        public void setApi2(String api2) {
            this.api2 = api2;
        }

        @Override
        public String toString() {
            return "TestInnerClass{" +
                    "api1='" + api1 + '\'' +
                    ", api2='" + api2 + '\'' +
                    '}';
        }
    }

}
