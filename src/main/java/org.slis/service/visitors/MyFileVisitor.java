package org.slis.service.visitors;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private final Path destination;

    public MyFileVisitor(Path destination) {
        this.destination = destination;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (basicFileAttributes.isRegularFile()) {
            System.out.println(String.format("%s \t size = %s bytes", path, basicFileAttributes.size()));
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException
    {
        System.err.println(String.format("FAIL: file(%s). Exception: %s", file, exc));
        return FileVisitResult.CONTINUE;
    }


}
