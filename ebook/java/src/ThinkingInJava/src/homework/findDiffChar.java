package homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找不同字符
 * 
 * @author wushp
 * 
 */
public class findDiffChar {
	public static void main(String[] args) {

		// 索要查询的字符串
		String targetString = "test123asdzxcxcv";
		Map<Character, Integer> count = new HashMap<Character, Integer>();
		for (char eachChar : targetString.toCharArray()) {
//			if (count.get(eachChar) != null) {
//				count.put(eachChar, count.get(eachChar) + 1);
//			} else {
//				count.put(eachChar, 1);
//			}
			count.put(eachChar, count.get(eachChar) == null?1:count.get(eachChar) + 1);
		} 
		System.out.println(count);
	}
} /*
 * Output: Evening is full of the linnet s wings Evening vening ening ning ing
 * ng g is is s full full ull ll l of of f the the he e linnet linnet innet nnet
 * net et t s s wings wings ings ngs gs s
 */// :~
