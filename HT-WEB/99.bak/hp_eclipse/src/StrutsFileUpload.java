import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.StaticParameters.StaticParameters;

import com.opensymphony.xwork2.ActionSupport;

public class StrutsFileUpload extends ActionSupport implements StaticParameters {  
    private static final long serialVersionUID = 572146812454l;  
    private static final int BUFFER_SIZE = 1000 * 1024;  
    private List<File> myFile = new ArrayList<File>();     
    private List<String> fileName = new ArrayList<String>();    //文件名  
    private List<String> imageFileName = new ArrayList<String>();
    private String caption;  
  
    private static void copy(File src, File dst) {  
        try {  
            InputStream in = null;  
            OutputStream out = null;  
            try {  
                in = new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);  
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
     
    private static String getExtention(String fileName) {  
        int pos = fileName.lastIndexOf(".");  
        return fileName.substring(pos);  
    }  
  
    @Override  
    public String execute() {  
        if (myFile == null)  
            return INPUT;
        SimpleDateFormat dataFormatImageName = new SimpleDateFormat("HH-mm-ss");
        SimpleDateFormat dataFormatFileName = new SimpleDateFormat("yyyy-MM-DD");
        File filePath = new File(IMAGEPATH+dataFormatFileName.format(new Date()));
        if(!filePath.exists()){
        	filePath.mkdirs();
        }
        for (int i = 0; i < myFile.size(); i++) {  
            imageFileName.add(dataFormatImageName.format(new Date())+ getExtention(this.getMyFileFileName().get(i))) ;  
            File imageFile = new File(filePath.getPath()+"\\"+imageFileName.get(i));//得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)    
            copy(myFile.get(i), imageFile);  //把图片写入到上面设置的路径里  
  
        }  
        return SUCCESS;  
    }  
  
  
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
  
    public String getCaption() {  
        return caption;  
    }  
  
    public void setCaption(String caption) {  
        this.caption = caption;  
    }  
  
    public static int getBufferSize() {  
        return BUFFER_SIZE;  
    }  
  
}  