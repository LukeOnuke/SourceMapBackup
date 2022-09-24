package com.lukeonuke;

import com.lukeonuke.gui.MainWindow;

public class SourceMapBackup
{
    public static void main( String[] args )
    {
        System.out.println( "Loading" );
        Config.getInstance();
        new MainWindow();
    }
}
