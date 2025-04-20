import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main{
    public static void main(String[] args) {
        
        String versionNo = "1.0.0";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);

        System.out.println("FSM DESIGNER " + versionNo);
        System.out.println("Current date and time: " + currentDateTime);

    }
}