package com.alex.appendixc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class FindAndCopyFileTest {
    public static void main(String[] args) throws IOException {
        final FindAndCopyFile findAndCopyFile = new FindAndCopyFile();
        Files.walkFileTree(Paths.get("/home/alex/Desktop/tree"), findAndCopyFile);

        Files.walk(Paths.get("/home/alex/Desktop/tree")).
                forEach(System.out::println);
    }
}
