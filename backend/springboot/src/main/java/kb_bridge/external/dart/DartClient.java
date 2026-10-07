package kb_bridge.external.dart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import kb_bridge.external.dart.dto.DartCompanyResponse;

@Component
public class DartClient {

    private final RestClient restClient;
    private final String apiKey;

    public DartClient(
            @Value("${dart.api.base-url}") String baseUrl,
            @Value("${dart.api.key}") String apiKey
    ) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();

        this.apiKey = apiKey;
    }

    public DartCompanyResponse getCompany(String corpCode) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/company.json")
                        .queryParam("crtfc_key", apiKey)
                        .queryParam("corp_code", corpCode)
                        .build())
                .retrieve()
                .body(DartCompanyResponse.class);
    }
}