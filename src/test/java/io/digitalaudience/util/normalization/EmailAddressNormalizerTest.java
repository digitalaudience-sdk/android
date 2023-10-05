package io.digitalaudience.util.normalization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailAddressNormalizerTest {
    private StringNormalizer emailAddressNormalizer;
    @BeforeEach
    void setUp() {
        emailAddressNormalizer = new EmailAddressNormalizer();
    }

    @Test
    void testNormalizeLowerCase() {
        final var input = "test@digitalaudience.io";
        final var expectedOutput = "test@digitalaudience.io";

        final var output = emailAddressNormalizer.normalize(input);

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }

    @Test
    void testNormalizeToLowerCase() {
        final var input = "TEST@digitalAudience.io";
        final var expectedOutput = "test@digitalaudience.io";

        final var output = emailAddressNormalizer.normalize(input);

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }

    @Test
    void testNormalizeSuffix() {
        final var input = "test+123456@digitalaudience.io";
        final var expectedOutput = "test@digitalaudience.io";

        final var output = emailAddressNormalizer.normalize(input);

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }

    @Test
    void testNormalizeTrimming() {
        final var input = " test@digitalaudience.io ";
        final var expectedOutput = "test@digitalaudience.io";

        final var output = emailAddressNormalizer.normalize(input);

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly normalized.");
    }
}