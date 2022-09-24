package com.lukeonuke.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GenericFile {
    private final File path;
    public GenericFile(File path){
        this.path = path;
    }

    public void copy(Path file) throws IOException {
        Files.copy(path.toPath(), file);
    }

    public File getPath() {
        return path;
    }
}
