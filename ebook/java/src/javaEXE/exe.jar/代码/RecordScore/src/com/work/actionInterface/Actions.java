package com.work.actionInterface;


public interface Actions {
    /**
     * 把界面上输入的内容保存到csv里面去
     * @param args 界面上输入的内容
     */
    void commit(String[] args);
    /**
     * 预览，指定查询
     */
    void scan();
}
