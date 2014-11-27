package com.sourceit.courses.devs.classes.class08.example01;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class FileTest {
    public static FilenameFilter filter(final String endString) {
        // Creation of anonymous inner class:
        return new FilenameFilter() {
            private String suffix = endString;
            public boolean accept(File dir, String name) {
                return name.endsWith(suffix);
            }
        };
    }
    public static void main(String[] args) throws IOException {
        File path = new File(".");
        String[] list = path.list(filter(".xml"));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        System.out.println(System.getProperty("user.dir"));
        System.out.println(path.getCanonicalPath());
        System.out.println(new File("/").getCanonicalPath());

        for(String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
