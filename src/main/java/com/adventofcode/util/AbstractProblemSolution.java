package com.adventofcode.util;

import com.adventofcode.year2015.day6.Lights;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public abstract class AbstractProblemSolution {

    public static String readFile(String pathname) {

        String text = "";

        try (
                FileInputStream fis = new FileInputStream(new File(pathname))
        ) {
            File file = new File(pathname);
            byte[] data = new byte[(int) file.length()];
            System.out.println(fis.read(data));
            fis.close();
            text = new String(data, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }


}
