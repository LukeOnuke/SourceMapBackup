package com.lukeonuke.process;

import javax.swing.*;

public class FailureState {
    public static void panic(Failure failure) {
        alert(failure);
        System.exit(-1);
    }

    public static void alert(Failure failure) {
        JOptionPane.showMessageDialog(null, "Error code : " + failure, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void panic(Exception e, Failure failure) {
        e.printStackTrace();
        panic(failure);
    }

    public enum Failure {
        FILE_ZIP,
        SECURITY,
        FILE_CONFIG,
        FILE_ADDITIONAL_DOES_NOT_EXIST,
        GENERIC
    }
}
