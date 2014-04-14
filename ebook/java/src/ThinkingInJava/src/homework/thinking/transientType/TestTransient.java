package homework.thinking.transientType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestTransient implements Serializable {
	/** 
     *  
     */
	private static final long serialVersionUID = 1L;
	private transient String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String path = "D:" + File.separator + "object.txt";
		File file = new File(path);
		TestTransient transientDemo = new TestTransient();
		transientDemo.setName("name");
		transientDemo.setPassword("password");
		ObjectOutput output = new ObjectOutputStream(new FileOutputStream(file));
		output.writeObject(transientDemo);
		ObjectInput input = new ObjectInputStream(new FileInputStream(file));
		TestTransient demo = (TestTransient) input.readObject();
		System.out.println(demo.getName() + demo.getPassword());
	}

}