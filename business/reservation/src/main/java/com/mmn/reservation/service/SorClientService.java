package com.mmn.reservation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mmn.reservation.client.SorClient;
import com.mmn.reservation.client.SorClientV2;
import com.mmn.reservation.config.SorProperties;
import com.mmn.reservation.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class SorClientService {
    private final SorClient client;
    private final SorClientV2 clientV2;
    private final SorProperties properties;
    //
    private final boolean useFeign = false;
    private final Gson gson = new Gson();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String login(final FullLoginDto fullLoginDto) throws IOException {
        if (useFeign) {
            return this.client.login(fullLoginDto).getBody();
        }
        final String URL = "/clubmembership/getlogintokennovalidation";
        final Map<String, String> HEADERS = new HashMap<>();
        HEADERS.put(HttpHeaders.CONTENT_TYPE, "application/json");
        final HttpEntity entity = this.genericPost(URL, fullLoginDto, HEADERS);
        return objectMapper.readValue(entity.getContent(), String.class);
    }

    public List<ListMembersResponseDto> listAll(final ListMembersDto listMembersDto) throws IOException {
        final String URL = "/clubmembership/getmembers";
        final Map<String, String> HEADERS = new HashMap<>();
        HEADERS.put(HttpHeaders.CONTENT_TYPE, "application/json");
        final HttpEntity entity = this.genericPost(URL, listMembersDto, HEADERS);
        return objectMapper.readValue(entity.getContent(), objectMapper.getTypeFactory().constructCollectionType(List.class, ListMembersResponseDto.class));
    }

    public AccountResponseDto create(
            final String username,
            final String password,
            final AccountDto accountDto) throws IOException {
        if (useFeign) {
            return clientV2.create(username, password, accountDto).getBody();
        }
        final String URL = "/v2/clubmembership/createdefault";
        final Map<String, String> HEADERS = new HashMap<>();
        HEADERS.put(HttpHeaders.CONTENT_TYPE, "application/json");
        HEADERS.put("x-saveon-username", username);
        HEADERS.put("x-saveon-secret", password);
        final HttpEntity entity = this.genericPost(URL, accountDto, HEADERS);
        return objectMapper.readValue(entity.getContent(), AccountResponseDto.class);
    }

    private HttpEntity genericPost(final String url, final Object o, Map<String, String> headers) throws IOException {
        final String URL = properties.getSOR_URL().concat(url);
        final String json = gson.toJson(o);
        final HttpPost request = new HttpPost(URL);
        request.setEntity(new ByteArrayEntity(json.getBytes("UTF-8")));
        headers.forEach((k, v) -> request.setHeader(k, v));
        final HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        return httpResponse.getEntity();
    }
}
