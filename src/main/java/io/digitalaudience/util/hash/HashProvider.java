package io.digitalaudience.util.hash;

/**
 * Describes Hashing algorithm provider
 */
public interface HashProvider {
    /**
     * Calculates hash from provided input
     * @param input Input to calculate hash from
     * @return Hash value of provided input
     */
    String getHash(String input);
}
