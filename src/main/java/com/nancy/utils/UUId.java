package com.nancy.utils;

import java.util.UUID;

public class UUId {
    public UUId() {
    }

    public static String getUUid() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
