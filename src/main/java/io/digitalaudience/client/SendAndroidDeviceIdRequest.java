package io.digitalaudience.client;

/**
 * @param deviceId    User's Android device ID
 * @param emailSha256 SHA-256 hash value from normalized user's email address
 * @param categories  One or more categories user should become associated with. Categories must be communicated with digitalAudience in advance
 */
public record SendAndroidDeviceIdRequest(String deviceId, String emailSha256, String[] categories) {
}
