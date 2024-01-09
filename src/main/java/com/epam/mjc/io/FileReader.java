package com.epam.mjc.io;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            if (file.exists()) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();

                        switch (key) {
                            case "Name":
                                profile.setName(value);
                                break;
                            case "Age":
                                profile.setAge(Integer.parseInt(value));
                                break;
                            case "Email":
                                profile.setEmail(value);
                                break;
                            case "Phone":
                                profile.setPhone(Long.parseLong(value));
                                break;
                            default:
                                System.err.println("Line does not match pattern.");
                        }
                    }
                }
            } else {
                System.err.println("File does not exist: " + file.getPath());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your requirements
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
        return profile;
    }
}
