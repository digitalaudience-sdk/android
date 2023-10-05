package io.digitalaudience;

import io.digitalaudience.client.DigitalAudienceApiClient;
import io.digitalaudience.client.DigitalAudienceApiClientImpl;
import io.digitalaudience.client.DigitalAudienceApiClientOptions;
import io.digitalaudience.client.SendAndroidDeviceIdRequest;
import io.digitalaudience.util.hash.HashProvider;
import io.digitalaudience.util.hash.Sha256HashProvider;
import io.digitalaudience.util.normalization.EmailAddressNormalizer;
import io.digitalaudience.util.normalization.StringNormalizer;

/**
 * Contains usage example of digitalAudience Web API client
 */
public class Main {
    private static final String PUBLISHER_ID = ""; // TODO: set your publisher ID from digitalAudience

    /**
     * Contains usage example of digitalAudience Web API client
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        final String deviceId = "00000000-0000-0000-0000-000000000000"; // TODO: replace with your logic here to get user's device ID

        final StringNormalizer emailAddressNormalizer = new EmailAddressNormalizer();
        final HashProvider sha256HashProvider = new Sha256HashProvider();

        final String emailAddress = "test@digitalaudience.io"; // TODO: replace with your logic to get user's email address
        final String normalizedEmailAddress = emailAddressNormalizer.normalize(emailAddress);
        final String emailSha256 = sha256HashProvider.getHash(normalizedEmailAddress);

        final String[] categories = new String[]{"1", "2"}; // TODO: replace with your logic to get categories you want to associate user with

        final DigitalAudienceApiClientOptions digitalAudienceApiClientOptions = new DigitalAudienceApiClientOptions(PUBLISHER_ID);
        final DigitalAudienceApiClient digitalAudienceApiClient = new DigitalAudienceApiClientImpl(digitalAudienceApiClientOptions);

        final SendAndroidDeviceIdRequest sendAndroidDeviceIdRequest = new SendAndroidDeviceIdRequest(deviceId, emailSha256, categories);

        final String response = digitalAudienceApiClient.sendAndroidDeviceIdAsync(sendAndroidDeviceIdRequest).join();

        System.out.println("response = " + response);
    }
}