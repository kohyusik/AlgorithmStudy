package step002.web.domain.inheritance;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName(UserType.Values.SRELLO)
public class SrelloUser extends User {
    private String email;
    private String password;
    
    public SrelloUser(String userId, String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }
}
