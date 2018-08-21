package step002.web.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-03-05
 * @description : decrypt encoded parameter
 */
public interface ParameterDecryptor {
    
    String KEY_PARAMETER_NAME = "";
    
    /**
     * decode parameters
     *
     * @param encodedPageKey encoded parameter key
     * @encryption encodedPageKey encoded parameter key
     */
    default Map<String, String> convertQueryStringToMap(String encodedPageKey, boolean isEncrypt) throws Exception {
        
        String queryString = null;

        if (isEncrypt) {
            queryString = decrypt(encodedPageKey);
        }
        
        Map<String, String> queryMap = new HashMap();
        Pattern pattern = Pattern.compile("(\\w+)=?([^&]+)?");
        Matcher matcher = pattern.matcher(queryString);
        
        while (matcher.find()) {
            queryMap.put(matcher.group(1), matcher.group(2));
        }
        
        return queryMap;
    }
    
    default Map<String, String> convertQueryStringToMap(String encodedPageKey) throws Exception {
        return convertQueryStringToMap(encodedPageKey, true);
    }
    
    /**
     * decode parameters
     *
     * @param pageKey encoded parameter key
     */
    String decrypt(String pageKey) throws Exception;
}