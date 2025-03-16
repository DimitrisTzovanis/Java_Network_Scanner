import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkScannerGUI extends Application {
    private TextArea logArea = new TextArea();
    private ExecutorService executor = Executors.newFixedThreadPool(10);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java Network Scanner");
        Button scanButton = new Button("Scan Network");

        scanButton.setOnAction(e -> executor.execute(this::startScan));

        VBox layout = new VBox(10, scanButton, logArea);
        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startScan() {
        Platform.runLater(() -> logArea.appendText("Scanning...\n"));

        List<String> hosts = NetworkScanner.scanNetwork("192.168.1"); // Change subnet
        List<String> arpDevices = ArpScanner.getArpTable();

        /*for (String ip : hosts) {
            executor.execute(() -> {
                List<Integer> ports = PortScanner.scanPorts(ip);
                Platform.runLater(() -> logArea.appendText("Host: " + ip + " Open Ports: " + ports + "\n"));
            });
        }*/
        Platform.runLater(() -> {
            for (String host : arpDevices) {
                if(!host.equals(" ?") || !host.equals("?")) {
                    logArea.appendText("Host: " + host + "\n");
                }
            }

        });
        Platform.runLater(() -> logArea.appendText("Scan Complete.\n"));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
