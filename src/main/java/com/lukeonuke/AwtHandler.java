package com.lukeonuke;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class AwtHandler extends Handler {
    private JTextArea console;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS @ dd-MM-yyyy");
    public AwtHandler(JTextArea textArea) {
        console = textArea;
    }

    @Override
    public void publish(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(dateFormat.format(new Date(record.getMillis())));
        sb.append(" [");
        sb.append(record.getLevel());
        sb.append("] ");
        sb.append(record.getMessage());
        sb.append("\n");
        console.append(sb.toString());
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

    }
}
