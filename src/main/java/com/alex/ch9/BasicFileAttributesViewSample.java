package com.alex.ch9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

public final class BasicFileAttributesViewSample {
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("animalAlt.data");
        final BasicFileAttributeView metaData = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        final FileTime lastModifiedTime = metaData.readAttributes().lastModifiedTime();
        final FileTime newLastModifiedTime = FileTime.fromMillis(lastModifiedTime.toMillis() + TimeUnit.DAYS.toMillis(1));
        metaData.setTimes(newLastModifiedTime, null, null);
    }
}
