package com.work.actionInterface;

/**
 * 学生成绩用接口
 * 
 * @version 1.0.0
 * 
 * @author 曹毅
 * 
 */
public interface Actions {
	/**
	 * 把界面上输入的内容保存到csv里面去
	 * 
	 * @param args
	 *            界面上输入的内容
	 */
	void commit(String[] args);

	/**
	 * 全检索
	 */
	void scan();
}
