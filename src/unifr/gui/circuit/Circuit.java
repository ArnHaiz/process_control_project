package unifr.gui.circuit;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Circuit {
    Segment[] segments;
    StackPane stackPane;
    Segment segment_01;
    Segment segment_02;
    Segment segment_03;
    Segment segment_04;
    Segment segment_05;
    Segment segment_06;
    Segment segment_07;
    Segment segment_08;
    Segment segment_09;
    Segment segment_10;
    Segment segment_11;
    Segment segment_12;
    Segment segment_13;
    Segment segment_14;
    Segment segment_15;
    Segment segment_16;
    Segment segment_17;
    Segment segment_18;
    Segment segment_19;
    Segment segment_20;
    Segment segment_21;
    Segment segment_22;
    Segment segment_23;
    Segment segment_24;
    Segment segment_25;

    public Circuit() {
        segment_01 = new Segment((byte) 1);
        segment_02 = new Segment((byte) 2);
        segment_03 = new Segment((byte) 3);
        segment_04 = new Segment((byte) 4);
        segment_05 = new Segment((byte) 5);
        segment_06 = new Segment((byte) 6);
        segment_07 = new Segment((byte) 7);
        segment_08 = new Segment((byte) 8);
        segment_09 = new Segment((byte) 9);
        segment_10 = new Segment((byte) 10);
        segment_11 = new Segment((byte) 11);
        segment_12 = new Segment((byte) 12);
        segment_13 = new Segment((byte) 13);
        segment_14 = new Segment((byte) 14);
        segment_15 = new Segment((byte) 15);
        segment_16 = new Segment((byte) 16);
        segment_17 = new Segment((byte) 17);
        segment_18 = new Segment((byte) 18);
        segment_19 = new Segment((byte) 19);
        segment_20 = new Segment((byte) 20);
        segment_21 = new Segment((byte) 21);
        segment_22 = new Segment((byte) 22);
        segment_23 = new Segment((byte) 23);
        segment_24 = new Segment((byte) 24);
        segment_25 = new Segment((byte) 25);

        segments = new Segment[25];
        segments[0] = segment_01;
        segments[1] = segment_02;
        segments[2] = segment_03;
        segments[3] = segment_04;
        segments[4] = segment_05;
        segments[5] = segment_06;
        segments[6] = segment_07;
        segments[7] = segment_08;
        segments[8] = segment_09;
        segments[9] = segment_10;
        segments[10] = segment_11;
        segments[11] = segment_12;
        segments[12] = segment_13;
        segments[13] = segment_14;
        segments[14] = segment_15;
        segments[15] = segment_16;
        segments[16] = segment_17;
        segments[17] = segment_18;
        segments[18] = segment_19;
        segments[19] = segment_20;
        segments[20] = segment_21;
        segments[21] = segment_22;
        segments[22] = segment_23;
        segments[23] = segment_24;
        segments[24] = segment_25;


        stackPane = new StackPane();
        stackPane.setMinSize(1020, 720);
        stackPane.setMaxSize(1020, 720);
        for (Segment segment : segments) stackPane.getChildren().add(segment.pane());
    }

    public Pane pane() {return stackPane;}
}
