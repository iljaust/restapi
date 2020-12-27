package com.iljaust.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public enum AccountStatus {
    ACTIVE,BANNED,DELETED
}
