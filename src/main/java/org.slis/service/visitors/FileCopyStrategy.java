package org.slis.service.visitors;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileCopyStrategy extends SimpleFileVisitor<Path> {

    private final Path fromPath;
    private final Path toPath;
    private StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;

    public FileCopyStrategy(Path fromPath, Path toPath) {
        this.fromPath = fromPath;
        this.toPath = toPath;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path targetPath = toPath.resolve(fromPath.relativize(dir));
        if(!Files.exists(targetPath)){
            Files.createDirectory(targetPath);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path sourceDir,
                                     BasicFileAttributes attrs) throws IOException {
        System.out.println(sourceDir);
        Files.copy(sourceDir, toPath.resolve(fromPath.relativize(sourceDir)), copyOption);
        return FileVisitResult.CONTINUE;
    }
}
