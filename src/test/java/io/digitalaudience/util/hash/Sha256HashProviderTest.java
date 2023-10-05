package io.digitalaudience.util.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Sha256HashProviderTest {
    private HashProvider sha256HashProvider;

    @BeforeEach
    void setUp() {
        sha256HashProvider = new Sha256HashProvider();
    }

    @Test
    void testGetHashLowerCase() {
        final var input = "test@digitalaudience.io";
        final var expectedOutput = "343e00121b70bc1a6ea179468f63beed780a92122402478037b9366a677ab24a";

        final var output = sha256HashProvider.getHash(input);

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly hashed.");
    }

    @Test
    void testGetHashUpperCase() {
        final var input = "TEST@DIGITALAUDIENCE.IO";
        final var expectedOutput = "8c887d4a4d632aeab700022ede9c166c500589e369eaff17796c042b8b0733f1";

        final var output = sha256HashProvider.getHash(input);

        Assertions.assertEquals(output, expectedOutput, "The String is not correctly hashed.");
    }
}