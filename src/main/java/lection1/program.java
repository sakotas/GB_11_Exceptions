package lection1;

import java.io.File;

public class program {

    public static void main(String[] args) {
        System.out.println(getFileSize(new File("123")));
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            return -1;
        }
        return file.length();
    }

}
