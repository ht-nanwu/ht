package bean;

import java.util.List;
import java.util.Map;

import common.DButil;

public class beanInterface {

	public static void main(String[] args) {
		DButil a = new DButil();
		List<Object> test = a.select(airticleInfo.class, null);
		airticleInfo b = (airticleInfo)test.get(0);
	}

}
