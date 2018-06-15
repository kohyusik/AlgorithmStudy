package step002.web.domain.inheritance;

public enum UserType {
    SRELLO(Values.SRELLO), GITHUB(Values.GITHUB);

    private String type;

    private UserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static class Values {
        public static final String SRELLO = "S";
        public static final String GITHUB = "G";
    }
}