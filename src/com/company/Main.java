package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "~/Coordinates.txt";

        String line = readUsingBufferedReader(fileName, StandardCharsets.UTF_8);

        int fx = line.charAt(0) - 'A';
        int fy = line.charAt(1) - '0' - 1;

        int lx = line.charAt(3) - 'A';
        int ly = line.charAt(4) - '0' - 1;

        int kx = line.charAt(6) - 'A';
        int ky = line.charAt(7) - '0' - 1;

        //pole
        int[][] pole = new int[8][];

        for (int i = 0; i < 8; i++) {
            pole[i] = new int[8];
        }
    }

    private static String readUsingBufferedReader(String fileName, Charset cs) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, cs);
        BufferedReader br = new BufferedReader(isr);
        String coordinats;
        coordinats = br.readLine();
        br.close();

        return coordinats;

    }
}
