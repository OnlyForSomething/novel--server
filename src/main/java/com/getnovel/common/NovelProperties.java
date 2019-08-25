package com.getnovel.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NovelProperties {
    @Value("${encrypt.body.aes-key}")
    private String aesKey;

    public String getAesKey() {
        return aesKey;
    }
    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }
}
