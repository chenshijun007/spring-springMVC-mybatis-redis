package com.hanboard.util;

import org.springframework.data.redis.connection.RedisConnectionCommands;

/**
 * Created by csj on 2017/8/22.
 */
public class RedisConfig implements RedisConnectionCommands {
    @Override
    public void select(int i) {

    }

    @Override
    public byte[] echo(byte[] bytes) {
        return new byte[0];
    }

    @Override
    public String ping() {
        return null;
    }
}
