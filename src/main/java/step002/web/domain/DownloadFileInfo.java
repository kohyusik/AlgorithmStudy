package step002.web.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-06-25
 * @description :
 */
@Data
public class DownloadFileInfo {
    
    @JsonProperty("uploadPath")
    private String uploadPath;
    
    @JsonProperty("originalFileName")
    private String originalFileName;
    
    @Override
    public String toString() {
        
        return "\n[ DownloadFileInfo ]\n{\n" +
                "\n- uploadPath=" + uploadPath +
                "\n- originalFileName=" + originalFileName +
                "\n}";
    }
}
