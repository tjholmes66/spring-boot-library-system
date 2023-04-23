package com.tomholmes.products.library.util;

import java.nio.ByteBuffer;
import java.util.UUID;

public class ShortUUID
{
    /**
     * Generate short UUID (13 characters)
     * 
     * @return short UUID
     */
    public final static String shortUUID()
    {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }
}
