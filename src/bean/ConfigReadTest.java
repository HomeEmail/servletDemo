package bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReadTest {
    private static Properties pp = new Properties();

    public static void main(String[] args){

        try{
            File dir=new File(".");
            System.out.println(dir.getCanonicalPath()+File.separator);
            String filePath=dir.getCanonicalPath()+File.separator+"/web/WEB-INF/dbConfig.properties";
            readFile(filePath);
        }catch (IOException e){

        }
    }
    public static void readFile(String filePath) throws IOException{
        System.out.println("读取properties类型的配置文件");
        File fin=new File(filePath);
        if(fin.exists()){
            System.out.println("has file");
        }else {
            System.out.println("has not file");
        }
        try{
            pp.load(new FileInputStream(filePath));
        }catch (Exception e){
            System.out.println("read dbConfig file fail");
        }
        for(Object obj : pp.keySet()){
            String key = ((String) obj);

            System.out.println("key: "+key+ " => "+"value: "+pp.get(key));
        }
        //知道key了，直接取值
        System.out.println("host = "+pp.get("host"));
        System.out.println("host1 = "+pp.get("host1"));
        if(pp.get("host1")==null){
            System.out.println("no key host1");
        }
    }

}
