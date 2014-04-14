package test;

import java.util.Arrays;

import com.homeProject.common.Common;


public class testDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		ArticleCommentANDContentAction test = new ArticleCommentANDContentAction();
//		test.getArticleAll();
//		test.getArticleContent_List();
//		
//		IteratorTestAction test = new IteratorTestAction();
//		
//		test.getInterestOptions();
		
//		common test = new common();
//		
//		test.InsertResult("文章详细内容",new String[]{"文章作者","文章标题","文章絮语","文章内容","文章删除","文章类别","文章更新日"},new String[]{"1","1","1","1","1","1","now()"});
		
		Object[] condition = new Object[]{"a","a","a",1};
		
		for(int i=0;i<condition.length && condition[i].getClass() == String.class ;i++)
		{
			condition[i] = "\""+condition[i]+"\"";
		}
		System.out.print(Arrays.toString(condition).replace("[", "(")
				.replace("]", ")"));
		
		
	}

}
