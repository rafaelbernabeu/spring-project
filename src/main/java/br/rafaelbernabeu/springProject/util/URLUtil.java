package br.rafaelbernabeu.springProject.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class URLUtil {

    private static ObjectMapper objectMapper;

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            synchronized (URLUtil.class) {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }

    private static <T> List<T> parseListofData(String jsonData, Class<T> responseType) throws IOException {
        ObjectMapper mapper = getObjectMapper();
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, responseType);
        return mapper.readValue(jsonData, collectionType);
    }

    private static <T> T parseData(String jsonData, Class<T> responseType) throws IOException {
        ObjectMapper mapper = getObjectMapper();
        return mapper.readValue(jsonData, responseType);
    }

    private static String fetchData(String url) throws IOException {
        Document document = Jsoup.connect(url)
                .maxBodySize(0)
                .ignoreContentType(true)
                .get();
        return document.body().html();
    }

    public static <T> T fetchAndParse(String url, Class<T> responseType) throws IOException {
        return parseData(fetchData(url), responseType);
    }

    public static <T> List<T> fetchAndParseList(String url, Class<T> responseType) throws IOException {
        return parseListofData(fetchData(url), responseType);
    }

}
