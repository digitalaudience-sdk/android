package io.digitalaudience;

/**
 * Contains usage example of digitalAudience Web API client
 */
public class Main {
    private static final String PublisherId = "Dap_220620"; // "Dap_220620"

    /**
     * Contains usage example of digitalAudience Web API client
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        final DigitalAudienceApiClientOptions digitalAudienceApiClientOptions = new DigitalAudienceApiClientOptions(PublisherId);
        final DigitalAudienceApiClient digitalAudienceApiClient = new DigitalAudienceApiClientImplementation(digitalAudienceApiClientOptions);

        final String response = digitalAudienceApiClient.sendAndroidDeviceIdAsync(
                "5edb056b-b92b-45c1-bf9e-41e31a85e9b1" /* deviceId */,
                "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08" /* emailSha256 */,
                new String[]{"1", "2"} /* categories */
        ).join();

        System.out.println("response = " + response);
    }
}