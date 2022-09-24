package com.lukeonuke;

import com.lukeonuke.file.ZipFile;
import com.lukeonuke.process.FailureState;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

public class Backup {
    private final Config config = Config.getInstance();
    private final Logger logger;
    private final ProgressCallback progressCallback;

    public Backup(Logger logger, ProgressCallback progressCallback) {
        this.logger = logger;
        this.progressCallback = progressCallback;
    }

    public void doBackup(){
        logger.info("==> STARTING ARCHIVE <==");
        progressCallback.callIncrement(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss dd-MM-yyyy");

        ZipFile zipFile = new ZipFile(new File(config.getArchivePath() + dateFormat.format(new Date()) + ".zip"));
        zipFile.addFileToZip(new File(config.getMapPath()));
        logger.info("Added map file");
        progressCallback.callIncrement(50);

        ArrayList<File> additional = config.getAdditional();

        if(Objects.nonNull(additional)){
            additional.forEach(file -> {
                if(!file.exists()) FailureState.panic(FailureState.Failure.FILE_ADDITIONAL_DOES_NOT_EXIST);
                zipFile.addFileToZip(file);
                logger.info("Added additional file " + file.getAbsolutePath());
                progressCallback.callIncrement(50 / additional.size());
            });
        }
        zipFile.close();
        logger.info("File : " + zipFile.getZipFile());
        logger.info("==> ARCHIVE COMPLETED <==");
        progressCallback.call(100);
    }
}
