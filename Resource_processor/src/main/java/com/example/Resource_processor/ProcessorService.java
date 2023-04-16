package com.example.Resource_processor;

import com.example.Resource_processor.models.SongMetaData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProcessorService {

    public Mono<SongMetaData> postMetaData(SongMetaData metaData) {
        WebClient client = WebClient.create("http://localhost:8082");

        return client.post().uri("songs")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(metaData), SongMetaData.class)
                .retrieve()
                .bodyToMono(SongMetaData.class)
                .retry(3);
    }

    public Mono<SongMetaData> getMetaDataAsync(String id) {
        WebClient client = WebClient.create("http://localhost:8080");
        return client.get().uri("metaData/" + id)
                .retrieve()
                .bodyToMono(SongMetaData.class)
                .retry(3);
    }
}
