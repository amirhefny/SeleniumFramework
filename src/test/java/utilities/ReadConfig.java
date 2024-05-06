package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig() //constructor to read complete File
    {
        File src = new File("./Configuration/config.properties");

        try {//to read and load the file
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {//if the path of file is wrong
            System.out.println("Exception is " + e.getMessage());
        }

    }
    public String getApplicationURL()
    {
        String url=pro.getProperty("baseUrl");
        return url;
    }
    public String getUsername()
    {
        String username=pro.getProperty("username");
        return username;
    }

    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }
}
