/**
 * 
 */
package test;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

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
		test.add(1);
		test.add(5);
		test.add(51);
		test.indexOf(1);
		test(String.class);
		test(Integer.class);

	}
	
	public static <T> void test(Class<T> cls) {
		TypeToken type = new TypeToken<List<T>>(){}
				.where(new TypeParameter<T>() {
				}, cls);
		System.out.println(type.getType());
	}

}

