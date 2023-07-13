package com.project.hackmee.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    @JsonProperty("audioContent")
    private byte[] audioContent;

    @JsonProperty("timepoints")
    List<Time> timepoints;

    @JsonProperty("audioConfig")
    private AudioConfigTTS audioConfig;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioConfigTTS{
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