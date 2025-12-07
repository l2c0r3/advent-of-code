package ch.c0r3.aoc.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileUtil {


    public static File loadFile(String path) {
        URL resource = FileUtil.class.getClassLoader().getResource(path);
        if (resource == null) {
            return null;
        } else {
            try {
                var uri = resource.toURI();
                return new File(uri);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
