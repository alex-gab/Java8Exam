package com.alex.ch9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public final class BasicFileAttributesSample {
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("animalAlt.data");
        final BasicFileAttributes metaData = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.printf("Is file a directory: %b.%n", metaData.isDirectory());
        System.out.printf("Is file a regular file: %b.%n", metaData.isRegularFile());
        System.out.printf("Is file a symbolic link: %b.%n", metaData.isSymbolicLink());
        System.out.printf("Path not a file, directory, nor a symbolic link: %b.%n", metaData.isOther());

        System.out.printf("Size in bytes: %d. %n", metaData.size());
        System.out.printf("Creation time: %s. %n", metaData.creationTime());
        System.out.printf("Last modified time: %s. %n", metaData.lastModifiedTime());
        System.out.printf("Last access time: %s. %n", metaData.lastAccessTime());
        System.out.printf("Unique file identifier: %s. %n", metaData.fileKey());

    }
}