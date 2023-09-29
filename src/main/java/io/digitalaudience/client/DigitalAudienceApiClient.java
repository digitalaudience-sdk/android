package io.digitalaudience.client;

import java.util.concurrent.CompletableFuture;

/**
 * Describes Web API client for digitalAudience endpoints
 */
public interface DigitalAudienceApiClient {
    /**
     * Sends user device ID and hashed email address with associated categories to digitalAudience
     *
     * @param request    User details to send to digitalAudience
     * @return Body of the HTTP response. Empty string should be also counted as a correct response
     */
    CompletableFuture<String> sendAndroidDeviceIdAsync(SendAndroidDeviceIdRequest request);
}