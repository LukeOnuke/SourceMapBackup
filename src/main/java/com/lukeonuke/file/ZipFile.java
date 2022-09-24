package com.lukeonuke.file;

import com.lukeonuke.process.FailureState;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import static com.lukeonuke.process.FailureState.panic;

public class ZipFile extends GenericFile{
    File zipFile = getPath().getAbsoluteFile();
    private final int BUFFER_SIZE = 1024;

    private FileOutputStream fos = null;
    private ZipOutputStream zos = null;

    public ZipFile(File path) {
        super(path);
        try {
            fos = new FileOutputStream(zipFile);
        } catch (FileNotFoundException e) {
            panic(e, FailureState.Failure.FILE_ZIP);
            e.printStackTrace();
        }
        zos = new ZipOutputStream(fos);
    }

    public void addFileToZip(File file){

        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);

            ZipEntry entry = new ZipEntry(file.getName());
            zos.putNextEntry(entry);

            byte[] buffer = new byte[BUFFER_SIZE];
            int count;

            while( (count = bis.read(buffer, 0, BUFFER_SIZE)) != -1){
                zos.write(buffer, 0, count);
            }

            bis.close();
            fis.close();
        } catch (IOException e) {
            panic(e, FailureState.Failure.FILE_ZIP);
        }

    }

    public void close(){
        try {
            zos.close();
            fos.close();
        } catch (IOException e) {
            panic(e, FailureState.Failure.FILE_ZIP);
        }

    }

    public File getZipFile() {
        return zipFile;
    }
}
