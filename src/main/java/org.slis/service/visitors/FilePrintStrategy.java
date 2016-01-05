package org.slis.service.visitors;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FilePrintStrategy extends SimpleFileVisitor<Path> {

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
