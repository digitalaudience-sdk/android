package io.digitalaudience;

import java.util.concurrent.CompletableFuture;

/**
 * Describes Web API client for digitalAudience endpoints
 */
public interface DigitalAudienceApiClient {
    /**
     * Sends user device ID and hashed email address with associated categories to digitalAudience
     * @param deviceId Android device ID
     * @param emailSha256 Normalized email address SHA256 checksum which is connected to device user. Normalization rules can be found on digitalAudience documentation portal
     * @param categories One or more categories user should become associated with. Categories must be communicated with digitalAudience in advance
     * @return Body of the HTTP response. Empty string should be also counted as a correct response
     */
    CompletableFuture<String> sendAndroidDeviceIdAsync(String deviceId, String emailSha256, String[] categories);
}
