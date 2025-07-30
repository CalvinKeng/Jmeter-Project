package mygroup.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class ManagementApplication
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ManagementApplication.class, args);
        System.out.println( "Hello World\n~專案已啟動~\n於瀏覽器之內localhost:8080的url後方輸入/user會顯示一些資料" );
    }
}
