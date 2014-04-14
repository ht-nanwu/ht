package com.StaticParameters;

public interface StaticParameters {
	
	String DBDRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3307/test?useUnicode=true&characterEncoding=utf-8";
	String DBUSER = "root";
	String DBPASSWORD = "a318821";
	String IMAGEPATH = "C:\\hp-realpath\\";
	int BUFFER_SIZE = 1000 * 1024;
	String SELECTARTICLEALL = "SELECT 文章序号,文章标题,文章絮语,文章内容,文章大分类,文章小分类,文章作者,文章更新日 FROM `文章详细内容` WHERE 文章删除='0' ORDER BY 文章更新日";
	String INSERTARTICLE = "INSERT INTO 文章详细内容(文章作者, 文章标题, 文章絮语, 文章内容, 文章大分类, 文章小分类, 文章更新日)VALUES(?,?,?,?,?,?,now())";
	String INSERTPATH = "INSERT INTO 文件路径(文章标题,绝对地址)VALUES(?,?)";
	String SELECTPATH = "SELECT 绝对地址 FROM 文件路径 WHERE 文章标题=? LIMIT ?,1" ;
}
