package io.digitalaudience.util.normalization;

/**
 * Describes string normalizer
 */
public interface StringNormalizer {
    /**
     * Transforms input into clean, normalized and ready to consume value
     *
     * @param input Input to normalize
     * @return Normalized value
     */
    String normalize(String input);
}
