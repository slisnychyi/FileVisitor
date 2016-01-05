package org.slis.service;

import org.slis.service.visitors.FileCopyStrategy;
import org.slis.service.visitors.FileVisitorUtils;

import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private final static FileVisitorUtils utils = new FileVisitorUtils();

    public static void main(String[] args) {
        Path fromDir = Paths.get(args[0]);
        Path toDir = Paths.get(args[1]);
        //FileVisitor<Path> visitor = new FilePrintStrategy();
        FileVisitor<Path> visitor = new FileCopyStrategy(fromDir, toDir);
        utils.traversFileTree(fromDir, visitor);

    }


}

