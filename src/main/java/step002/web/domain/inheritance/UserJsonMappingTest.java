package step002.web.domain.inheritance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserJsonMappingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserJsonMappingTest.class);

    @Test
    public void mixin() throws Exception {
        User srelloUser = new SrelloUser("userId", "javajigi@slipp.net", "password");
        ObjectMapper mapper = new ObjectMapper();
        LOGGER.debug("result : {}", mapper.writeValueAsString(srelloUser));
    }
}