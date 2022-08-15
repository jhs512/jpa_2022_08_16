package com.ll.exam.sbb.genfile.entity;

public interface GenFileRelated {
    default public String getTypeCode() {
        return "MEMBER";
    }

    default public String getName() {
        return "MEMBER";
    }

    default public String getValue() {
        return "MEMBER";
    }
}
