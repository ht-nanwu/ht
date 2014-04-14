package com.homeProject.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.StaticParameters.StaticParameters;

/*
 * 共通函数
 * */
public class Common implements StaticParameters {

    /**
     * 打开MYSQL数据库
     * 
     * @param sqlType
     *            1.单个插入数据 2.多条插入 3.带条件查询 4.带多条件查询 其他.不带条件查询
     * @return 数据库连接
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Object excuteMySql(String sql, int sqlType, String inputValueString,
            Object[] inputValueArray, List<String[]> inputValueList)
            throws SQLException, ClassNotFoundException {
        PreparedStatement pstmt = null;
        ResultSet result = null;
        Connection conme = null;
        conme = openMySql();
        pstmt = conme.prepareStatement(sql);
        if (sqlType == 1) {
            for (int i = 0; i < inputValueArray.length; i++) {
                if (inputValueArray[i].getClass().getName().equals(
                        "java.lang.String")) {
                    pstmt.setString(i + 1, inputValueArray[i].toString());
                } else {
                    pstmt.setInt(i + 1, Integer.valueOf(inputValueArray[i]
                            .toString()));
                }
            }
            pstmt.executeUpdate();
            closeMySql(result, conme, pstmt);
            return true;
        } else if (sqlType == 2) {
            for (int i = 0; i < inputValueList.size(); i++) {
                for (int j = 0; j < inputValueList.get(i).length; j++) {
                    if (inputValueList.get(i)[j].getClass().getName().equals(
                            "java.lang.String")) {
                        pstmt.setString(j + 1, inputValueList.get(i)[j]
                                .toString());
                    } else {
                        pstmt.setInt(j + 1, Integer.valueOf(inputValueList
                                .get(i)[j].toString()));
                    }
                }
                pstmt.executeUpdate();
            }
            closeMySql(result, conme, pstmt);
            return true;
        } else if (sqlType == 3) {
            if (inputValueString.getClass().getName()
                    .equals("java.lang.String")) {
                pstmt.setString(1, inputValueString.toString());
            } else {
                pstmt.setInt(1, Integer.valueOf(inputValueString.toString()));
            }
            DataBaseBean resultbean = new DataBaseBean();
            resultbean.setConn(conme);
            resultbean.setPstmt(pstmt);
            resultbean.setResultselect(pstmt.executeQuery());
            return resultbean;
        } else if (sqlType == 4) {
            for (int i = 0; i < inputValueArray.length; i++) {
                if (inputValueArray[i].getClass().getName().equals(
                        "java.lang.String")) {
                    pstmt.setString(i + 1, inputValueArray[i].toString());
                } else {
                    pstmt.setInt(i + 1, Integer.valueOf(inputValueArray[i]
                            .toString()));
                }
            }
            DataBaseBean resultbean = new DataBaseBean();
            resultbean.setConn(conme);
            resultbean.setPstmt(pstmt);
            resultbean.setResultselect(pstmt.executeQuery());
            return resultbean;
        } else {
            DataBaseBean resultbean = new DataBaseBean();
            resultbean.setConn(conme);
            resultbean.setPstmt(pstmt);
            resultbean.setResultselect(pstmt.executeQuery());
            return resultbean;
        }
    }

    /**
     * 关闭MYSQL数据库
     * 
     * @param conn
     *            连接
     * @return 0
     */
    public boolean closeMySql(ResultSet rs, Connection conn,
            PreparedStatement pstmt) {
        try {
            if (rs != null) {
                rs.close();
            }
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("抱歉，关闭数据库失败了");
        }
        return true;
    }

    /**
     * 打开MYSQL数据库
     * 
     * @param conn
     *            连接
     * @return 0
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection openMySql() throws SQLException,
            ClassNotFoundException {
        Connection conn = null;
        Class.forName(DBDRIVER);
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        return conn;
    }

    public static void copy(File src, File dst) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(src),
                        BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dst),
                        BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                while (in.read(buffer) > 0) {
                    out.write(buffer);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static byte[] getBytesFromFile(File file) {
    //
    // long length = file.length();
    // byte[] bytes = new byte[(int) length];
    //
    // try {
    // InputStream is = new FileInputStream(file);
    //
    // // Read in the bytes
    // int offset = 0;
    // int numRead = 0;
    // while (offset < bytes.length
    // && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
    // offset += numRead;
    // }
    //
    // // Ensure all the bytes have been read in
    // if (offset < bytes.length) {
    // throw new IOException("Could not completely read file "
    // + file.getName());
    // }
    //
    // // Close the input stream and return bytes
    // is.close();
    // } catch (Exception e) {
    // throw new RuntimeException(e);
    // }
    // return bytes;
    // }

    public static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
    }
}
