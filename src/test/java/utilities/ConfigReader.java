package utilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
	
	private Properties prop;
	
	
	/**
	 * to maintain encapsulation we don not want to allow access directly instead of this creating a method of Properties
	 * @return it return properties prop object
	 * 
	 */

	
	public Properties init_prop()
	{
		prop=new Properties();
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prop;
		
		
		
		
		
		
		/**
		 * without try catch
		 * 
		 * 
		 * prop=new Properties();
		 * FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		 * return prop;
		 */
		
		
		
		
		
		
	}

}
