package com.restassured.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restassured.helpers.ServiceHelper;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class APIHeaders {

    public Map<String, Object> GetHeaders() throws JsonProcessingException {

        ServiceHelper serviceHelperObj = new ServiceHelper();
        //ServiceHelper serviceObj = new ServiceHelper();
        ObjectMapper objMap = new ObjectMapper();
        Yaml yaml = new Yaml();


        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("PostHeaders.yml");

        Map<String, Object> headersFromYml = yaml.load(inputStream);
        //System.out.println(headersFromYml);


        return headersFromYml;
    }

}
