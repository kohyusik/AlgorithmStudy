/**
 * 
 */
package test;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author yusik
 *
 */
public class TestMain {

	public static void main(String[] args) {

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
		
		test(String.class, Object.class);
		test(String.class, Object.class, Object.class);
		
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
//		test(String, ptype);
//
		TypeToken type = new TypeToken<Map<K, X>>(){}
				.where(new TypeParameter<K>() {}, cls3)
				.where(new TypeParameter<X>() {}, ptype)
				;
		
//		Type name = new TypeToken<>(){}.getType();
//        System.out.println(new TypeToken<>(){}.getType());
//		TypeToken type2 = new TypeToken<X>(){}
//                .where(new TypeParameter<X>() {}, ptype)
		; // error
//		System.out.println(value.getType());
		System.out.println(type.getType());
//		System.out.println(type2.getType());
	}

}

