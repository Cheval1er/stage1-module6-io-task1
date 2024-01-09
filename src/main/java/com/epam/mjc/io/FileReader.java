package com.epam.mjc.io;

import java.io.File;
import java.io.BufferedReader;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader( new java.io.FileReader(file) )){
            if (file.exists()) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String key = line.split(": ")[0];
                    String value = line.split(": ")[1];

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
                           new Profile();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }
}