import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ArpScanner {
    public static List<String> getArpTable() {
        List<String> devices = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec("arp -a");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(".")) { // Extract IP addresses
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length > 1) {
                        devices.add(parts[0]);
                        System.out.println("ARP Detected Device: " + parts[0]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devices;
    }
}
