import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class NetworkScanner {
    public static List<String> scanNetwork(String subnet) {
        List<String> activeHosts = new ArrayList<>();
        for (int i = 1; i < 255; i++) {
            String host = subnet + "." + i;
            try {
                InetAddress inetAddress = InetAddress.getByName(host);
                if (inetAddress.isReachable(500)) { // Timeout: 500ms
                    System.out.println("Host Found: " + host);
                    activeHosts.add(host);
                }
            } catch (Exception e) {
                // Ignore unreachable hosts
            }
        }
        return activeHosts;
    }
}
