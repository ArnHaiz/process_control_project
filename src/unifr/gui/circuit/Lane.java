package unifr.gui.circuit;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class Lane {
    private static final int STROKE_SIZE = 8;
    private static final Color BASE_COLOR = Color.BLACK;

    private byte laneId;
    private double realLength;
    private double x0, y0, x1, y1;
    private double displayedLength;

    private Pane Pane;

    public Lane(byte laneId, double realLength, double x0, double y0, double x1, double y1) {
        this.laneId = laneId;
        this.realLength = realLength;
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        displayedLength = Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));

        Pane = new StackPane();
        Polyline polyline = new Polyline();

        polyline.setStrokeWidth(STROKE_SIZE);
        polyline.setStroke(BASE_COLOR);
        Pane.getChildren().add(polyline);
        polyline.getPoints().add(x0);
        polyline.getPoints().add(y0);
        polyline.getPoints().add(x1);
        polyline.getPoints().add(y1);
    }

    public Pane pane() {return Pane;}
}
