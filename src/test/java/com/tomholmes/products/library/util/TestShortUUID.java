package com.tomholmes.products.library.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TestShortUUID
{
    @Test
    public void testShortUUID()
    {
        String test = ShortUUID.shortUUID();
        assertNotNull(test);
    }

}
