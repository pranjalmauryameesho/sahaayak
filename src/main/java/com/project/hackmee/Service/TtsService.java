package com.project.hackmee.Service;

import com.project.hackmee.Data.ApiRequest;
import com.project.hackmee.Data.Request;
import com.project.hackmee.Data.Response;
import com.project.hackmee.GoogleClient.GoogleTtsService;
import jdk.nashorn.internal.runtime.Context;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;


@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class TtsService {

    private final GoogleTtsService googleTtsService;

    public Response tts(ApiRequest apiRequest) throws IOException {

        Request.InputTTS inputTTS = Request.InputTTS.builder().text(apiRequest.getText()).build();

        Request.VoiceTTS voiceTTS = new Request.VoiceTTS();
        Request.AudioConfigTTS audioConfigTTS = new Request.AudioConfigTTS();

        String language= apiRequest.getLanguage();
        language= language.toUpperCase(Locale.ROOT);
        switch (language) {
            case "EN":
                voiceTTS =
                        Request.VoiceTTS.builder()
                                .languageCode("en-IN")
                                .name("en-IN-Standard-A")
                                .build();
                audioConfigTTS =
                        Request.AudioConfigTTS.builder()
                                .audioEncoding("MP3")
                                .pitch(0)
                                .speakingRate(
                                        0.75)
//                                .effectsProfileId()
                                .build();
                break;
            case "HI":
                voiceTTS =
                        Request.VoiceTTS.builder()
                                .languageCode("hi-IN")
                                .name("hi-IN-Standard-A")
                                .build();
                audioConfigTTS =
                        Request.AudioConfigTTS.builder()
                                .audioEncoding("MP3")
                                .pitch(0)
                                .speakingRate(0.75)
                                .build();
                break;
        }

        Request request= Request.builder()
                .input(inputTTS)
                .voice(voiceTTS)
                .audioConfig(audioConfigTTS)
                .build();

        Response response = googleTtsService.textToSpeechGoogle(request);
        return response;
    }

}
