package com.work;

import javax.swing.JOptionPane;

import com.work.layout.RecordScoreLayout;
import com.work.layout.ScoreListSortLayout;
import com.work.utils.RecordScoreUtil;

public class RecordScore {
    private String root;
    public static void main(String[] args) {
        final RecordScore recordScore = new RecordScore();
        recordScore.root = args[0].replace("\"", "");
        new RecordScoreLayout() {

            /* (non-Javadoc)
             * @see com.work.layout.RecordScoreLayout#commit(java.lang.String[])
             */
            @Override
            public void commit(String[] parms) {
                RecordScoreUtil operateCSV = new RecordScoreUtil(recordScore.root);
                operateCSV.writeToCsv(parms);
                JOptionPane.showMessageDialog(
                        null, 
                        "成功了:\n" + 
                        "学号：" + parms[0] + 
                        "姓名：" + parms[1] + 
                        "学科：" + parms[2] + 
                        "等级：" + parms[3], 
                        "成绩更新成功提示",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            /* (non-Javadoc)
             * @see com.work.layout.RecordScoreLayout#scan()
             */
            @Override
            public void scan() {
            	RecordScoreUtil operateCSV = new RecordScoreUtil(recordScore.root);
            	ScoreListSortLayout sortList = new ScoreListSortLayout(null,operateCSV.readFromCsv(),recordScore.root);
            	sortList.setVisible(true);
            }
        };
    }

}
