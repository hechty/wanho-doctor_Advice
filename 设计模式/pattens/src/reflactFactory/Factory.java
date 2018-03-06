package reflactFactory;
/**
 * 利用反射,来进行对象的创建
 * @author Administrator
 *
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Factory {
	private static Properties pps = new Properties();
	
	static {
			try {
				pps.load(new FileInputStream("config/object.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static <T> T createObject(String objectName){
		Object o = null;
		try {
			o = Class.forName(pps.getProperty(objectName)).newInstance();
			T t = o.getClass().cast(o);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	
	
}
