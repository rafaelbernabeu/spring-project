package br.rafaelbernabeu.springProject.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class URLUtil {

    private static <T> T parseData(String jsonData, Class<T> responseType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonData, responseType);
    }

    private static String fetchData(String url) {

        return null;
    }

}
