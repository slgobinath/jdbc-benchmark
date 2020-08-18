package com.javahelps.jdbcbenchmark;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.javahelps.jdbcbenchmark.profile.Profile;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        Profile profile = mapper.readValue(new File("src/main/resources/profile.yaml"), Profile.class);
        System.out.println(profile);
    }
}
