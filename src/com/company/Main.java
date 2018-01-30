package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/masulenickabardina/Documents/Coordinates.txt";

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

        //ladja
        for (int x = 0; x < 8; x++) {
            if (!(x == fx & ly == fy) & !(x == kx & ly == ky) & !(x == lx)) {
                pole[x][ly] = 1;
            }
        }

        for (int y = 0; y < 8; y++) {
            if (!(y == fy) & !(fx == kx & y == ky) & !(fx == lx & y == ly)) {
                pole[lx][y] = 1;
            }
        }

        //ferz'

        for (int x = 0; x < 8; x++) {
            int y = x - (fx - fy);
            if (y < 8 & y >= 0 & !(x == fx & y == fy) & !(x == kx & y == ky) & !(x == lx & y == ly)) {
                pole[x][y] = 1;

            }
        }

        for (int x = 0; x < 8; x++) {
            int y = fy + fx - x;
            if (y < 8 & y >= 0 & !(x == fx & y == fy) & !(x == kx & y == ky) & !(x == lx & y == ly)) {
                pole[x][y] = 1;

            }
        }

        for (int x = 0; x < 8; x++) {
            if (!(x == fx) & !(x == kx & fy == ky) & !(x == lx & fy == ly)) {
                pole[x][fy] = 1;
            }
        }

        for (int y = 0; y < 8; y++) {
            if (!(y == fy) & !(fx == kx & y == ky) & !(fx == lx & y == ly)) {
                pole[fx][y] = 1;

            }

        }

        //pole[fx][fy] = 2;


        //kon'

        //pole[kx][ky] = 2;
        int kbx = kx + 2;
        int kby = ky + 1;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }
        kbx = kx - 2;
        kby = ky + 1;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }
        kbx = kx + 2;
        kby = ky - 1;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }
        kbx = kx - 2;
        kby = ky - 1;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }
        kbx = kx + 1;
        kby = ky - 2;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }
        kbx = kx - 1;
        kby = ky - 2;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }
        kbx = kx - 1;
        kby = ky + 2;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }
        kbx = kx + 1;
        kby = ky + 2;
        if (kbx >= 0 & kbx < 8 & kby >= 0 & kby < 8 & !(kbx == fx & kby == fy) & !(kbx == lx & kby == ly)) {
            pole[kbx][kby] = 1;
        }


        int sum = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sum = sum + pole[i][j];
            }
        }
        System.out.println(sum);

        File file=new File("/Users/masulenickabardina/Documents/Coordinate2.txt");
        if(file.exists()){
            file.delete();
        }
        FileWriter writer = new FileWriter(file, true);
        PrintWriter output = new PrintWriter(writer);
        output.write(String.valueOf(sum));
        output.close();


      for (int i = 0; i < 8; i++) {
        System.out.print(8 - i + "\t");
        for (int j = 0; j < 8; j++) {
            System.out.print(pole[j][7 - i] + "\t");
        }
        System.out.print("\n");
    }
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH");
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
