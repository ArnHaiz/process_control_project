package unifr.gui.circuit;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

import java.util.function.Function;

public class Segment {
    private static final int MAX_POSSIBLE_NBR_OF_LANES_IN_A_SEGMENT = 16;
    private static final int STROKE_SIZE = 15;
    private static final Color BASE_COLOR = Color.BLACK;
    private static final int SEGMENT_HEIGHT_PIXELS = 144;
    private static final int SEGMENT_WIDTH_PIXELS = 204;
    private static final double SEGMENT_WIDTH_CM_A4 = 8;
    private static final double SEGMENT_HEIGHT_CM_A4 = 5.6;
    private static final double SEGMENT_WIDTH_RATIO = SEGMENT_WIDTH_PIXELS / SEGMENT_WIDTH_CM_A4;
    private static final double SEGMENT_HEIGHT_RATIO = SEGMENT_HEIGHT_PIXELS / SEGMENT_HEIGHT_CM_A4;

    private static int leftX;
    private static int leftY;

    Polyline polyline1;
    Polyline polyline2;
    Polyline polyline3;
    Polyline polyline4;

    byte segmentId;
    Lane[] lanes;
    Lane lane1;
    Lane lane2;
    Lane lane3;
    Lane lane4;
    Lane lane5;
    Lane lane6;
    Lane lane7;
    Lane lane8;
    Lane lane9;
    Lane lane10;
    Lane lane11;
    Lane lane12;
    Lane lane13;
    Lane lane14;
    Lane lane15;
    Lane lane16;

    StackPane stackPane;

