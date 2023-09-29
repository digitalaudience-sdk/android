package io.digitalaudience.util.normalization;

/**
 * Implements email address string normalization rules
 */
public class EmailAddressNormalizer implements StringNormalizer {
    /**
     * Transforms input into clean, normalized and ready to consume value
     *
     * @param input Input to normalize
     * @return Normalized value
     */
    @Override
    public String normalize(String input) {
        return input.replaceFirst("\\+[^@]+", "").trim().toLowerCase();
    }
}
