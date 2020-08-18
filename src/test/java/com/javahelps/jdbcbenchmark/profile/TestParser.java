package com.javahelps.jdbcbenchmark.profile;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestParser {
    private final File PROFILE_FILE = new File(TestParser.class.getClassLoader().getResource("profile.yaml").getFile());

    @Test
    public void testParser()
            throws IOException {
        Profile profile = ProfileParser.parse(PROFILE_FILE);
        System.out.println(profile);
    }
}