    public Segment(byte segmentId) {
        this.segmentId = segmentId;
        polyline1 = new Polyline();
        polyline2 = new Polyline();
        polyline3 = new Polyline();
        polyline4 = new Polyline();

        polyline1.setStrokeWidth(STROKE_SIZE);
        polyline2.setStrokeWidth(STROKE_SIZE);
        polyline3.setStrokeWidth(STROKE_SIZE);
        polyline4.setStrokeWidth(STROKE_SIZE);

        polyline1.setStroke(BASE_COLOR);
        polyline2.setStroke(BASE_COLOR);
        polyline3.setStroke(BASE_COLOR);
        polyline4.setStroke(BASE_COLOR);

        stackPane = new StackPane();
        stackPane.getChildren().add(lane1.pane());
        stackPane.getChildren().add(lane2.pane());
        stackPane.getChildren().add(lane3.pane());
        stackPane.getChildren().add(lane4.pane());
        stackPane.getChildren().add(lane5.pane());
        stackPane.getChildren().add(lane6.pane());
        stackPane.getChildren().add(lane7.pane());
        stackPane.getChildren().add(lane8.pane());
        stackPane.getChildren().add(lane9.pane());
        stackPane.getChildren().add(lane10.pane());
        stackPane.getChildren().add(lane11.pane());
        stackPane.getChildren().add(lane12.pane());
        stackPane.getChildren().add(lane13.pane());
        stackPane.getChildren().add(lane14.pane());
        stackPane.getChildren().add(lane15.pane());
        stackPane.getChildren().add(lane16.pane());




        switch (segmentId) {
            case ((byte) 1):
            case((byte) 9):
            case((byte) 18):
                leftX = 0;
                if (segmentId == 1) {
                    leftY = SEGMENT_HEIGHT_PIXELS;
                } else if (segmentId == 9) {
                    leftY = 2 * SEGMENT_HEIGHT_PIXELS;
                } else {
                    leftY = 3 * SEGMENT_HEIGHT_PIXELS;
                }


                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline1.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);


                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 5.0);
                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.7);

                polyline3.getPoints().add(SEGMENT_WIDTH_RATIO * 5.0);
                polyline3.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline3.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline3.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);

                polyline4.setVisible(false);

                lane1 = new Lane((byte) 1, 261, SEGMENT_WIDTH_RATIO * 4.1, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.09);
                lane2 = new Lane((byte) 2, 247, SEGMENT_WIDTH_RATIO * 4.285, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.285);
                lane3 = new Lane((byte) 3, 232, SEGMENT_WIDTH_RATIO * 4.48, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4);
                lane4 = new Lane((byte) 4, 218, SEGMENT_WIDTH_RATIO * 4.67, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.65);
                lane5 = new Lane((byte) 5, 261, SEGMENT_WIDTH_RATIO * 4.1, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.815);
                lane6 = new Lane((byte) 6, 247, SEGMENT_WIDTH_RATIO * 4.285, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.01);
                lane7 = new Lane((byte) 7, 232, SEGMENT_WIDTH_RATIO * 4.48, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.2);
                lane8 = new Lane((byte) 8, 218, SEGMENT_WIDTH_RATIO * 4.67, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.4);
                lane9 = new Lane((byte) 9, 278, SEGMENT_WIDTH_RATIO * 3.32, 0, SEGMENT_WIDTH_RATIO * 3.32, SEGMENT_HEIGHT_PIXELS);
                lane10 = new Lane((byte) 10, 278, SEGMENT_WIDTH_RATIO * 3.5, 0, SEGMENT_WIDTH_RATIO * 3.5, SEGMENT_HEIGHT_PIXELS);
                lane11 = new Lane((byte) 11, 278, SEGMENT_WIDTH_RATIO * 3.7, 0, SEGMENT_WIDTH_RATIO * 3.7, SEGMENT_HEIGHT_PIXELS);
                lane12 = new Lane((byte) 12, 278, SEGMENT_WIDTH_RATIO * 3.9, 0, SEGMENT_WIDTH_RATIO * 3.9, SEGMENT_HEIGHT_PIXELS);
                lane13 = new Lane((byte) 13, 0, 0, 0, 0, 0);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 0, 0, 0, 0, 0);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);


                break;
            case ((byte) 2):
            case((byte) 12):
            case((byte) 19):
                leftX = 4 * SEGMENT_WIDTH_PIXELS;
                if (segmentId == 2) {
                    leftY = SEGMENT_HEIGHT_PIXELS;
                } else if (segmentId == 12) {
                    leftY = 2 * SEGMENT_HEIGHT_PIXELS;
                } else {
                    leftY = 3 * SEGMENT_HEIGHT_PIXELS;
                }


                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 4.95);
                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 4.95);
                polyline1.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.7);
                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline2.getPoints().add(0.0);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);
                polyline3.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline3.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);

                polyline4.setVisible(false);

                lane1 = new Lane((byte) 1, 261, 0, SEGMENT_HEIGHT_RATIO * 2.09, SEGMENT_WIDTH_RATIO * 3.9, 0);
                lane2 = new Lane((byte) 2, 247, 0, SEGMENT_HEIGHT_RATIO * 2.285, SEGMENT_WIDTH_RATIO * 3.7, 0);
                lane3 = new Lane((byte) 3, 232, 0, SEGMENT_HEIGHT_RATIO * 4, SEGMENT_WIDTH_RATIO * 3.5, 0);
                lane4 = new Lane((byte) 4, 218, 0, SEGMENT_HEIGHT_RATIO * 2.65, SEGMENT_WIDTH_RATIO * 3.3, 0);
                lane5 = new Lane((byte) 5, 261, 0, SEGMENT_HEIGHT_RATIO * 2.815, SEGMENT_WIDTH_RATIO * 3.9, SEGMENT_HEIGHT_PIXELS);
                lane6 = new Lane((byte) 6, 247, 0, SEGMENT_HEIGHT_RATIO * 3.01, SEGMENT_WIDTH_RATIO * 3.7, SEGMENT_HEIGHT_PIXELS);
                lane7 = new Lane((byte) 7, 232, 0, SEGMENT_HEIGHT_RATIO * 3.2, SEGMENT_WIDTH_RATIO * 3.5, SEGMENT_HEIGHT_PIXELS);
                lane8 = new Lane((byte) 8, 218, 0, SEGMENT_HEIGHT_RATIO * 3.4, SEGMENT_WIDTH_RATIO * 3.3, SEGMENT_HEIGHT_PIXELS);
                lane9 = new Lane((byte) 9, 278, SEGMENT_WIDTH_RATIO * 4.615, 0, SEGMENT_WIDTH_RATIO * 4.615, SEGMENT_HEIGHT_PIXELS);
                lane10 = new Lane((byte) 10, 278, SEGMENT_WIDTH_RATIO * 4.42, 0, SEGMENT_WIDTH_RATIO * 4.42, SEGMENT_HEIGHT_PIXELS);
                lane11 = new Lane((byte) 11, 278, SEGMENT_WIDTH_RATIO * 4.245, 0, SEGMENT_WIDTH_RATIO * 4.245, SEGMENT_HEIGHT_PIXELS);
                lane12 = new Lane((byte) 12, 278, SEGMENT_WIDTH_RATIO * 4.07, 0, SEGMENT_WIDTH_RATIO * 4.07, SEGMENT_HEIGHT_PIXELS);
                lane13 = new Lane((byte) 13, 0, 0, 0, 0, 0);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 0, 0, 0, 0, 0);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);

                break;
            case ((byte) 3):
            case((byte) 6):
                leftX = 2 * SEGMENT_WIDTH_PIXELS;
                if (segmentId == 3) {
                    leftY = 4 * SEGMENT_HEIGHT_PIXELS;
                } else {
                    leftY = 2 * SEGMENT_HEIGHT_PIXELS;
                }

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                polyline4.setVisible(false);

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 4):
            case((byte) 17):
                leftX = 2 * SEGMENT_WIDTH_PIXELS;
                if (segmentId == 4) {
                    leftY = 0;
                } else {
                    leftY = 3 * SEGMENT_HEIGHT_PIXELS;
                }

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 5):
                leftX = 2 * SEGMENT_WIDTH_PIXELS;
                leftY = SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 7):
            case((byte) 8):
                leftY = SEGMENT_HEIGHT_PIXELS;
                if (segmentId == 7) {
                    leftX = SEGMENT_WIDTH_PIXELS;
                } else {
                    leftX = 3 * SEGMENT_WIDTH_PIXELS;
                }

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 10):
                leftX = 3 * SEGMENT_WIDTH_PIXELS;
                leftY = 2 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 11):
                leftX = SEGMENT_WIDTH_PIXELS;
                leftY = 2 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 13):
                leftX = 0;
                leftY = 0;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 14):
                leftX = 0;
                leftY = 4 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 15):
                leftX = 4 * SEGMENT_WIDTH_PIXELS;
                leftY = 4 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 16):
                leftX = 4 * SEGMENT_WIDTH_PIXELS;
                leftY = 0;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 20):
            case ((byte) 21):
                if (segmentId == 20) {
                    leftX = SEGMENT_WIDTH_PIXELS;
                } else {
                    leftX = 3 * SEGMENT_WIDTH_PIXELS;
                }
                leftY = 0;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 22):
                leftX = SEGMENT_WIDTH_PIXELS;
                leftY = 3 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 23):
                leftX = 3 * SEGMENT_WIDTH_PIXELS;
                leftY = 3 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
            case ((byte) 24):
            case ((byte) 25):
                leftY = 4 * SEGMENT_HEIGHT_PIXELS;
                if (segmentId == 24) {
                    leftX = SEGMENT_WIDTH_PIXELS;
                } else {
                    leftX = 3 * SEGMENT_WIDTH_PIXELS;
                }

                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();
                polyline1.getPoints().add();

                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();
                polyline2.getPoints().add();

                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();
                polyline3.getPoints().add();

                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();
                polyline4.getPoints().add();

                lane1 = new Lane((byte) 1, );
                lane2 = new Lane((byte) 2, );
                lane3 = new Lane((byte) 3, );
                lane4 = new Lane((byte) 4, );
                lane5 = new Lane((byte) 5, );
                lane6 = new Lane((byte) 6, );
                lane7 = new Lane((byte) 7, );
                lane8 = new Lane((byte) 8, );
                lane9 = new Lane((byte) 9, );
                lane10 = new Lane((byte) 10, );
                lane11 = new Lane((byte) 11, );
                lane12 = new Lane((byte) 12, );
                lane13 = new Lane((byte) 13, );
                lane14 = new Lane((byte) 14, );
                lane15 = new Lane((byte) 15, );
                lane16 = new Lane((byte) 16, );

                break;
        }

        lanes = new Lane[MAX_POSSIBLE_NBR_OF_LANES_IN_A_SEGMENT];
        lanes[0] = lane1;
        lanes[1] = lane2;
        lanes[2] = lane3;
        lanes[3] = lane4;
        lanes[4] = lane5;
        lanes[5] = lane6;
        lanes[6] = lane7;
        lanes[7] = lane8;
        lanes[8] = lane9;
        lanes[9] = lane10;
        lanes[10] = lane11;
        lanes[11] = lane12;
        lanes[12] = lane13;
        lanes[13] = lane14;
        lanes[14] = lane15;
        lanes[15] = lane16;
    }

    public Pane pane() {return stackPane;}
}
