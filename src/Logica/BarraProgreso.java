/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

/**
 *
 * @author Yanir
 */
public class BarraProgreso extends ProgressBar {

    AtomicInteger myDoneCount = new AtomicInteger();
    int           myTotalCount;
    Timeline      myWhatcher = new Timeline(new KeyFrame(Duration.millis(10), e -> update()));

    public void update() {
        setProgress(1.0*myDoneCount.get()/myTotalCount);
        if (myDoneCount.get() >= myTotalCount) {
            myWhatcher.stop();
            myTotalCount = 0;
        }
    }

    public boolean isRunning() { return myTotalCount > 0; }

    public void start(int totalCount) {
        myDoneCount.set(0);
        myTotalCount = totalCount;
        setProgress(0.0);
        myWhatcher.setCycleCount(Timeline.INDEFINITE);
        myWhatcher.play();
    }

    public void add(int n) {
        myDoneCount.addAndGet(n);
    }
    
}
