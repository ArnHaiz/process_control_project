package unifr.gui.circuit;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;


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

    public int leftX;
    public int leftY;

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


        switch (segmentId) {
            case ((byte) 1), ((byte) 9), ((byte) 18) -> {
                leftX = 0;
                if (segmentId == (byte) 1) {
                    leftY = SEGMENT_HEIGHT_PIXELS;
                } else if (segmentId == (byte) 9) {
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

                lane1 = new Lane((byte) 1, 261, SEGMENT_WIDTH_RATIO * 4.1, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.815);
                lane2 = new Lane((byte) 2, 247, SEGMENT_WIDTH_RATIO * 4.285, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.01);
                lane3 = new Lane((byte) 3, 232, SEGMENT_WIDTH_RATIO * 4.48, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.2);
                lane4 = new Lane((byte) 4, 218, SEGMENT_WIDTH_RATIO * 4.67, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.4);
                lane5 = new Lane((byte) 5, 261, SEGMENT_WIDTH_RATIO * 4.1, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.09);
                lane6 = new Lane((byte) 6, 247, SEGMENT_WIDTH_RATIO * 4.285, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.285);
                lane7 = new Lane((byte) 7, 232, SEGMENT_WIDTH_RATIO * 4.48, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.4);
                lane8 = new Lane((byte) 8, 218, SEGMENT_WIDTH_RATIO * 4.67, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.65);
                lane9 = new Lane((byte) 9, 278, SEGMENT_WIDTH_RATIO * 3.32, 0, SEGMENT_WIDTH_RATIO * 3.32, SEGMENT_HEIGHT_PIXELS);
                lane10 = new Lane((byte) 10, 278, SEGMENT_WIDTH_RATIO * 3.5, 0, SEGMENT_WIDTH_RATIO * 3.5, SEGMENT_HEIGHT_PIXELS);
                lane11 = new Lane((byte) 11, 278, SEGMENT_WIDTH_RATIO * 3.7, 0, SEGMENT_WIDTH_RATIO * 3.7, SEGMENT_HEIGHT_PIXELS);
                lane12 = new Lane((byte) 12, 278, SEGMENT_WIDTH_RATIO * 3.9, 0, SEGMENT_WIDTH_RATIO * 3.9, SEGMENT_HEIGHT_PIXELS);
                lane13 = new Lane((byte) 13, 0, 0, 0, 0, 0);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 0, 0, 0, 0, 0);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);
            }

            case ((byte) 2), ((byte) 12), ((byte) 19) -> {
                leftX = 4 * SEGMENT_WIDTH_PIXELS;
                if (segmentId == (byte) 2) {
                    leftY = SEGMENT_HEIGHT_PIXELS;
                } else if (segmentId == (byte) 12) {
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

                lane1 = new Lane((byte) 1, 261, 0, SEGMENT_HEIGHT_RATIO * 2.815, SEGMENT_WIDTH_RATIO * 3.9, SEGMENT_HEIGHT_PIXELS);
                lane2 = new Lane((byte) 2, 247, 0, SEGMENT_HEIGHT_RATIO * 3.01, SEGMENT_WIDTH_RATIO * 3.7, SEGMENT_HEIGHT_PIXELS);
                lane3 = new Lane((byte) 3, 232, 0, SEGMENT_HEIGHT_RATIO * 3.2, SEGMENT_WIDTH_RATIO * 3.5, SEGMENT_HEIGHT_PIXELS);
                lane4 = new Lane((byte) 4, 218, 0, SEGMENT_HEIGHT_RATIO * 3.4, SEGMENT_WIDTH_RATIO * 3.3, SEGMENT_HEIGHT_PIXELS);
                lane5 = new Lane((byte) 5, 261, 0, SEGMENT_HEIGHT_RATIO * 2.09, SEGMENT_WIDTH_RATIO * 3.9, 0);
                lane6 = new Lane((byte) 6, 247, 0, SEGMENT_HEIGHT_RATIO * 2.285, SEGMENT_WIDTH_RATIO * 3.7, 0);
                lane7 = new Lane((byte) 7, 232, 0, SEGMENT_HEIGHT_RATIO * 4, SEGMENT_WIDTH_RATIO * 3.5, 0);
                lane8 = new Lane((byte) 8, 218, 0, SEGMENT_HEIGHT_RATIO * 2.65, SEGMENT_WIDTH_RATIO * 3.3, 0);
                lane9 = new Lane((byte) 9, 278, SEGMENT_WIDTH_RATIO * 4.615, 0, SEGMENT_WIDTH_RATIO * 4.615, SEGMENT_HEIGHT_PIXELS);
                lane10 = new Lane((byte) 10, 278, SEGMENT_WIDTH_RATIO * 4.42, 0, SEGMENT_WIDTH_RATIO * 4.42, SEGMENT_HEIGHT_PIXELS);
                lane11 = new Lane((byte) 11, 278, SEGMENT_WIDTH_RATIO * 4.245, 0, SEGMENT_WIDTH_RATIO * 4.245, SEGMENT_HEIGHT_PIXELS);
                lane12 = new Lane((byte) 12, 278, SEGMENT_WIDTH_RATIO * 4.07, 0, SEGMENT_WIDTH_RATIO * 4.07, SEGMENT_HEIGHT_PIXELS);
                lane13 = new Lane((byte) 13, 0, 0, 0, 0, 0);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 0, 0, 0, 0, 0);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);
            }
            case ((byte) 4), ((byte) 6) -> {
                leftX = 2 * SEGMENT_WIDTH_PIXELS;
                if (segmentId == (byte) 4) {
                    leftY = 0;
                } else {
                    leftY = 2 * SEGMENT_HEIGHT_PIXELS;
                }

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(0.0);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.08);
                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 3);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline3.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline3.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline3.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline3.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.08);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                         0.39, 0.57, 0.75, 0.92, 1.11, 1.3, 1.5, 1.7 || 3.37, 3.58, 3.75, 3.94, 4.12, 4.31, 4.5, 4.7
                lane1 = new Lane((byte) 1, 328, 0, SEGMENT_HEIGHT_RATIO * 1.11, SEGMENT_WIDTH_RATIO * 3.37, SEGMENT_HEIGHT_PIXELS);
                lane2 = new Lane((byte) 2, 313, 0, SEGMENT_HEIGHT_RATIO * 1.3, SEGMENT_WIDTH_RATIO * 3.58, SEGMENT_HEIGHT_PIXELS);
                lane3 = new Lane((byte) 3, 299, 0, SEGMENT_HEIGHT_RATIO * 1.5, SEGMENT_WIDTH_RATIO * 3.75, SEGMENT_HEIGHT_PIXELS);
                lane4 = new Lane((byte) 4, 284, 0, SEGMENT_HEIGHT_RATIO * 1.7, SEGMENT_WIDTH_RATIO * 3.94, SEGMENT_HEIGHT_PIXELS);
                lane5 = new Lane((byte) 5, 328, SEGMENT_WIDTH_RATIO * 4.12, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.11);
                lane6 = new Lane((byte) 6, 313, SEGMENT_WIDTH_RATIO * 4.31, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.3);
                lane7 = new Lane((byte) 7, 299, SEGMENT_WIDTH_RATIO * 4.5, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.5);
                lane8 = new Lane((byte) 8, 284, SEGMENT_WIDTH_RATIO * 4.7, SEGMENT_HEIGHT_PIXELS, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.7);
                lane9 = new Lane((byte) 9, 196, 0, SEGMENT_HEIGHT_RATIO * 0.39, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.39);
                lane10 = new Lane((byte) 10, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.39, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.39);
                lane11 = new Lane((byte) 11, 196, 0, SEGMENT_HEIGHT_RATIO * 0.57, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57);
                lane12 = new Lane((byte) 12, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57);
                lane13 = new Lane((byte) 13, 196, 0, SEGMENT_HEIGHT_RATIO * 0.75, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.75);
                lane14 = new Lane((byte) 14, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57);
                lane15 = new Lane((byte) 15, 196, 0, SEGMENT_HEIGHT_RATIO * 0.92, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.92);
                lane16 = new Lane((byte) 16, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57);
            }

            case ((byte) 3), ((byte) 5) -> {
                leftX = 2 * SEGMENT_WIDTH_PIXELS;
                if (segmentId == (byte) 3) {
                    leftY = 4 * SEGMENT_HEIGHT_PIXELS;
                } else {
                    leftY = SEGMENT_HEIGHT_PIXELS;
                }

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.6);
                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 3);
                polyline1.getPoints().add(0.0);

                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.6);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline3.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline3.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                         3.9, 4.1, 4.3, 4.49, 4.67, 4.85, 5.04, 5.22 || 3.37, 3.58, 3.75, 3.94, 4.12, 4.31, 4.5, 4.7
                lane1 = new Lane((byte) 1, 328, 0, SEGMENT_HEIGHT_RATIO * 4.49, SEGMENT_WIDTH_RATIO * 3.94, 0);
                lane2 = new Lane((byte) 2, 313, 0, SEGMENT_HEIGHT_RATIO * 4.3, SEGMENT_WIDTH_RATIO * 3.75, 0);
                lane3 = new Lane((byte) 3, 299, 0, SEGMENT_HEIGHT_RATIO * 4.1, SEGMENT_WIDTH_RATIO * 3.58, 0);
                lane4 = new Lane((byte) 4, 284, 0, SEGMENT_HEIGHT_RATIO * 3.9, SEGMENT_WIDTH_RATIO * 3.37, 0);
                lane5 = new Lane((byte) 5, 328, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.49, SEGMENT_WIDTH_RATIO * 4.12, 0);
                lane6 = new Lane((byte) 6, 313, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.3, SEGMENT_WIDTH_RATIO * 4.31, 0);
                lane7 = new Lane((byte) 7, 299, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.1, SEGMENT_WIDTH_RATIO * 4.5, 0);
                lane8 = new Lane((byte) 8, 284, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.9, SEGMENT_WIDTH_RATIO * 4.7, 0);
                lane9 = new Lane((byte) 9, 196, 0, SEGMENT_HEIGHT_RATIO * 4.67, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.67);
                lane10 = new Lane((byte) 10, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.67, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.67);
                lane11 = new Lane((byte) 11, 196, 0, SEGMENT_HEIGHT_RATIO * 4.85, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.85);
                lane12 = new Lane((byte) 12, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.85, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.85);
                lane13 = new Lane((byte) 13, 196, 0, SEGMENT_HEIGHT_RATIO * 5.04, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.04);
                lane14 = new Lane((byte) 14, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.04, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.04);
                lane15 = new Lane((byte) 15, 196, 0, SEGMENT_HEIGHT_RATIO * 5.22, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.22);
                lane16 = new Lane((byte) 16, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.22, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.22);
            }

            case ((byte) 17) -> {
                leftX = 2 * SEGMENT_WIDTH_PIXELS;
                leftY = 3 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.85);
                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 3);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.85);
                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 3);
                polyline1.getPoints().add(0.0);

                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.85);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.85);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);
                polyline3.getPoints().add(SEGMENT_WIDTH_RATIO * 3);
                polyline3.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);
                polyline3.getPoints().add(SEGMENT_WIDTH_RATIO * 3);
                polyline3.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline4.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline4.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline4.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline4.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);
                polyline4.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline4.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);

                //2.2, 2.4, 2.6, 2.8, 3, 3.18, 3.38, 3.55 || 3.35, 3.55, 3.73, 3.91, 4.1, 4.3, 4.5, 4.7
                lane1 = new Lane((byte) 1, 392, 0, SEGMENT_HEIGHT_RATIO * 2.2, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.2);
                lane2 = new Lane((byte) 2, 392, 0, SEGMENT_HEIGHT_RATIO * 2.4, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.4);
                lane3 = new Lane((byte) 3, 392, 0, SEGMENT_HEIGHT_RATIO * 2.6, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.6);
                lane4 = new Lane((byte) 4, 392, 0, SEGMENT_HEIGHT_RATIO * 2.8, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.8);
                lane5 = new Lane((byte) 5, 392, 0, SEGMENT_HEIGHT_RATIO * 3, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3);
                lane6 = new Lane((byte) 6, 392, 0, SEGMENT_HEIGHT_RATIO * 3.18, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.18);
                lane7 = new Lane((byte) 7, 392, 0, SEGMENT_HEIGHT_RATIO * 3.38, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.38);
                lane8 = new Lane((byte) 8, 392, 0, SEGMENT_HEIGHT_RATIO * 3.55, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.55);
                lane9 = new Lane((byte) 9, 392, SEGMENT_WIDTH_RATIO * 3.35, 0, SEGMENT_WIDTH_RATIO * 3.35, SEGMENT_HEIGHT_PIXELS);
                lane10 = new Lane((byte) 10, 392, SEGMENT_WIDTH_RATIO * 3.55, 0, SEGMENT_WIDTH_RATIO * 3.55, SEGMENT_HEIGHT_PIXELS);
                lane11 = new Lane((byte) 11, 392, SEGMENT_WIDTH_RATIO * 3.73, 0, SEGMENT_WIDTH_RATIO * 3.73, SEGMENT_HEIGHT_PIXELS);
                lane12 = new Lane((byte) 12, 392, SEGMENT_WIDTH_RATIO * 3.91, 0, SEGMENT_WIDTH_RATIO * 3.91, SEGMENT_HEIGHT_PIXELS);
                lane13 = new Lane((byte) 13, 392, SEGMENT_WIDTH_RATIO * 4.1, 0, SEGMENT_WIDTH_RATIO * 4.1, SEGMENT_HEIGHT_PIXELS);
                lane14 = new Lane((byte) 14, 392, SEGMENT_WIDTH_RATIO * 4.3, 0, SEGMENT_WIDTH_RATIO * 4.3, SEGMENT_HEIGHT_PIXELS);
                lane15 = new Lane((byte) 15, 392, SEGMENT_WIDTH_RATIO * 4.5, 0, SEGMENT_WIDTH_RATIO * 4.5, SEGMENT_HEIGHT_PIXELS);
                lane16 = new Lane((byte) 16, 392, SEGMENT_WIDTH_RATIO * 4.7, 0, SEGMENT_WIDTH_RATIO * 4.7, SEGMENT_HEIGHT_PIXELS);
            }

            case ((byte) 22), ((byte) 23) -> {
                leftY = 3 * SEGMENT_HEIGHT_PIXELS;
                if (segmentId == (byte) 22) {
                    leftX = SEGMENT_WIDTH_PIXELS;
                } else {
                    leftX = 3 * SEGMENT_WIDTH_PIXELS;
                }

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.7);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.7);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //2.2, 2.4, 2.6, 2.8, 3, 3.18, 3.38, 3.55
                lane1 = new Lane((byte) 1, 196, 0, SEGMENT_HEIGHT_RATIO * 3.55, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.55);
                lane2 = new Lane((byte) 2, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.55, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3);
                lane3 = new Lane((byte) 3, 196, 0, SEGMENT_HEIGHT_RATIO * .38, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.38);
                lane4 = new Lane((byte) 4, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.38, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3);
                lane5 = new Lane((byte) 5, 196, 0, SEGMENT_HEIGHT_RATIO * 3.18, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.18);
                lane6 = new Lane((byte) 6, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.18, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3);
                lane7 = new Lane((byte) 7, 196, 0, SEGMENT_HEIGHT_RATIO * 3, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3);
                lane8 = new Lane((byte) 8, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3);
                lane9 = new Lane((byte) 9, 196, 0, SEGMENT_HEIGHT_RATIO * 2.8, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.8);
                lane10 = new Lane((byte) 10, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.8, SEGMENT_WIDTH_RATIO, SEGMENT_HEIGHT_RATIO * 2.8);
                lane11 = new Lane((byte) 11, 196, 0, SEGMENT_HEIGHT_RATIO * 2.6, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.6);
                lane12 = new Lane((byte) 12, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.6, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.6);
                lane13 = new Lane((byte) 13, 196, 0, SEGMENT_HEIGHT_RATIO * 2.4, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.4);
                lane14 = new Lane((byte) 14, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.4, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.4);
                lane15 = new Lane((byte) 15, 196, 0, SEGMENT_HEIGHT_RATIO * 2.2, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.2);
                lane16 = new Lane((byte) 16, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.2, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.2);
            }

            case ((byte) 10) -> {
                leftX = 3 * SEGMENT_WIDTH_PIXELS;
                leftY = 2 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.75);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.1);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                lane1 = new Lane((byte) 1, 142, 0, SEGMENT_HEIGHT_RATIO * 1.7, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.42 + 1.7));
                lane2 = new Lane((byte) 2, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.42 + 1.7), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.42);
                lane3 = new Lane((byte) 3, 142, 0, SEGMENT_HEIGHT_RATIO * 1.51, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.25 + 1.51));
                lane4 = new Lane((byte) 4, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.25 + 1.51), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.25);
                lane5 = new Lane((byte) 5, 142, 0, SEGMENT_HEIGHT_RATIO * 1.33, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.07 + 1.33));
                lane6 = new Lane((byte) 6, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.07 + 1.33), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.07);
                lane7 = new Lane((byte) 7, 142, 0, SEGMENT_HEIGHT_RATIO * 1.15, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.89 + 1.15));
                lane8 = new Lane((byte) 8, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.89 + 1.15), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.89);
                lane9 = new Lane((byte) 9, 142, 0, SEGMENT_HEIGHT_RATIO * 0.97, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.7 + 0.97));
                lane10 = new Lane((byte) 10, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.7 + 0.97), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.7);
                lane11 = new Lane((byte) 11, 142, 0, SEGMENT_HEIGHT_RATIO * 0.8, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.5 + 0.8));
                lane12 = new Lane((byte) 12, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.5 + 0.8), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.5);
                lane13 = new Lane((byte) 13, 142, 0, SEGMENT_HEIGHT_RATIO * 0.6, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.3 + 0.6));
                lane14 = new Lane((byte) 14, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.3 + 0.6), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.3);
                lane15 = new Lane((byte) 15, 142, 0, SEGMENT_HEIGHT_RATIO * 0.4, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.1 + 0.4));
                lane16 = new Lane((byte) 16, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.1 + 0.4), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 2.1);
            }

            case ((byte) 11) -> {
                leftX = SEGMENT_WIDTH_PIXELS;
                leftY = 2 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.75);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(0.0);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.1);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //2.1, 2.3, 2.5, 2.7, 2.89, 3.07, 3.25, 3.42 || 0.4, 0.6, 0.8, 0.97, 1.15, 1.33, 1.51, 1.7
                lane1 = new Lane((byte) 1, 142, 0, SEGMENT_HEIGHT_RATIO * 3.42, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.42 + 1.7));
                lane2 = new Lane((byte) 2, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.42 + 1.7), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.7);
                lane3 = new Lane((byte) 3, 142, 0, SEGMENT_HEIGHT_RATIO * 3.25, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.25 + 1.51));
                lane4 = new Lane((byte) 4, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.25 + 1.51), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.51);
                lane5 = new Lane((byte) 5, 142, 0, SEGMENT_HEIGHT_RATIO * 3.07, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.07 + 1.33));
                lane6 = new Lane((byte) 6, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.07 + 1.33), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.33);
                lane7 = new Lane((byte) 7, 142, 0, SEGMENT_HEIGHT_RATIO * 2.89, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.89 + 1.15));
                lane8 = new Lane((byte) 8, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.89 + 1.15), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.15);
                lane9 = new Lane((byte) 9, 142, 0, SEGMENT_HEIGHT_RATIO * 2.7, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.7 + 0.97));
                lane10 = new Lane((byte) 10, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.7 + 0.97), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.97);
                lane11 = new Lane((byte) 11, 142, 0, SEGMENT_HEIGHT_RATIO * 2.5, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.5 + 0.8));
                lane12 = new Lane((byte) 12, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.5 + 0.8), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.8);
                lane13 = new Lane((byte) 13, 142, 0, SEGMENT_HEIGHT_RATIO * 2.3, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.3 + 0.6));
                lane14 = new Lane((byte) 14, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.3 + 0.6), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.6);
                lane15 = new Lane((byte) 15, 142, 0, SEGMENT_HEIGHT_RATIO * 2.1, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.1 + 0.4));
                lane16 = new Lane((byte) 16, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (2.1 + 0.4), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.4);
            }

            case ((byte) 13) -> {
                leftX = 0;
                leftY = 0;

                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline1.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(0.0);

                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.08);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                         3.32, 3.5, 3.7, 3.9, 4.1, 4.285, 4.48, 4.67 || 0.39, 0.57, 0.75, 0.92, 1.11, 1.3, 1.5, 1.7
                lane1 = new Lane((byte) 1, 191.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.32 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.39 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.39);
                lane2 = new Lane((byte) 2, 191.5, SEGMENT_WIDTH_RATIO * 3.32, SEGMENT_HEIGHT_PIXELS, 0.5 * (SEGMENT_WIDTH_RATIO * 3.32 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.39 + SEGMENT_HEIGHT_PIXELS));
                lane3 = new Lane((byte) 3, 184.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.5 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.57 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57);
                lane4 = new Lane((byte) 4, 184.5, SEGMENT_WIDTH_RATIO * 3.5, SEGMENT_HEIGHT_PIXELS, 0.5 * (SEGMENT_WIDTH_RATIO * 3.5 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.57 + SEGMENT_HEIGHT_PIXELS));
                lane5 = new Lane((byte) 5, 176.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.7 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.75 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.75);
                lane6 = new Lane((byte) 6, 176.5, SEGMENT_WIDTH_RATIO * 3.7, SEGMENT_HEIGHT_PIXELS, 0.5 * (SEGMENT_WIDTH_RATIO * 3.7 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.75 + SEGMENT_HEIGHT_PIXELS));
                lane7 = new Lane((byte) 7, 169.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.9 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.92 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.92);
                lane8 = new Lane((byte) 8, 169.5, SEGMENT_WIDTH_RATIO * 3.9, SEGMENT_HEIGHT_PIXELS, 0.5 * (SEGMENT_WIDTH_RATIO * 3.9 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 0.92 + SEGMENT_HEIGHT_PIXELS));
                lane9 = new Lane((byte) 9, 324, 0.5 * (SEGMENT_WIDTH_RATIO * 4.1 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 1.11 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.11);
                lane10 = new Lane((byte) 10, 0, 0, 0, 0, 0);
                lane11 = new Lane((byte) 11, 309, 0.5 * (SEGMENT_WIDTH_RATIO * 4.285 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 1.3 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.3);
                lane12 = new Lane((byte) 12, 0, 0, 0, 0, 0);
                lane13 = new Lane((byte) 13, 294, 0.5 * (SEGMENT_WIDTH_RATIO * 4.48 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 1.5 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.5);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 280, 0.5 * (SEGMENT_WIDTH_RATIO * 4.67 + SEGMENT_WIDTH_PIXELS), 0.5 * (SEGMENT_HEIGHT_RATIO * 1.7 + SEGMENT_HEIGHT_PIXELS), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.7);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);
            }

            case ((byte) 14) -> {
                leftX = 0;
                leftY = 4 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 5);
                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.61);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                         3.32, 3.5, 3.7, 3.9, 4.1, 4.285, 4.48, 4.67 || 5.31, 5.12, 4.95, 4.75, 4.57, 4.39, 4.2, 4
                lane1 = new Lane((byte) 1, 191.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.32 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 5.31, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.31);
                lane2 = new Lane((byte) 2, 191.5, SEGMENT_WIDTH_RATIO * 3.32, 0, 0.5 * (SEGMENT_WIDTH_RATIO * 3.32 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 5.31);
                lane3 = new Lane((byte) 3, 184.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.5 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 5.12, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.12);
                lane4 = new Lane((byte) 4, 184.5, SEGMENT_WIDTH_RATIO * 3.5, 0, 0.5 * (SEGMENT_WIDTH_RATIO * 3.5 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 5.12);
                lane5 = new Lane((byte) 5, 176.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.7 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 4.95, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.95);
                lane6 = new Lane((byte) 6, 176.5, SEGMENT_WIDTH_RATIO * 3.7, 0, 0.5 * (SEGMENT_WIDTH_RATIO * 3.7 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 4.95);
                lane7 = new Lane((byte) 7, 169.5, 0.5 * (SEGMENT_WIDTH_RATIO * 3.9 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 4.75, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.75);
                lane8 = new Lane((byte) 8, 169.5, SEGMENT_WIDTH_RATIO * 3.9, 0, 0.5 * (SEGMENT_WIDTH_RATIO * 3.9 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 4.75);
                lane9 = new Lane((byte) 9, 324, 0.5 * (SEGMENT_WIDTH_RATIO * 4.1 + SEGMENT_WIDTH_PIXELS), 0.5 * SEGMENT_HEIGHT_RATIO * 4.57, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.57);
                lane10 = new Lane((byte) 10, 309, SEGMENT_WIDTH_RATIO * 4.285, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.39);
                lane11 = new Lane((byte) 11, 294, SEGMENT_WIDTH_RATIO * 4.48, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.2);
                lane12 = new Lane((byte) 12, 280, SEGMENT_WIDTH_RATIO * 4.67, 0, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4);
                lane13 = new Lane((byte) 13, 0, 0, 0, 0, 0);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 0, 0, 0, 0, 0);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);
            }

            case ((byte) 15) -> {
                leftX = 4 * SEGMENT_WIDTH_PIXELS;
                leftY = 4 * SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.61);
                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline1.getPoints().add(0.0);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 4.95);
                polyline2.getPoints().add(0.0);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                          5.31, 5.12, 4.95, 4.75, 4.57, 4.39, 4.2, 4 || 3.3, 3.5, 3.7, 3.9, 4.07, 4.245, 4.42, 4.615
                lane1 = new Lane((byte) 1, 191.5, 0, SEGMENT_HEIGHT_RATIO * 5.31, 0.5 * SEGMENT_WIDTH_RATIO * 4.615, 0.5 * SEGMENT_HEIGHT_RATIO * 5.31);
                lane2 = new Lane((byte) 2, 191.5, 0.5 * SEGMENT_WIDTH_RATIO * 4.615, 0.5 * SEGMENT_HEIGHT_RATIO * 5.31, SEGMENT_WIDTH_RATIO * 4.615, 0);
                lane3 = new Lane((byte) 3, 184.5, 0, SEGMENT_HEIGHT_RATIO * 5.12, 0.5 * SEGMENT_WIDTH_RATIO * 4.42, 0.5 * SEGMENT_HEIGHT_RATIO * 5.12);
                lane4 = new Lane((byte) 4, 184.5, 0.5 * SEGMENT_WIDTH_RATIO * 4.42, 0.5 * SEGMENT_HEIGHT_RATIO * 5.12, SEGMENT_WIDTH_RATIO * 4.615, 0);
                lane5 = new Lane((byte) 5, 176.5, 0, SEGMENT_HEIGHT_RATIO * 4.245, 0.5 * SEGMENT_WIDTH_RATIO * 4.245, 0.5 * SEGMENT_HEIGHT_RATIO * 4.95);
                lane6 = new Lane((byte) 6, 176.5, 0.5 * SEGMENT_WIDTH_RATIO * 4.07, 0.5 * SEGMENT_HEIGHT_RATIO * 4.95, SEGMENT_WIDTH_RATIO * 4.615, 0);
                lane7 = new Lane((byte) 7, 169.5, 0, SEGMENT_HEIGHT_RATIO * 3.9, 0.5 * SEGMENT_WIDTH_RATIO * 4.07, 0.5 * SEGMENT_HEIGHT_RATIO * 4.75);
                lane8 = new Lane((byte) 8, 169.5, 0.5 * SEGMENT_WIDTH_RATIO * 3.7, 0.5 * SEGMENT_HEIGHT_RATIO * 4.75, SEGMENT_WIDTH_RATIO * 4.615, 0);
                lane9 = new Lane((byte) 9, 324, 0, SEGMENT_HEIGHT_RATIO * 4.57, SEGMENT_WIDTH_RATIO * 3.9, 0);
                lane10 = new Lane((byte) 10, 309, 0, SEGMENT_HEIGHT_RATIO * 4.39, SEGMENT_WIDTH_RATIO * 3.7, 0);
                lane11 = new Lane((byte) 11, 294, 0, SEGMENT_HEIGHT_RATIO * 4.2, SEGMENT_WIDTH_RATIO * 3.5, 0);
                lane12 = new Lane((byte) 12, 280, 0, SEGMENT_HEIGHT_RATIO * 4, SEGMENT_WIDTH_RATIO * 3.3, 0);
                lane13 = new Lane((byte) 13, 0, 0, 0, 0, 0);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 0, 0, 0, 0, 0);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);
            }

            case ((byte) 16) -> {
                leftX = 4 * SEGMENT_WIDTH_PIXELS;
                leftY = 0;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_WIDTH_RATIO * 4.95);
                polyline1.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.08);
                polyline2.getPoints().add(SEGMENT_WIDTH_RATIO * 2.9);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                        3.3, 3.5, 3.7, 3.9, 4.07, 4.245, 4.42, 4.615 || 0.39, 0.57, 0.75, 0.92, 1.11, 1.3, 1.5, 1.7
                lane1 = new Lane((byte) 1, 191.5, 0, 0.5 * SEGMENT_HEIGHT_RATIO * 0.39, 0.5 * SEGMENT_WIDTH_RATIO * 4.615, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.39));
                lane2 = new Lane((byte) 2, 191.5, 0.5 * SEGMENT_WIDTH_RATIO * 4.615, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.39), SEGMENT_WIDTH_RATIO * 4.615, SEGMENT_HEIGHT_PIXELS);
                lane3 = new Lane((byte) 3, 184.5, 0, 0.5 * SEGMENT_HEIGHT_RATIO * 0.57, 0.5 * SEGMENT_WIDTH_RATIO * 4.42, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.57));
                lane4 = new Lane((byte) 4, 184.5, 0.5 * SEGMENT_WIDTH_RATIO * 4.42, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.57), SEGMENT_WIDTH_RATIO * 4.42, SEGMENT_HEIGHT_PIXELS);
                lane5 = new Lane((byte) 5, 176.5, 0, 0.5 * SEGMENT_HEIGHT_RATIO * 0.75, 0.5 * SEGMENT_WIDTH_RATIO * 4.245, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.75));
                lane6 = new Lane((byte) 6, 176.5, 0.5 * SEGMENT_WIDTH_RATIO * 4.285, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.75), SEGMENT_WIDTH_RATIO * 4.285, SEGMENT_HEIGHT_PIXELS);
                lane7 = new Lane((byte) 7, 169.5, 0, 0.5 * SEGMENT_HEIGHT_RATIO * 0.92, 0.5 * SEGMENT_WIDTH_RATIO * 4.07, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.92));
                lane8 = new Lane((byte) 8, 169.5, 0.5 * SEGMENT_WIDTH_RATIO * 4.07, 0.5 * (SEGMENT_HEIGHT_PIXELS + SEGMENT_HEIGHT_RATIO * 0.92), SEGMENT_WIDTH_RATIO * 4.07, SEGMENT_HEIGHT_PIXELS);
                lane9 = new Lane((byte) 9, 324, 0, SEGMENT_HEIGHT_RATIO * 1.11, SEGMENT_WIDTH_RATIO * 3.9, SEGMENT_HEIGHT_PIXELS);
                lane10 = new Lane((byte) 10, 0, 0, 0, 0, 0);
                lane11 = new Lane((byte) 11, 309, 0, SEGMENT_HEIGHT_RATIO * 1.3, SEGMENT_WIDTH_RATIO * 3.7, SEGMENT_HEIGHT_PIXELS);
                lane12 = new Lane((byte) 12, 0, 0, 0, 0, 0);
                lane13 = new Lane((byte) 13, 294, 0, SEGMENT_HEIGHT_RATIO * 1.5, SEGMENT_WIDTH_RATIO * 3.5, SEGMENT_HEIGHT_PIXELS);
                lane14 = new Lane((byte) 14, 0, 0, 0, 0, 0);
                lane15 = new Lane((byte) 15, 280, 0, SEGMENT_HEIGHT_RATIO * 1.7, SEGMENT_WIDTH_RATIO * 3.3, SEGMENT_HEIGHT_PIXELS);
                lane16 = new Lane((byte) 16, 0, 0, 0, 0, 0);
            }

            case ((byte) 20), ((byte) 21) -> {
                if (segmentId == (byte) 20) {
                    leftX = SEGMENT_WIDTH_PIXELS;
                } else {
                    leftX = 3 * SEGMENT_WIDTH_PIXELS;
                }
                leftY = 0;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(0.0);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.08);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 2.08);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //0.39, 0.57, 0.75, 0.92, 1.11, 1.3, 1.5, 1.7
                lane1 = new Lane((byte) 1, 196, 0, SEGMENT_HEIGHT_RATIO * 1.7, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.7);
                lane2 = new Lane((byte) 2, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.7, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.7);
                lane3 = new Lane((byte) 3, 196, 0, SEGMENT_HEIGHT_RATIO * 1.5, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.5);
                lane4 = new Lane((byte) 4, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.5, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.5);
                lane5 = new Lane((byte) 5, 196, 0, SEGMENT_HEIGHT_RATIO * 1.3, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.3);
                lane6 = new Lane((byte) 6, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.3, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.3);
                lane7 = new Lane((byte) 7, 196, 0, SEGMENT_HEIGHT_RATIO * 1.11, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.11);
                lane8 = new Lane((byte) 8, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.11, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 1.11);
                lane9 = new Lane((byte) 9, 196, 0, SEGMENT_HEIGHT_RATIO * 0.92, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.92);
                lane10 = new Lane((byte) 10, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.92, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.92);
                lane11 = new Lane((byte) 11, 196, 0, SEGMENT_HEIGHT_RATIO * 0.75, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.75);
                lane12 = new Lane((byte) 12, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.75, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.75);
                lane13 = new Lane((byte) 13, 196, 0, SEGMENT_HEIGHT_RATIO * 0.57, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57);
                lane14 = new Lane((byte) 14, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.57);
                lane15 = new Lane((byte) 15, 196, 0, SEGMENT_HEIGHT_RATIO * 0.39, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.39);
                lane16 = new Lane((byte) 16, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.39, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 0.39);
            }

            case ((byte) 7) -> {
                leftX = SEGMENT_WIDTH_PIXELS;
                leftY = SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.75);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.5);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                          2.1, 2.3, 2.5, 2.7, 2.89, 3.07, 3.25, 3.42 || 3.9, 4.1, 4.3, 4.49, 4.67, 4.85, 5.04, 5.22
                lane1 = new Lane((byte) 1, 142, 0, SEGMENT_HEIGHT_RATIO * 3.42, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.22 + 3.42));
                lane2 = new Lane((byte) 2, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.22 + 3.42), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.22);
                lane3 = new Lane((byte) 3, 142, 0, SEGMENT_HEIGHT_RATIO * 3.25, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.04 + 3.25));
                lane4 = new Lane((byte) 4, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.04 + 3.25), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.04);
                lane5 = new Lane((byte) 5, 142, 0, SEGMENT_HEIGHT_RATIO * 3.07, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.85 + 3.07));
                lane6 = new Lane((byte) 6, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.85 + 3.07), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.85);
                lane7 = new Lane((byte) 7, 142, 0, SEGMENT_HEIGHT_RATIO * 2.89, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.67 + 2.89));
                lane8 = new Lane((byte) 8, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.67 + 2.89), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.67);
                lane9 = new Lane((byte) 9, 142, 0, SEGMENT_HEIGHT_RATIO * 2.7, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.49 + 2.7));
                lane10 = new Lane((byte) 10, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.49 + 2.7), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.49);
                lane11 = new Lane((byte) 11, 142, 0, SEGMENT_HEIGHT_RATIO * 2.5, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.3 + 2.5));
                lane12 = new Lane((byte) 12, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.3 + 2.5), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.3);
                lane13 = new Lane((byte) 13, 142, 0, SEGMENT_HEIGHT_RATIO * 2.3, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.1 + 2.3));
                lane14 = new Lane((byte) 14, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.1 + 2.3), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.1);
                lane15 = new Lane((byte) 15, 142, 0, SEGMENT_HEIGHT_RATIO * 2.1, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.9 + 2.1));
                lane16 = new Lane((byte) 16, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.9 + 2.1), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.9);
            }
            case ((byte) 8) -> {
                leftX = 3 * SEGMENT_WIDTH_PIXELS;
                leftY = SEGMENT_HEIGHT_PIXELS;

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.5);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 1.75);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.8);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //                                                          2.1, 2.3, 2.5, 2.7, 2.89, 3.07, 3.25, 3.42 || 3.9, 4.1, 4.3, 4.49, 4.67, 4.85, 5.04, 5.22
                lane1 = new Lane((byte) 1, 142, 0, SEGMENT_HEIGHT_RATIO * 5.22, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.22 + 3.42));
                lane2 = new Lane((byte) 2, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.22 + 3.42), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.22);
                lane3 = new Lane((byte) 3, 142, 0, SEGMENT_HEIGHT_RATIO * 5.04, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.04 + 3.25));
                lane4 = new Lane((byte) 4, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (5.04 + 3.25), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.04);
                lane5 = new Lane((byte) 5, 142, 0, SEGMENT_HEIGHT_RATIO * 4.85, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.85 + 3.07));
                lane6 = new Lane((byte) 6, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.85 + 3.07), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.85);
                lane7 = new Lane((byte) 7, 142, 0, SEGMENT_HEIGHT_RATIO * 4.67, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.67 + 2.89));
                lane8 = new Lane((byte) 8, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.67 + 2.89), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.67);
                lane9 = new Lane((byte) 9, 142, 0, SEGMENT_HEIGHT_RATIO * 4.49, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.49 + 2.7));
                lane10 = new Lane((byte) 10, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.49 + 2.7), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.49);
                lane11 = new Lane((byte) 11, 142, 0, SEGMENT_HEIGHT_RATIO * 4.3, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.3 + 2.5));
                lane12 = new Lane((byte) 12, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.3 + 2.5), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.3);
                lane13 = new Lane((byte) 13, 142, 0, SEGMENT_HEIGHT_RATIO * 4.1, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.1 + 2.3));
                lane14 = new Lane((byte) 14, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (4.1 + 2.3), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.1);
                lane15 = new Lane((byte) 15, 142, 0, SEGMENT_HEIGHT_RATIO * 3.9, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.9 + 2.1));
                lane16 = new Lane((byte) 16, 142, 0.5 * SEGMENT_WIDTH_PIXELS, 0.5 * SEGMENT_HEIGHT_RATIO * (3.9 + 2.1), SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 3.9);
            }

            case ((byte) 24), ((byte) 25) -> {
                leftY = 4 * SEGMENT_HEIGHT_PIXELS;
                if (segmentId == (byte) 24) {
                    leftX = SEGMENT_WIDTH_PIXELS;
                } else {
                    leftX = 3 * SEGMENT_WIDTH_PIXELS;
                }

                polyline1.getPoints().add(0.0);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.61);
                polyline1.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline1.getPoints().add(SEGMENT_HEIGHT_RATIO * 3.61);

                polyline2.getPoints().add(0.0);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);
                polyline2.getPoints().add((double) SEGMENT_WIDTH_PIXELS);
                polyline2.getPoints().add((double) SEGMENT_HEIGHT_PIXELS);

                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.getPoints().add(0.0);
                polyline3.setVisible(false);

                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.getPoints().add(0.0);
                polyline4.setVisible(false);

                //5.31, 5.12, 4.95, 4.75, 4.57, 4.39, 4.2, 4
                lane1 = new Lane((byte) 1, 196, 0, SEGMENT_HEIGHT_RATIO * 5.31, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.31);
                lane2 = new Lane((byte) 2, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.31, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.31);
                lane3 = new Lane((byte) 3, 196, 0, SEGMENT_HEIGHT_RATIO * 5.12, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.12);
                lane4 = new Lane((byte) 4, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.12, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 5.12);
                lane5 = new Lane((byte) 5, 196, 0, SEGMENT_HEIGHT_RATIO * 4.95, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.95);
                lane6 = new Lane((byte) 6, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.95, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.95);
                lane7 = new Lane((byte) 7, 196, 0, SEGMENT_HEIGHT_RATIO * 4.75, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.75);
                lane8 = new Lane((byte) 8, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 475, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.75);
                lane9 = new Lane((byte) 9, 196, 0, SEGMENT_HEIGHT_RATIO * 4.57, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.57);
                lane10 = new Lane((byte) 10, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.57, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.57);
                lane11 = new Lane((byte) 11, 196, 0, SEGMENT_HEIGHT_RATIO * 4.39, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.39);
                lane12 = new Lane((byte) 12, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.39, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.39);
                lane13 = new Lane((byte) 13, 196, 0, SEGMENT_HEIGHT_RATIO * 4.2, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.2);
                lane14 = new Lane((byte) 14, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.2, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4.2);
                lane15 = new Lane((byte) 15, 196, 0, SEGMENT_HEIGHT_RATIO * 4, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4);
                lane16 = new Lane((byte) 16, 196, 0.5 * SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4, SEGMENT_WIDTH_PIXELS, SEGMENT_HEIGHT_RATIO * 4);
            }
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
    }

    public Pane pane() {
        return stackPane;
    }
}
