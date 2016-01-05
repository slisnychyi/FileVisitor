package org.slis.service.visitors;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

public class Traverser {
    public static void traversFileTree(Path source, FileVisitor<Path> visitor) {
        try {
            Files.walkFileTree(source, visitor);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
