/**
 * 
 */
package test;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author yusik
 *
 */
public class TestMain {

	public static void main(String[] args) throws URISyntaxException {

		ArrayList<Integer> test = new ArrayList<Integer>();
//		ParameterizedTypeReference<CommonResponse<List<T>>> responseType =
//				ParameterizedTypeReferenceBuilder.fromTypeToken(
//						new TypeToken<CommonResponse<List<T>>>() {}
//								.where(new TypeParameter<T>() {}, resultType));
        
        Long long1 = 15l;
        long long2 = 15;
        System.out.println(long1.compareTo(long2));
        
//		test.add(1);
//		test.add(5);
//		test.add(51);
//		test.indexOf(1);
		
		Map<String, Map<String, Integer>> map;
//
//		test(String.class, Object.class);
//		test(String.class, Object.class, Object.class);
		
		System.out.println(URLEncoder.encode("###%"));
		
		String uriStr = UriComponentsBuilder.newInstance()
				.scheme("http").host("localhost").port(9999).path("/test")
				.queryParam("t1", "dbtlr##")
				.queryParam("t2", "#=?%")
				.queryParam("t3", 1234)
				.build().encode().toString();
		System.out.println(uriStr);
		
		URI uri = new URI(uriStr);
		
		System.out.println(uri);
		
		ResponseEntity<Map> response = null;
		HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
		RestTemplate restTemplate = new RestTemplate();
		response = restTemplate.exchange(
				uriStr, HttpMethod.GET, entity, Map.class);
		
		System.out.println(response);
		ResponseEntity<Map> response2 = null;
		response2 = restTemplate.exchange(
				uri, HttpMethod.GET, entity, Map.class);
		
		System.out.println(response2);
		
		
	}
	
	public static <T, S> void test(Class<T> cls, Class<S> cls2) {
		TypeToken type = new TypeToken<Map<T, S>>(){}
				.where(new TypeParameter<T>() {}, cls)
				.where(new TypeParameter<S>() {}, cls2)
				;
		System.out.println(type.getType());
		System.out.println(type.getRawType());
	}
	public static <T, Z, K, X> void test(
			Class<T> cls, Class<Z> cls2, Class<K> cls3) {
		TypeToken value = new TypeToken<Map<T, Z>>(){}
				.where(new TypeParameter<T>() {}, cls)
				.where(new TypeParameter<Z>() {}, cls2)
				;
		
		Class ptype = value.getRawType();
		TypeToken type = new TypeToken<Map<K, X>>(){}
				.where(new TypeParameter<K>() {}, cls3)
				.where(new TypeParameter<X>() {}, ptype)
				;
		
		System.out.println(type.getType());
	}

}

