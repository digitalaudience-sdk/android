package io.digitalaudience.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;

/**
 * Contains implementation of digitalAudience Web API client
 */
public class DigitalAudienceApiClientImpl implements DigitalAudienceApiClient {
    private static final String ApiBaseUrl = "https://target.digitalaudience.io/bakery/bake"; // "http://localhost:53213/bakery/bake";

    private final DigitalAudienceApiClientOptions options;

    /**
     * Initializes new Web API client for digitalAudience endpoints
     *
     * @param options Web API client options
     */
    public DigitalAudienceApiClientImpl(DigitalAudienceApiClientOptions options) {
        this.options = options;
    }

    private HttpRequest createPublisherHttpRequest(String deviceId, String emailSha256, String[] categories) {
        return HttpRequest.newBuilder()
                .uri(URI.create(MessageFormat.format("{0}?publisher={1}&did={2}&dtype=AAID&email={3}&category=[{4}]", ApiBaseUrl, options.publisherId(), deviceId, emailSha256, String.join(",", categories))))
                .build();
    }

    // https://stackoverflow.com/questions/40485398/retry-logic-with-completablefuture
    private CompletableFuture<String> sendAsync(HttpRequest httpRequest) {
        var client = HttpClient.newBuilder().build();

        return client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
    }

    @Override
    public CompletableFuture<String> sendAndroidDeviceIdAsync(SendAndroidDeviceIdRequest request) {
        return sendAsync(createPublisherHttpRequest(request.deviceId(), request.emailSha256(), request.categories()));
    }
}

