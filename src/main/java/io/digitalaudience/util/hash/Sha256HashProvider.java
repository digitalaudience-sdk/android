package io.digitalaudience.util.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Provides injectable SHA-256 implementation
 */
public class Sha256HashProvider implements HashProvider {
    /**
     * Calculates SHA-256 hash from provided input
     *
     * @param input Input to calculate hash from
     * @return SHA-256 lowercase hash value of provided input
     */
    @Override
    public String getHash(String input) {
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        var messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));

        return HexFormat.of().formatHex(messageDigest);
    }
}
