package step002.web.domain.inheritance;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName(UserType.Values.GITHUB)
public class GitHubUser extends User {
}