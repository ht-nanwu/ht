package com.work.layout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.work.RecordScore;
import com.work.actionInterface.Actions;
import com.work.utils.RecordScoreUtil;

/**
 * 成绩登陆的界面代码
 * 
 * @version 1.0.0
 * 
 * @author 曹毅
 *
 */
public class RecordScoreLayout implements Actions {
	
	// 成绩登陆的界面的界面
    private JFrame frame;
    // 学号输入文本框
    private JTextField noText;
    // 姓名输入文本框
    private JTextField nameText;
    // 学科输入文本框
    private JTextField courseText;
    // 等级输入文本框
    private JTextField levelText;
    // log打印对象
    private Logger logger = Logger.getLogger(RecordScore.class);

    /**
     * 成绩登陆的界面的构造器
     * 
     */
    public RecordScoreLayout() {
    	// 界面启动
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	// 界面初始化开始
                    initialize();
                    RecordScoreUtil.setCenter(frame);
                    frame.setVisible(true);
                } catch (Exception e) {
                	logger.error("成绩登陆的界面开始初始化失败！！！！");
                	logger.error(e.getMessage());
                }
            }
        });

    }

    /**
     * 初始化成绩登陆的界面
     * 
     */
    private void initialize() {
    	
        logger.info("成绩登陆的界面开始初始化。");
        
        frame = new JFrame("JAVA应用<简单成绩系统>");
        frame.setBounds(100, 100, 475, 327);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel noLabel = new JLabel("学号");
        noLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
        noLabel.setHorizontalAlignment(SwingConstants.CENTER);
        noLabel.setBounds(76, 25, 62, 19);
        frame.getContentPane().add(noLabel);

        JLabel nameLabel = new JLabel("姓名");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
        nameLabel.setBounds(74, 74, 62, 19);
        frame.getContentPane().add(nameLabel);

        JLabel courseLabel = new JLabel("学科");
        courseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        courseLabel.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
        courseLabel.setBounds(71, 121, 62, 19);
        frame.getContentPane().add(courseLabel);

        JLabel levelLable = new JLabel("LEVEL");
        levelLable.setHorizontalAlignment(SwingConstants.CENTER);
        levelLable.setFont(new Font("MS UI Gothic", Font.PLAIN, 15));
        levelLable.setBounds(70, 166, 62, 19);
        frame.getContentPane().add(levelLable);

        noText = new JTextField();
        noText.setColumns(10);
        noText.setBounds(159, 25, 118, 19);
        frame.getContentPane().add(noText);

        nameText = new JTextField();
        nameText.setColumns(10);
        nameText.setBounds(159, 74, 118, 19);
        frame.getContentPane().add(nameText);

        courseText = new JTextField();
        courseText.setColumns(10);
        courseText.setBounds(159, 121, 118, 19);
        frame.getContentPane().add(courseText);

        levelText = new JTextField();
        levelText.setColumns(10);
        levelText.setBounds(159, 166, 118, 19);
        frame.getContentPane().add(levelText);

        JButton commit = new JButton("登陆");
        commit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logger.info("登陆按钮按下。");
                commit(new String[]{
                	noText.getText(),
                	nameText.getText(),
                	courseText.getText(),
                	levelText.getText()
                });
            }
        });
        commit.setBounds(76, 220, 91, 21);
        frame.getContentPane().add(commit);
        
        JButton btnScan = new JButton("预览及查询");
        btnScan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scan();
            }
        });
        btnScan.setVisible(true);
        btnScan.setBounds(222, 220, 109, 21);
        frame.getContentPane().add(btnScan);
        logger.info("layout init end");
    }

    @Override
    public void commit(String[] parms) {
    }

    @Override
    public void scan() {
    }
}
