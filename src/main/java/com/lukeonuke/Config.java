package com.lukeonuke;

import com.lukeonuke.process.FailureState;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import static com.lukeonuke.process.FailureState.panic;

public class Config {
    private String mapPath;
    private String archivePath;
    private ArrayList<File> additional = new ArrayList<>();

    private static Config instance = null;
    public static Config getInstance(){
        if(instance==null) instance = new Config();
        return instance;
    }

    private Config() {
        File config = new File("smb.properties");
        Properties prop = new Properties();
        if (!config.exists()) {
            try (OutputStream output = new FileOutputStream(config)) {
                prop.setProperty("file.map", "<full-path-to-map>");
                prop.setProperty("file.archive", "<full-path-to-archive>");
                prop.setProperty("file.additional", "<coma-separated-full-paths>");
                prop.store(output, "SourceMapBackup properties");
            } catch (IOException e) {
                panic(e, FailureState.Failure.FILE_CONFIG);
            }
        }
        try (InputStream input = new FileInputStream(config)) {
            prop.load(input);
            this.mapPath = prop.getProperty("file.map");
            this.archivePath = prop.getProperty("file.archive");

            if(!prop.getProperty("file.additional").trim().equals("")){
                String[] additionalPaths = prop.getProperty("file.additional").split(",");
                for (int i = 0; i < additionalPaths.length; i++) {
                    additional.add(new File(additionalPaths[i].trim()));
                }
            }
        } catch (IOException e) {
            panic(e, FailureState.Failure.FILE_CONFIG);
        }
    }

    public String getMapPath() {
        return mapPath;
    }

    public String getArchivePath() {
        return archivePath;
    }

    public ArrayList<File> getAdditional() {
        return additional;
    }
}
