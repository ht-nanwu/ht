package com.nanwu.hometown;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.nanwu.hometown.mail.SendMail;

public class Start {

    /**
     * @param args
     * なし
     */
    public static void main(String[] args) throws Exception {
        
        // 共通対象
        Common com = new Common();
        com.backupMysql();
        SendMail.send();
        
        List<Map<String, String>> currentData = com.select();
        if (currentData.isEmpty()) {
            com.insert();
        }
        currentData = com.select();
        //Date now = Calendar.getInstance().getTime();
        //int sleepSecs = com.getLastsSecond(com.strToDate(now,"yyyy-MM-dd hh:mm:ss"), currentData.get(0).get("knock_off_time")); 
        
        String knockOffTime = currentData.get(0).get("knock_off_time");
        int shutdownFlg = JOptionPane.showConfirmDialog(null, "下班时间为:"+knockOffTime+"。你需要关机吗？SVN提交了吗？","下班提醒", JOptionPane.YES_NO_OPTION);
        
        if (shutdownFlg == 0) {
            try {
                com.update();
                Runtime.getRuntime().exec("shutdown -s -t 1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
