package util;

import java.io.File;
import java.util.ArrayList;

public class DirReader {

    public static ArrayList<String> listFilesForFolder(final File folder) {
        ArrayList<String> filesNames = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                filesNames.add(fileEntry.getName());
            }
        }
        return filesNames;
    }




}
