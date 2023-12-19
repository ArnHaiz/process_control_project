package unifr.gui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.eclipse.paho.client.mqttv3.MqttException;
import unifr.gui.circuit.Circuit;
import unifr.project.MqttHandler;

import java.util.function.Consumer;

public class GraphicInterface extends Application {
    private final static int WINDOW_WIDTH = 1280;
    private final static int WINDOW_HEIGHT = 720;
    private final static int CIRCUIT_DISPLAY_WIDTH = 1020;
    private final static int CIRCUIT_DISPLAY_HEIGHT = 720;
    private final static int STATUS_DISPLAY_WIDTH = 260;
    private final static int STATUS_DISPLAY_HEIGHT = 720;

    private static MqttHandler mqttHandler;
    private static String vehicleId;

    private static CarStatus carStatus;
    private static PredictionInfos predictionInfos;
    private static Circuit circuit;

    private BorderPane borderPane;
    private StackPane stackPane;
    private SplitPane splitPane;

    private MenuBar menuBar;
    private MenuItem menuItem;

    public static void main(String[] args) throws MqttException {
        //mqttHandler = new MqttHandler("tcp://192.168.4.1:1883", "predictionGroup");
        vehicleId = "d205effe02cb";

        //carStatus = new CarStatus(mqttHandler, vehicleId);
        predictionInfos = new PredictionInfos();
        circuit = new Circuit();

        launch(args);}

    @Override
    public void start(Stage primaryStage) {
        borderPane = new BorderPane();
        stackPane = new StackPane();
        splitPane = new SplitPane();

        stackPane.setMaxSize(CIRCUIT_DISPLAY_WIDTH, CIRCUIT_DISPLAY_HEIGHT);
        stackPane.setMinSize(CIRCUIT_DISPLAY_WIDTH, CIRCUIT_DISPLAY_HEIGHT);

        splitPane.setMinSize(STATUS_DISPLAY_WIDTH, STATUS_DISPLAY_HEIGHT);
        splitPane.setMaxSize(STATUS_DISPLAY_WIDTH, STATUS_DISPLAY_HEIGHT);

        borderPane.setMinSize(CIRCUIT_DISPLAY_WIDTH + STATUS_DISPLAY_WIDTH, CIRCUIT_DISPLAY_HEIGHT + STATUS_DISPLAY_HEIGHT);
        borderPane.setMaxSize(CIRCUIT_DISPLAY_WIDTH + STATUS_DISPLAY_WIDTH, CIRCUIT_DISPLAY_HEIGHT + STATUS_DISPLAY_HEIGHT);

        menuBar = new MenuBar();
        menuItem = new MenuItem();

        //create the panes with their infos and add them to the stack pane
        splitPane.getItems().add(circuit.pane());
        splitPane.setOrientation(Orientation.HORIZONTAL);
        //splitPane.getItems().add(carStatus.pane());

        stackPane.getChildren().add(splitPane);

        borderPane.setCenter(stackPane);
        borderPane.setTop(menuBar);

        primaryStage.setScene(new Scene(borderPane, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private static final class ErrorConsumer implements Consumer<String> {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }
}
