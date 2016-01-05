package org.slis.service;

import org.slis.service.visitors.MyFileVisitor;
import org.slis.service.visitors.Traverser;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path source = Paths.get(args[0]);
        Path destination = Paths.get(args[1]);
        MyFileVisitor visitor = new MyFileVisitor(destination);
        Traverser.traversFileTree(source, visitor);
    }

}
