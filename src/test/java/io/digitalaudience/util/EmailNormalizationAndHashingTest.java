package io.digitalaudience.util;

import io.digitalaudience.util.hash.HashProvider;
import io.digitalaudience.util.hash.Sha256HashProvider;
import io.digitalaudience.util.normalization.EmailAddressNormalizer;
import io.digitalaudience.util.normalization.StringNormalizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailAddressNormalizerTest {
    private StringNormalizer emailAddressNormalizer;
    private HashProvider sha256HashProvider;

    @BeforeEach
    void setUp() {
        emailAddressNormalizer = new EmailAddressNormalizer();
        sha256HashProvider = new Sha256HashProvider();
    }

    @Test
    void testNormalizeLowerCase() {
        final var input = "test@digitalaudience.io";
        final var expectedOutput = "343e00121b70bc1a6ea179468f63beed780a92122402478037b9366a677ab24a";

        final var output = sha256HashProvider.getHash(emailAddressNormalizer.normalize(input));

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }

    @Test
    void testNormalizeToLowerCase() {
        final var input = "TEST@digitalAudience.io";
        final var expectedOutput = "343e00121b70bc1a6ea179468f63beed780a92122402478037b9366a677ab24a";

        final var output = sha256HashProvider.getHash(emailAddressNormalizer.normalize(input));

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }

    @Test
    void testNormalizeSuffix() {
        final var input = "test+123456@digitalaudience.io";
        final var expectedOutput = "343e00121b70bc1a6ea179468f63beed780a92122402478037b9366a677ab24a";

        final var output = sha256HashProvider.getHash(emailAddressNormalizer.normalize(input));

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }

    @Test
    void testNormalizeTrimming() {
        final var input = " test@digitalaudience.io ";
        final var expectedOutput = "343e00121b70bc1a6ea179468f63beed780a92122402478037b9366a677ab24a";

        final var output = sha256HashProvider.getHash(emailAddressNormalizer.normalize(input));

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }
}