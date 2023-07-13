package com.project.hackmee.GoogleClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hackmee.Data.Request;
import com.project.hackmee.Data.Response;
import jdk.internal.util.xml.impl.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
//@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GoogleTtsService {

    private RestTemplate restTemplate;


    public GoogleTtsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Response textToSpeechGoogle(Request textToSpeechRequest)
            throws IOException {

        HttpEntity<Request> httpEntity =
                new HttpEntity<>(
                        textToSpeechRequest, getHeaders());
        String apiPath ="https://texttospeech.googleapis.com/v1beta1/text:synthesize";
//        log.info(
//                LoggingConstant.LOG_API_REQUEST,
//                FETCH_SUBORDER_DETAIL_INFO,
//                httpEntity,
//                "API Path {}",
//                apiPath);
//        MetricUtils.pushSingleMetric("DownStream-Request", "tag=poa-subOrder-details-count");
        ResponseEntity<Response> response =
                restTemplate.exchange(
                        apiPath, HttpMethod.POST, httpEntity, Response.class);
//        log.info(LoggingConstant.LOG_API_RESPONSE, FETCH_SUBORDER_DETAIL_INFO, response.getBody());


//        String requestString = objectMapper.writeValueAsString(textToSpeechRequest);
//        Map<String, String> headersMap = getHeaders();
//        String uri ="https://texttospeech.googleapis.com/v1beta1/text:synthesize";
//        Pair<Integer, String> response =
//                pooledHttpRequestManager.executeHttpPostRequest(
//                        uri, headersMap, requestString, MediaType.APPLICATION_JSON_VALUE);
//        return objectMapper.readValue(response.getSecond(), TextToSpeechGoogleResponse.class);
        return response.getBody();
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.set(
                "X-Goog-Api-Key",
                "AIzaSyDl1IYD02MjrpLpuAjUAETW6vWjlvbfDOU");
        return headers;
    }

}

