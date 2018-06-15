package step002.web.domain.inheritance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@JsonTypeInfo(
        use= JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SrelloUser.class, name = UserType.Values.SRELLO),
    @JsonSubTypes.Type(value = GitHubUser.class, name = UserType.Values.GITHUB)
})
@Data
public abstract class User {
    private String id = "00";
}