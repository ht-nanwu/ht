package com.homeProject.action;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.Dao.ArticleAddDao.Impl.ArticleContentDaoImpl;
import com.Dao.ArticleAddDao.Vo.ArticleAddBean;
import com.StaticParameters.StaticParameters;
import com.homeProject.common.Common;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class articleAddAction extends ActionSupport implements StaticParameters{
		
	private ArticleAddBean articleAdd;
	//上传文件流
	private List<File> myFile = new ArrayList<File>(); 
	//上传文件的名字
    private List<String> fileName = new ArrayList<String>();
    //保存后文件的名字
    private List<String> imageFileName = new ArrayList<String>();
    
	public List<File> getMyFile() {
		return myFile;
	}

	public void setMyFile(List<File> myFile) {
		this.myFile = myFile;
	}

	 public List<String> getMyFileFileName() {  
	        return fileName;  
	    }  
	  
	    public void setMyFileFileName(List<String> fileName) {  
	        this.fileName = fileName;  
	    } 

	public List<String> getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}

	public ArticleAddBean getArticleAdd() {
		return articleAdd;
	}

	public void setArticleAdd(ArticleAddBean articleAdd) {
		this.articleAdd = articleAdd;
	}
	
	
	public String add() throws SQLException, ClassNotFoundException {
		//图片保存路径
	    List<String[]> imagePath = new ArrayList<String[]>(myFile.size());
	    String[] path = new String[2];
		if (myFile == null)  
            return INPUT;
        SimpleDateFormat dataFormatImageName = new SimpleDateFormat("HH-mm-ss.SSS");
        SimpleDateFormat dataFormatFileName = new SimpleDateFormat("yyyy-MM-DD");
        File filePath = new File(IMAGEPATH+dataFormatFileName.format(new Date()));
        if(!filePath.exists()){
        	filePath.mkdirs();
        }
        for (int i = 0; i < myFile.size(); i++) {  
        	imageFileName.add(dataFormatImageName.format(new Date())+ Common.getExtention(getMyFileFileName().get(i))) ;  
            File imageFile = new File(filePath.getPath()+"\\"+imageFileName.get(i));//得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)    
            Common.copy(myFile.get(i), imageFile);  //把图片写入到上面设置的路径里  
            path[0] = articleAdd.getArticle_title();
            path[1] = imageFile.getPath();
            imagePath.add(path);
        }  
		
		ArticleContentDaoImpl addArticle = new ArticleContentDaoImpl();
		
		HttpServletRequest req = ServletActionContext.getRequest();
						
		articleAdd.setArticle_user(req.getRemoteAddr());
						
		addArticle.createArticle(articleAdd,imagePath);
		
		return SUCCESS;
    }

}
