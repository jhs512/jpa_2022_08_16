package com.ll.exam.sbb.base.entity;

import java.time.LocalDateTime;

public interface BaseEntityInterface {
    Long getId();
    LocalDateTime getCreatedDate();
    LocalDateTime getModifiedDate();
}
