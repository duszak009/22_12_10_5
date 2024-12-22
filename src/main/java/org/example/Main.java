package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter Bank number");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        URL file = new URI("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt").toURL();
        String bankName = "";
        try(
        BufferedReader in = new BufferedReader(new InputStreamReader(file.openStream()));){
            String line;
            while((line =in.readLine()) != null) {
                if (line.startsWith(input)) {
                    String[] parts = line.split("\\t");
                    bankName = parts[1];
                    break;
                }
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Entered bank's number: " + input);
        System.out.println("Founded bank's name: " + bankName);


    }
}