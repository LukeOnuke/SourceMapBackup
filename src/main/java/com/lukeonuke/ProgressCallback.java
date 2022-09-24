package com.lukeonuke;

import javax.swing.*;

public class ProgressCallback {
    private JProgressBar pb;

    public ProgressCallback(JProgressBar pb) {
        this.pb = pb;
    }

    public void call(int progress){
        pb.setValue(progress);
    }

    public void callIncrement(int delta){
        call(pb.getValue() + delta);
    }
}
