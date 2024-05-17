package org.example;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    private final String path;
    private final Map<String, String> queryParams;

    public Request(String request) {
        String[] parts = request.split(" ");
        this.path = parts[1];
        this.queryParams = parseQueryParams(path);
    }

    public String getPath() {
        return path;
    }

    public String getQueryParam(String name) {
        return queryParams.get(name);
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    private Map<String, String> parseQueryParams(String path) {
        Map<String, String> paramsMap = new HashMap<>();
        List<NameValuePair> params = URLEncodedUtils.parse(path, StandardCharsets.UTF_8);
        for (NameValuePair param : params) {
            paramsMap.put(param.getName(), param.getValue());
        }
        return paramsMap;
    }
}
