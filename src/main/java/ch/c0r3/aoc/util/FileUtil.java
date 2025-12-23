package ch.c0r3.aoc.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class FileUtil {

    private FileUtil() {}

    public static File loadFile(String path) {
        var ressource = FileUtil.class.getClassLoader().getResource(path);
        Objects.requireNonNull(ressource, "resource not found: " + path);
        return new File(ressource.getFile());
    }
}
