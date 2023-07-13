package com.project.hackmee.Controller;

import com.project.hackmee.Data.ApiRequest;
import com.project.hackmee.Data.Request;
import com.project.hackmee.Data.Response;
import com.project.hackmee.Service.TtsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TtsController {

    private final TtsService ttsService;

    @PostMapping(
            value = "/tts",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> tts(@RequestBody ApiRequest apiRequest)
            throws Exception {
        Response response = ttsService.tts(apiRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
