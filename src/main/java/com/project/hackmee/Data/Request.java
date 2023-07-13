package com.project.hackmee.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @JsonProperty("input")
    private InputTTS input;

    @JsonProperty("voice")
    private VoiceTTS voice;

    @JsonProperty("audioConfig")
    private AudioConfigTTS audioConfig;


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class InputTTS {

        @JsonProperty("text")
        private String text;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VoiceTTS {

        @JsonProperty("languageCode")
        private String languageCode;

        @JsonProperty("name")
        private String name;

        @JsonProperty("ssmlGender")
        private String ssmlGender;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AudioConfigTTS {

        @JsonProperty("audioEncoding")
        private String audioEncoding;

        @JsonProperty("pitch")
        private double pitch;

        @JsonProperty("speakingRate")
        private double speakingRate;

        @JsonProperty("volumeGainDb")
        private Float volumeGainDb;

        @JsonProperty("sampleRateHertz")
        private Integer sampleRateHertz;

        @JsonProperty("effectsProfileId")
        private List<String> effectsProfileId;
    }


}
